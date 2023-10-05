package net.bussab.MagicMod.util;

import java.util.Map;
import java.util.function.Predicate;

import net.bussab.MagicMod.block.ModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class CrucibleInteractions implements CauldronInteraction {

   
   public static Map<Item, CauldronInteraction> cEMPTY = CauldronInteraction.newInteractionMap();
   public static Map<Item, CauldronInteraction> cWATER = CauldronInteraction.newInteractionMap();

   @Override
   public InteractionResult interact(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer,
            InteractionHand pHand, ItemStack pStack) {

        return CauldronInteraction.emptyBucket(pLevel, pBlockPos, pPlayer, pHand, pStack, ModBlocks.WATER_CRUCIBLE.get().defaultBlockState(), SoundEvents.BUCKET_EMPTY);

    }
    
   public static void boostrap(){
        cEMPTY.put(Items.WATER_BUCKET, new CrucibleInteractions());
        cWATER.put(Items.BUCKET, (p_175725_, p_175726_, p_175727_, p_175728_, p_175729_, p_175730_) -> {
         return fillBucket(p_175725_, p_175726_, p_175727_, p_175728_, p_175729_, p_175730_, new ItemStack(Items.WATER_BUCKET), (p_175660_) -> {
            return true;
         }, SoundEvents.BUCKET_FILL);
      });
    }
   static InteractionResult fillBucket(BlockState pBlockState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, ItemStack pEmptyStack, ItemStack pFilledStack, Predicate<BlockState> pStatePredicate, SoundEvent pFillSound) {
      if (!pStatePredicate.test(pBlockState)) {
         return InteractionResult.PASS;
      } else {
         if (!pLevel.isClientSide) {
            Item item = pEmptyStack.getItem();
            pPlayer.setItemInHand(pHand, ItemUtils.createFilledResult(pEmptyStack, pPlayer, pFilledStack));
            pPlayer.awardStat(Stats.USE_CAULDRON);
            pPlayer.awardStat(Stats.ITEM_USED.get(item));
            pLevel.setBlockAndUpdate(pPos, ModBlocks.CRUCIBLE.get().defaultBlockState());
            pLevel.playSound((Player)null, pPos, pFillSound, SoundSource.BLOCKS, 1.0F, 1.0F);
            pLevel.gameEvent((Entity)null, GameEvent.FLUID_PICKUP, pPos);
         }

         return InteractionResult.sidedSuccess(pLevel.isClientSide);
      }
   }
}
