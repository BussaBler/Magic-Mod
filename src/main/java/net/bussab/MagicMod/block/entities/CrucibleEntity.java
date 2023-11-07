package net.bussab.MagicMod.block.entities;

import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import net.bussab.MagicMod.essentia.Essentia;
import net.bussab.MagicMod.essentia.EssentiaList;
import net.bussab.MagicMod.essentia.EssentiaRegister;
import net.bussab.MagicMod.recipe.CrucibleRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.fluids.capability.templates.FluidTank;

public class CrucibleEntity extends BlockEntity  {
    
    
    private int HEAT;
    public final FluidTank FLUID_TANK = createFluidTank();
    private EssentiaList essentiaList = new EssentiaList();

    private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.empty();

    public CrucibleEntity( BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CRUCIBLE_BE.get(), pPos, pBlockState);
        
        
    }

    private FluidTank createFluidTank() {
        return new FluidTank(1000){
            @Override
            protected void onContentsChanged(){
                setChanged();
                if(!level.isClientSide()){
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
            }
            @Override
            public boolean isFluidValid(FluidStack pStack){
                return pStack.getFluid() == Fluids.WATER;
            }
        };
    }

    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side){
        if(cap == ForgeCapabilities.FLUID_HANDLER) {
            return lazyFluidHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    public int getTank(){
        return this.FLUID_TANK.getFluidAmount();
    }

    public int getTankSize(){
        return this.FLUID_TANK.getCapacity();
    }
    

    public void fillTank(FluidStack fStack){
        this.FLUID_TANK.fill(new FluidStack(fStack.getFluid(), fStack.getAmount()), IFluidHandler.FluidAction.EXECUTE);
    }
    
    

    public void onLoad(){
        super.onLoad();
        lazyFluidHandler = LazyOptional.of(()-> FLUID_TANK);
    }

    public void invalidateCaps(){
        super.invalidateCaps();
        lazyFluidHandler.invalidate();
    }

    protected void saveAdditional(CompoundTag pTag){
        
        pTag.putInt("heat", this.HEAT);
        pTag = FLUID_TANK.writeToNBT(pTag);
        
        writeEssentiaToNBT(pTag, this.essentiaList);

        super.saveAdditional(pTag);
        
    }

    public void load(CompoundTag pTag){
        super.load(pTag);
        

        this.HEAT = pTag.getInt("heat");
        this.FLUID_TANK.readFromNBT(pTag);
        readEssentiaFromNBT(pTag);
        
        

    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
    
    @Override 
    public Packet<ClientGamePacketListener> getUpdatePacket(){
        return ClientboundBlockEntityDataPacket.create(this);
    }
    
    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt){
        super.onDataPacket(net, pkt);
    }
    
    
    public int getHeat(){
        return this.HEAT;
    }

    public EssentiaList getEssentiaList(){
        
        return this.essentiaList;
        
    }

    public void emptyEssentia(){
        this.essentiaList = new EssentiaList();
        this.level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        setChanged(level, worldPosition, this.getBlockState());
    }


    public void tick(Level pLevel, BlockPos pPos, BlockState pState1) {
        
        
        if (this.FLUID_TANK.getFluidAmount() > 0){
            BlockState block = pLevel.getBlockState(pPos.below());
            
            if (block == Blocks.LAVA.defaultBlockState() || block == Blocks.FIRE.defaultBlockState() || block == Blocks.MAGMA_BLOCK.defaultBlockState()){
                if (this.HEAT < 200){
                    ++this.HEAT;
                    this.level.sendBlockUpdated(pPos, pState1, pState1, 3);
                    setChanged(pLevel, pPos, pState1);
                    
                }
            }
            
            else if (this.HEAT > 0){
                    --this.HEAT;
                    this.level.sendBlockUpdated(pPos, pState1, pState1, 3);
                    setChanged(pLevel, pPos, pState1);
            }
            
        }
    }
    
    public void attemptSmelt(ItemEntity item, Vec3 pVec3) {
        
        Item pItem = item.getItem().getItem();
        
        int size = item.getItem().getCount();
        

        for (int i = 0; i < size; i++){
            CrucibleRecipes CR = CrucibleRecipes.findMatchingRecipe(pItem, essentiaList, level);

            if (CR!=null && getTank()>0){
                
                ItemStack out = CR.getOutput().copy();
                for (Essentia E: CR.getEssentiaList().getEssentias()){
                   essentiaList.reduce(E, CR.getEssentiaList().getAmount(E)); 
                }
                FLUID_TANK.drain(50, FluidAction.EXECUTE);
                ejectItem(out, pVec3);
                
                --size;
                setChanged(level, worldPosition, getBlockState());
            }
            
            else {
                EssentiaList eL =  EssentiaRegister.getObjectTag(pItem.getDefaultInstance());
                if (eL != null){
                    
                    for (Essentia E: eL.getEssentias()){
                        essentiaList.add(E, eL.getAmount(E));
                    }
                    if (!level.isClientSide()) level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
                    item.kill();
                    setChanged();
                }
            }
            item.getItem().setCount(size);
        }
        
        level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        
    }

    private void ejectItem(ItemStack out, Vec3 pVec3) {

        ItemStack Item = out.copy();
        ItemEntity itemEntity = new ItemEntity(level, getBlockPos().getX()+0.5, getBlockPos().getY()+0.5, getBlockPos().getZ()+0.5, Item);
        itemEntity.spawnAtLocation(Item, 0);
        itemEntity.setDeltaMovement(-pVec3.x+0.3, -pVec3.y+0.1, -pVec3.z+0.3);
        



    }


    private void writeEssentiaToNBT(CompoundTag pTag, EssentiaList list){
        ListTag lTag = new ListTag();
        
        pTag.put("Essentia", lTag);
        
        
        for (Essentia E: list.getEssentias()){
            
            CompoundTag T = new CompoundTag();
            T.putString("key", E.getName());
            T.putInt("amount", list.getAmount(E));
            lTag.add(T);
        }
        
    }
    
    private void readEssentiaFromNBT(CompoundTag pTag){
        EssentiaList tempEssentiaList = new EssentiaList();
        ListTag lTag = pTag.getList("Essentia", (byte)10);
            for (int i = 0; i < lTag.size(); i++){
                CompoundTag T = lTag.getCompound(i);
                 
                tempEssentiaList.add(Essentia.getEssentia(T.getString("key")), T.getInt("amount"));
                
            }
        this.essentiaList = tempEssentiaList; 
    }
    
     
    
}
