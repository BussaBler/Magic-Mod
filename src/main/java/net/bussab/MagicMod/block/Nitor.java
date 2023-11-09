package net.bussab.MagicMod.block;

import net.bussab.MagicMod.block.entities.NitorEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class Nitor extends BaseEntityBlock {

    public MapColor dye; 

    public Nitor(Properties pProperties, MapColor pColor) {
        super(pProperties);
        this.dye = pColor; 

    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        
        return new NitorEntity(pPos, pState);
    }

    public MapColor getColor(){
        return this.dye;
    }
    
}   
