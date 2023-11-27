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

    public static final RegistryObject<Block> NITOR = registerBlock("nitor",
    ()-> new Nitor(BlockBehaviour.Properties.copy(Blocks.RED_WOOL), "FF7800"));

    public static final RegistryObject<Block> PURPLE_NITOR = registerBlock("purple_nitor", ()-> new Nitor(BlockBehaviour.Properties.copy(Blocks.RED_WOOL), "6F00FF"));

    public static final RegistryObject<Block> GREEN_NITOR = registerBlock("green_nitor", ()-> new Nitor(BlockBehaviour.Properties.copy(Blocks.RED_WOOL), "2BFF39"));

    public static final RegistryObject<Block> BLUE_NITOR = registerBlock("blue_nitor", ()-> new Nitor(BlockBehaviour.Properties.copy(Blocks.RED_WOOL), "0000FF"));

    public static final RegistryObject<Block> PINK_NITOR = registerBlock("pink_nitor", ()-> new Nitor(BlockBehaviour.Properties.copy(Blocks.RED_WOOL), "FF47E5"));

    public static final RegistryObject<Block> RED_NITOR = registerBlock("red_nitor", ()-> new Nitor(BlockBehaviour.Properties.copy(Blocks.RED_WOOL), "FF0000"));

    public static final RegistryObject<Block> BLACK_NITOR = registerBlock("black_nitor", ()-> new Nitor(BlockBehaviour.Properties.copy(Blocks.RED_WOOL), "13002B"));

    public static final RegistryObject<Block> WHITE_NITOR = registerBlock("white_nitor", ()-> new Nitor(BlockBehaviour.Properties.copy(Blocks.RED_WOOL), "FFFFFF"));

    

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
