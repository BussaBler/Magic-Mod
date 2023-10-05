package net.bussab.MagicMod.block;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import net.bussab.MagicMod.item.ModItems;
import net.bussab.MagicMod.util.CrucibleInteractions;
import net.minecraft.client.renderer.texture.Tickable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;

public class WaterCrucible extends LayeredCauldronBlock {

public static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_CAULDRON;
public static final Map<Item, Integer> ESSENTIA = new HashMap<>();





    public WaterCrucible(Properties pProperties, Predicate<Precipitation> pFillPredicate) {
        super(pProperties, pFillPredicate, CrucibleInteractions.cWATER);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, Integer.valueOf(3)));
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pBlockPos, Entity pEntity){
        if (pEntity instanceof ItemEntity itemEntity && itemEntity.getItem().getItem() == ModItems.FIRE_CRYSTAL.get()){
            ESSENTIA.put(ModItems.FIRE_CRYSTAL.get(), 1);
            pEntity.kill();
        }
        if (pEntity instanceof ItemEntity itemEntity && itemEntity.getItem().getItem() == ModItems.BLANK_SHARD.get()){
            int value = ESSENTIA.get(ModItems.FIRE_CRYSTAL.get());
            if (value>0){
                ItemEntity pItemEntity = (ItemEntity) pEntity;
                pItemEntity.setItem(ModItems.FIRE_SHARD.get().getDefaultInstance());
                Vec3 Mov = pItemEntity.getDeltaMovement();
                pItemEntity.setDeltaMovement(-Mov.x, -Mov.y, -Mov.z);
                
            }
        }
    }
    public double getContentHight(){
        return 0.9D;
    }
    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom){
        BlockPos blockpos = PointedDripstoneBlock.findStalactiteTipAboveCauldron(pLevel, pPos);

        if (blockpos != null) {
            
        Fluid fluid = PointedDripstoneBlock.getCauldronFillFluidType(pLevel, blockpos);

            if (fluid != Fluids.EMPTY && this.canReceiveStalactiteDrip(fluid)) {
                this.receiveStalactiteDrip(pState, pLevel, pPos, fluid);
            }
        }
        Block block = pLevel.getBlockState(pPos.below()).getBlock();
        while (block == Blocks.LAVA || block == Blocks.FIRE || block == Blocks.MAGMA_BLOCK){
            pLevel.sendParticles(ParticleTypes.BUBBLE, pPos.getX(), pPos.getY()+1, pPos.getZ(), 20, 0, 0, 0, 1F);
        }

    }

}
