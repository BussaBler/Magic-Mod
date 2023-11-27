package net.bussab.MagicMod.events;

import net.bussab.MagicMod.MagicMod;
import net.bussab.MagicMod.block.ModBlocks;
import net.bussab.MagicMod.block.entities.ModBlockEntities;
import net.bussab.MagicMod.block.entities.renderer.CrucibleBERenderer;
import net.bussab.MagicMod.block.entities.renderer.NitorBERenderer;
import net.bussab.MagicMod.item.armour.model.GogglesModel;
import net.bussab.MagicMod.item.armour.model.ModModelLayers;
import net.bussab.MagicMod.particles.CrucibleBubble;
import net.bussab.MagicMod.particles.ModParticles;
import net.bussab.MagicMod.particles.NitorFlames;
import net.bussab.MagicMod.util.ModBlockColours;
import net.minecraft.client.color.item.ItemColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MagicMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
    
    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent pEvent){
        pEvent.registerSpriteSet(ModParticles.CRUCIBLE_BUBBLE.get(), CrucibleBubble.Provider::new);
        pEvent.registerSpriteSet(ModParticles.NITOR_FLAMES.get(), NitorFlames.Provider::new);
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers pEvent){
        pEvent.registerBlockEntityRenderer(ModBlockEntities.CRUCIBLE_BE.get(), CrucibleBERenderer::new);
        pEvent.registerBlockEntityRenderer(ModBlockEntities.NITOR_BE.get(), NitorBERenderer::new);
    }

    @SubscribeEvent 
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions pEvent){

        pEvent.registerLayerDefinition(ModModelLayers.GOGGLES, GogglesModel::createBodyLayer);

    }

    @SubscribeEvent 
    public static void registerColors(RegisterColorHandlersEvent.Item pEvent){
        
        ItemColor itemColor = new ModBlockColours();

        pEvent.register(itemColor, ModBlocks.NITOR.get(), ModBlocks.PURPLE_NITOR.get(), ModBlocks.GREEN_NITOR.get(), ModBlocks.BLUE_NITOR.get(), ModBlocks.PINK_NITOR.get()
        , ModBlocks.RED_NITOR.get(), ModBlocks.BLACK_NITOR.get(), ModBlocks.WHITE_NITOR.get());
        
    }

}
