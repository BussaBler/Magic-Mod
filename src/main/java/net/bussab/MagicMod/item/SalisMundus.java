package net.bussab.MagicMod.item;

import net.bussab.MagicMod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class SalisMundus extends Item {

    public SalisMundus(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResult useOn (UseOnContext pContext){
        BlockPos pBlockPos = pContext.getClickedPos();
        Block pBlock = pContext.getLevel().getBlockState(pBlockPos).getBlock();

        if (pBlock == Blocks.CAULDRON){
                
            pContext.getLevel().setBlockAndUpdate(pBlockPos, ModBlocks.CRUCIBLE.get().defaultBlockState());
            pContext.getItemInHand().shrink(1);

            return InteractionResult.sidedSuccess(pContext.getLevel().isClientSide());
        }
        else return InteractionResult.PASS;
    }

}
