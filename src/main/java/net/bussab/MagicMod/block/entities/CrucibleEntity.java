package net.bussab.MagicMod.block.entities;

import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;

public class CrucibleEntity extends BlockEntity  {
    
    private static int tickCount;
    private int HEAT;
    private final FluidTank FLUID_TANK = createFluidTank();

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
        CompoundTag NBT = new CompoundTag();

        NBT.putInt("heat", HEAT);
        NBT.putInt("tickcount", tickCount);
        NBT = FLUID_TANK.writeToNBT(NBT);
        
        pTag.put("tag1", NBT);
        super.saveAdditional(pTag);
    }

    public void load(CompoundTag pTag){
        super.load(pTag);
        CompoundTag NBT = pTag.getCompound("tag1");

        tickCount = NBT.getInt("tickcount");
        this.HEAT = NBT.getInt("heat");
        this.FLUID_TANK.readFromNBT(NBT);

    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag NBT = super.getUpdateTag();
        saveAdditional(NBT);
        return NBT;
    }
    
    @Override
    public void handleUpdateTag(CompoundTag pTag){
        load(pTag);
    }

    @Override 
    public Packet<ClientGamePacketListener> getUpdatePacket(){
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pPacket){
        handleUpdateTag(pPacket.getTag());
    }
    
    public int getHeat(){
        return this.HEAT;
    }




    public void tick(Level pLevel, BlockPos pPos, BlockState pState1) {
        
        
        if (this.FLUID_TANK.getFluidAmount() > 0){
            BlockState block = pLevel.getBlockState(pPos.below());
            
            if (block == Blocks.LAVA.defaultBlockState() || block == Blocks.FIRE.defaultBlockState() || block == Blocks.MAGMA_BLOCK.defaultBlockState()){
                if (this.HEAT < 200){
                    ++this.HEAT;
                    this.level.sendBlockUpdated(pPos, pState1, pState1, 3);
                }
            }
            
        }

        else if (this.HEAT > 0){
                --this.HEAT;
                this.level.sendBlockUpdated(pPos, pState1, pState1, 3);
        }
    }
    

    
     
    
}
