package net.bussab.MagicMod;

import com.mojang.logging.LogUtils;

import net.bussab.MagicMod.block.ModBlocks;
import net.bussab.MagicMod.block.entities.ModBlockEntities;
import net.bussab.MagicMod.essentia.ConfigEssentia;
import net.bussab.MagicMod.item.ModCreativeTab;
import net.bussab.MagicMod.item.ModItems;
import net.bussab.MagicMod.particles.ModParticles;
import net.bussab.MagicMod.recipe.ConfigRecipes;
import net.bussab.MagicMod.sound.ModSounds;
import net.bussab.MagicMod.util.CrucibleInteractions;
import net.bussab.MagicMod.util.ModBlockColours;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MagicMod.MOD_ID)
public class MagicMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "magicmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
   
    public MagicMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeTab.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModParticles.register(modEventBus);
        ModSounds.register(modEventBus);
       
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(()-> {
            CrucibleInteractions.bootStrap();
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            ConfigEssentia.postInit();
            ConfigRecipes.initializeAlchemyRecipes();

        
           
        }
        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block pEvent){
           
          
        }

        
       

    }
}
