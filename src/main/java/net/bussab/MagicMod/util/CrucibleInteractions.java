package net.bussab.MagicMod.util;

import java.util.Map;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.bussab.MagicMod.block.entities.CrucibleEntity;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public interface CrucibleInteractions {


    public static Map<Item, CrucibleInteractions> EMPTY = newInteractionMap();


    CrucibleInteractions FILL_WATER = (pLevel , pPos, pPlayer, pHand, pStack) -> {
        return emptyBucket(pLevel, pPos, pPlayer, pHand, pStack, SoundEvents.BUCKET_EMPTY);
    };
    CrucibleInteractions FILL_BUCKET = (pLevel , pPos, pPlayer, pHand, pStack) -> {
        return fillBucket(pLevel, pPos, pPlayer, pHand, pStack, SoundEvents.BUCKET_FILL);
    };
    
    InteractionResult interact(Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pHand, ItemStack pStack);

    static void bootStrap(){
        
        addDefaultInteractions(EMPTY);

    }




    static Object2ObjectOpenHashMap<Item, CrucibleInteractions> newInteractionMap() {
      return Util.make(new Object2ObjectOpenHashMap<>(), (p_175646_) -> {
         p_175646_.defaultReturnValue((p_175740_, p_175741_, p_175742_, p_175743_, p_175744_) -> {
            return InteractionResult.PASS;
         });
      });
   }

    static void addDefaultInteractions(Map<Item, CrucibleInteractions> pInteractionsMap){
        pInteractionsMap.put(Items.WATER_BUCKET, FILL_WATER);
        pInteractionsMap.put(Items.BUCKET, FILL_BUCKET);
    }

   static InteractionResult emptyBucket(Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, ItemStack pFilledStack, SoundEvent pEmptySound) {
      if (!pLevel.isClientSide) {
        
        CrucibleEntity blockEntity = ((CrucibleEntity)pLevel.getBlockEntity(pPos));

        pFilledStack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(IFluidHandlerItem -> {
            System.out.println(blockEntity.FLUID_TANK.getSpace());
            int drainAmount = Math.min(blockEntity.FLUID_TANK.getSpace(), 1000);
            FluidStack fStack = IFluidHandlerItem.drain(drainAmount, FluidAction.SIMULATE);
            if(fStack.getFluid() == Fluids.WATER){
                fStack = IFluidHandlerItem.drain(drainAmount, FluidAction.EXECUTE);
                blockEntity.fillTank(fStack);
                pPlayer.setItemInHand(pHand, ItemUtils.createFilledResult(pFilledStack, pPlayer, new ItemStack(IFluidHandlerItem.getContainer().getItem())));
                pLevel.playSound(null, pPos, pEmptySound, SoundSource.BLOCKS, 1f, 1f);
            }
        });

      }

      return InteractionResult.sidedSuccess(pLevel.isClientSide);

    }

    static InteractionResult fillBucket(Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, ItemStack pFilledStack, SoundEvent pFillSound){
        if (!pLevel.isClientSide) {

            CrucibleEntity blockEntity = ((CrucibleEntity)pLevel.getBlockEntity(pPos));

            pFilledStack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(IFluidHandlerItem -> {
                int fillAmount = IFluidHandlerItem.getTankCapacity(0);
                if (blockEntity.FLUID_TANK.getFluidAmount() >= fillAmount){
                    blockEntity.FLUID_TANK.drain(fillAmount, FluidAction.EXECUTE);
                    
                    pPlayer.setItemInHand(pHand, ItemUtils.createFilledResult(pFilledStack, pPlayer, new ItemStack(Items.WATER_BUCKET)));
                    pLevel.playSound(null, pPos, pFillSound, SoundSource.BLOCKS, 1f, 1f);
                }
            });
            
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }
}
