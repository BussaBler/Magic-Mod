package net.bussab.MagicMod.datagen.loot;

import java.util.Set;

import net.bussab.MagicMod.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    

    public void generate(){
        this.dropOther(ModBlocks.CRUCIBLE.get(), Items.CAULDRON);
        this.add(ModBlocks.CUSTOM_WATER.get(), noDrop());

    }


    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
