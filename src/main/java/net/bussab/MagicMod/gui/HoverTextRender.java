package net.bussab.MagicMod.gui;


import net.bussab.MagicMod.block.entities.ModBlockEntities;
import net.bussab.MagicMod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class HoverTextRender {

    public static boolean hovering = false;
    
    
    @SubscribeEvent
    public static void onPlayerEvent(EntityEvent pEvent){
        
        
        
        if (Minecraft.getInstance().player == null) return;

        Player player = Minecraft.getInstance().player;
        
        Entity E = Minecraft.getInstance().getCameraEntity();
        if (E != null){
            HitResult hit = E.pick(3, 0, false);
            
            if (hit.getType() == HitResult.Type.BLOCK){
            BlockPos blockpos = ((BlockHitResult)hit).getBlockPos();
            if (Minecraft.getInstance().level.getBlockEntity(blockpos)==null) return;
                if (Minecraft.getInstance().level.getBlockEntity(blockpos).getType() == ModBlockEntities.CRUCIBLE_BE.get()){
                    if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.GOGGLES.get()){
                        hovering = true;
                        return;
                    }
                }




        }
        }

        hovering = false;

    }
    }
 
