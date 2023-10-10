package net.bussab.MagicMod.item;

import java.util.HashMap;

import net.bussab.MagicMod.MagicMod;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    
    public static final HashMap<String, RegistryObject<Item>> shardCatalog = new HashMap<>();
    
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
    public static final RegistryObject<Item> ENTROPY_SHARD = ITEMS.register("entropy_shard", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORDER_SHARD = ITEMS.register("order_shard", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MANA_SHARD = ITEMS.register("mana_shard", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_SHARD = ITEMS.register("void_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_SHARD = ITEMS.register("light_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOTION_SHARD = ITEMS.register("motion_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COLD_SHARD = ITEMS.register("cold_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_SHARD = ITEMS.register("crystal_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_SHARD = ITEMS.register("metal_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIFE_SHARD = ITEMS.register("life_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DEATH_SHARD = ITEMS.register("death_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENERGY_SHARD = ITEMS.register("energy_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EXCHANGE_SHARD = ITEMS.register("exchange_shard", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGIC_SHARD = ITEMS.register("magic_shard", () -> new Item(new Item.Properties())); 
    public static final RegistryObject<Item> AURA_SHARD = ITEMS.register("aura_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALCHEMY_SHARD = ITEMS.register("alchemy_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLUX_SHARD = ITEMS.register("flux_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARKNESS_SHARD = ITEMS.register("darkness_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELDRITCH_SHARD = ITEMS.register("eldritch_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLIGHT_SHARD = ITEMS.register("flight_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLANT_SHARD = ITEMS.register("plant_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOOL_SHARD = ITEMS.register("tool_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRAFT_SHARD = ITEMS.register("craft_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MECHANISM_SHARD = ITEMS.register("mechanism_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TRAP_SHARD = ITEMS.register("trap_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SOUL_SHARD = ITEMS.register("soul_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MIND_SHARD = ITEMS.register("mind_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SENSES_SHARD = ITEMS.register("senses_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AVERSION_SHARD = ITEMS.register("aversion_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PROTECT_SHARD = ITEMS.register("protect_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DESIRE_SHARD = ITEMS.register("desire_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNDEAD_SHARD = ITEMS.register("undead_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BEAST_SHARD = ITEMS.register("beast_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAN_SHARD = ITEMS.register("man_shard", () -> new Item(new Item.Properties()));



    public static final RegistryObject<Item> SALIS_MUNDUS = ITEMS.register("salis_mundus", ()-> new SalisMundus(new Item.Properties()));
    public static final RegistryObject<Item> GOGGLES = ITEMS.register("goggles", ()-> new Goggles(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, (new Item.Properties())));


    ///////SIMBOLS///////

    public static final RegistryObject<Item> FIRE_SYMBOL = ITEMS.register("fire_symbol", ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> WATER_SYMBOL = ITEMS.register("water_symbol", ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> EARTH_SYMBOL = ITEMS.register("earth_symbol", ()-> new Item(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus pEventBus){
        ITEMS.register(pEventBus);
    }

    
    

    
    }       
