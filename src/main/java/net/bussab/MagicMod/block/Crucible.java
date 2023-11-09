package net.bussab.MagicMod.block;


import java.util.Map;

import net.bussab.MagicMod.block.entities.CrucibleEntity;
import net.bussab.MagicMod.block.entities.ModBlockEntities;
import net.bussab.MagicMod.particles.ModParticles;
import net.bussab.MagicMod.util.CrucibleInteractions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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

public class Crucible extends BaseEntityBlock  {

    public static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_CAULDRON;
    
    protected static final int FLOOR_LEVEL = 4;
    private static final VoxelShape INSIDE = box(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    protected static final VoxelShape SHAPE = Shapes.join(Shapes.block(), Shapes.or(box(0.0D, 0.0D, 4.0D, 16.0D, 3.0D, 12.0D), box(4.0D, 0.0D, 0.0D, 12.0D, 3.0D, 16.0D), box(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D), INSIDE), BooleanOp.ONLY_FIRST);
   
    private final Map<Item, CrucibleInteractions> interactions;
    
    public Crucible(Properties pProperties, Map<Item, CrucibleInteractions> pInteractions) {

        super(pProperties);
        this.interactions = pInteractions;
        
        
    }
    protected double getContentHeight(BlockState pState) {
        return 0.0D;
     }

    protected boolean isEntityInsideContent(BlockState pState, BlockPos pPos, Entity pEntity) {
      return pEntity.getY() < (double)pPos.getY() + this.getContentHeight(pState) && pEntity.getBoundingBox().maxY > (double)pPos.getY() + 0.25D;
    } 
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

      

      if (pLevel.isClientSide()){
        if ((pPlayer.isShiftKeyDown() && pPlayer.getItemInHand(pHand).isEmpty()))
           return InteractionResult.SUCCESS;
      }

      
      if (!pLevel.isClientSide()){
        if (pPlayer.isShiftKeyDown() && pPlayer.getItemInHand(pHand).isEmpty()){
            ((CrucibleEntity)pLevel.getBlockEntity(pPos)).emptyEssentia();
            return InteractionResult.sidedSuccess(pLevel.isClientSide());
        }

      }
      
      ItemStack stack = pPlayer.getItemInHand(pHand);
      CrucibleInteractions cInteractions = this.interactions.get(stack.getItem());
      return cInteractions.interact(pLevel, pPos, pPlayer, pHand, stack);
      
      
    }

    @Override
    public void entityInside(BlockState pBlockState,Level pLevel, BlockPos pPos, Entity pEntity){
        CrucibleEntity CE = ((CrucibleEntity)pLevel.getBlockEntity(pPos));
        
        if (pEntity instanceof ItemEntity && !pLevel.isClientSide()){
          ItemEntity itemEntity = ((ItemEntity)pEntity);
          CE.attemptSmelt(itemEntity, itemEntity.getDeltaMovement());
          
        }
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
    @Deprecated
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
      
      
      
      pLevel.addAlwaysVisibleParticle(simpleParticleType, true, pPos.getX()+randomSource.nextDouble()-(3/16), (double)pPos.getY()+1, pPos.getZ()+randomSource.nextDouble()-(3/16), 0d, 0d, 0d);
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom){
      
      CrucibleEntity pBlockEntity = (CrucibleEntity) pLevel.getBlockEntity(pPos);
      
      
      if (pBlockEntity.getHeat() == 200 && pBlockEntity.getTank()>0){
          if (pRandom.nextDouble() > 0.5D)
          pLevel.playLocalSound(pPos, SoundEvents.LAVA_POP, SoundSource.BLOCKS, 0.3f, 1f, false);
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