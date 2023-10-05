package net.bussab.MagicMod.datagen;

import java.util.List;
import java.util.Set;

import net.bussab.MagicMod.datagen.loot.ModBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ModLootTableProvider {

    public static LootTableProvider create(PackOutput packOutput){
        return new LootTableProvider(packOutput, Set.of(), List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)));
    }
}
