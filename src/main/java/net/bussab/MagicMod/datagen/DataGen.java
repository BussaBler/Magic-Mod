package net.bussab.MagicMod.datagen;

import java.util.concurrent.CompletableFuture;

import net.bussab.MagicMod.MagicMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MagicMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
    
    @SubscribeEvent
    public static void gatherData(GatherDataEvent pDataEvent){
        DataGenerator generator = pDataEvent.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = pDataEvent.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = pDataEvent.getLookupProvider();

        generator.addProvider(pDataEvent.includeServer(), new ModRecipeProvider(output));
        generator.addProvider(pDataEvent.includeServer(), ModLootTableProvider.create(output));

        generator.addProvider(pDataEvent.includeClient(), new ModBlockStateProvider(output, helper));
        generator.addProvider(pDataEvent.includeClient(), new ModItemModelProvider(output, helper));


    }




}
