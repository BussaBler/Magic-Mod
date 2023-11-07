package net.bussab.MagicMod.block;

import java.util.function.Supplier;

import net.bussab.MagicMod.MagicMod;
import net.bussab.MagicMod.item.ModItems;
import net.bussab.MagicMod.util.CrucibleInteractions;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MagicMod.MOD_ID);

    public static final RegistryObject<Block> CRUCIBLE = registerBlock("crucible", 
    ()-> new Crucible(BlockBehaviour.Properties.copy(Blocks.CAULDRON), CrucibleInteractions.EMPTY));

    

    public static final RegistryObject<Block> CUSTOM_WATER = registerBlock("custom_water",
    ()-> new Block(BlockBehaviour.Properties.copy(Blocks.WATER)));


    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus pEventBus){
        BLOCKS.register(pEventBus);
    }

}
