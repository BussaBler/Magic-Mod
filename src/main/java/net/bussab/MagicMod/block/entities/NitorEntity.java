package net.bussab.MagicMod.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class NitorEntity extends BlockEntity {

    public NitorEntity( BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.NITOR_BE.get(), pPos, pBlockState);

    }
    
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {

    }
}
