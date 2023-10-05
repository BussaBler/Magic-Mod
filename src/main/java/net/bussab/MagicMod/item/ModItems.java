package net.bussab.MagicMod.item;

import net.bussab.MagicMod.MagicMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MagicMod.MOD_ID);
    
    public static final RegistryObject<Item> FIRE_CRYSTAL = ITEMS.register("fire_crystal", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AIR_CRYSTAL = ITEMS.register("air_crystal", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_CRYSTAL = ITEMS.register("water_crystal", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EARTH_CRYSTAL = ITEMS.register("earth_crystal", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARK_CRYSTAL = ITEMS.register("dark_crystal", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_CRYSTAL = ITEMS.register("light_crystal", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MANA_CRYSTAL = ITEMS.register("mana_crystal", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLANK_SHARD = ITEMS.register("blank_shard", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_SHARD = ITEMS.register("fire_shard", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AIR_SHARD = ITEMS.register("air_shard", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_SHARD = ITEMS.register("water_shard", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EARTH_SHARD = ITEMS.register("earth_shard", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARK_SHARD = ITEMS.register("dark_shard", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_SHARD = ITEMS.register("light_shard", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MANA_SHARD = ITEMS.register("mana_shard", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SALIS_MUNDUS = ITEMS.register("salis_mundus", ()-> new SalisMundus(new Item.Properties()));

    public static void register(IEventBus pEventBus){
        ITEMS.register(pEventBus);
    }


}
