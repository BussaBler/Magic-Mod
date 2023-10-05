package net.bussab.MagicMod.block;


import net.bussab.MagicMod.block.entities.CrucibleEntity;
import net.bussab.MagicMod.block.entities.ModBlockEntities;
import net.bussab.MagicMod.particles.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class Crucible extends BaseEntityBlock  {

    public static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_CAULDRON;
    
    protected static final int FLOOR_LEVEL = 4;
    private static final VoxelShape INSIDE = box(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    protected static final VoxelShape SHAPE = Shapes.join(Shapes.block(), Shapes.or(box(0.0D, 0.0D, 4.0D, 16.0D, 3.0D, 12.0D), box(4.0D, 0.0D, 0.0D, 12.0D, 3.0D, 16.0D), box(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D), INSIDE), BooleanOp.ONLY_FIRST);
    private static boolean SUCCESS;


    public Crucible(Properties pProperties) {
        super(pProperties);
        
        
    }
    protected double getContentHeight(BlockState pState) {
        return 0.0D;
     }

    protected boolean isEntityInsideContent(BlockState pState, BlockPos pPos, Entity pEntity) {
      return pEntity.getY() < (double)pPos.getY() + this.getContentHeight(pState) && pEntity.getBoundingBox().maxY > (double)pPos.getY() + 0.25D;
    } 
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

      SUCCESS = false;
      
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        CrucibleEntity CBE = (CrucibleEntity) pLevel.getBlockEntity(pPos);

        itemstack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(IFluidHandlerItem -> {

        int drainAmount = Math.min(CBE.getTank(), 1000);
        FluidStack fStack = IFluidHandlerItem.drain(drainAmount, IFluidHandler.FluidAction.SIMULATE);
        if (fStack.getFluid() == Fluids.WATER){
            fStack = IFluidHandlerItem.drain(drainAmount, IFluidHandler.FluidAction.EXECUTE);
            CBE.fillTank(fStack);
            pPlayer.setItemInHand(pHand, IFluidHandlerItem.getContainer());
            SUCCESS = true;
        }
          
        });
      
      if (SUCCESS == true) return InteractionResult.sidedSuccess(pLevel.isClientSide());
      
      else return InteractionResult.PASS;
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
      return SHAPE;
    }

    public VoxelShape getInteractionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
      return INSIDE;
    }

   /**
    * @deprecated call via {@link
    * net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase#hasAnalogOutputSignal} whenever possible.
    * Implementing/overriding is fine.
    */
    public boolean hasAnalogOutputSignal(BlockState pState) {
      return true;
    }

    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
      return false;
    }

    public boolean isFull(){
    return false;
    }
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
      BlockPos blockpos = PointedDripstoneBlock.findStalactiteTipAboveCauldron(pLevel, pPos);
      if (blockpos != null) {
         Fluid fluid = PointedDripstoneBlock.getCauldronFillFluidType(pLevel, blockpos);
         if (fluid != Fluids.EMPTY && this.canReceiveStalactiteDrip(fluid)) {
            this.receiveStalactiteDrip(pState, pLevel, pPos, fluid);
         }

      }
    }

    protected boolean canReceiveStalactiteDrip(Fluid pFluid) {
      return false;
    }

    protected void receiveStalactiteDrip(BlockState pState, Level pLevel, BlockPos pPos, Fluid pFluid) {
    }


    public static void makeParticles(Level pLevel, BlockPos pPos){

      SimpleParticleType simpleParticleType = ModParticles.CRUCIBLE_BUBBLE.get();
      RandomSource randomSource = pLevel.getRandom();
      
     
      pLevel.addAlwaysVisibleParticle(simpleParticleType, true, pPos.getX()+randomSource.nextDouble(), (double)pPos.getY()+1, pPos.getZ()+randomSource.nextDouble(), 0d, 0d, 0d);
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom){
      
      CrucibleEntity pBlockEntity = (CrucibleEntity) pLevel.getBlockEntity(pPos);
      
      
      if (pBlockEntity.getHeat() == 200){
          makeParticles(pLevel, pPos);
      }
    }

    

    /* BLOCK ENTITY */

    @Override
    public RenderShape getRenderShape(BlockState pState){
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMooving){
        if (pState.hasBlockEntity() && (!pState.is(pNewState.getBlock()) || !pNewState.hasBlockEntity())) {
            pLevel.removeBlockEntity(pPos);
        }
    }

    

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CrucibleEntity(pPos, pState);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel,BlockState pState, BlockEntityType<T> pBlockEntityType){
        if(pLevel.isClientSide) return null;

        return createTickerHelper(pBlockEntityType, ModBlockEntities.CRUCIBLE_BE.get(), (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }
}