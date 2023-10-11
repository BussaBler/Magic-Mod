package net.bussab.MagicMod.essentia;

import java.util.HashMap;

import javax.annotation.Nullable;

import net.bussab.MagicMod.item.ModItems;
import net.minecraft.world.item.Item;

public class Essentia {
    
    String name; 
    Essentia[] components;
    private int number;
    public static HashMap<String, Essentia> Dictonary = new HashMap<>();
    private static HashMap<Integer, Essentia> Enumeration = new HashMap<>();
    public static HashMap<Essentia, Item> ShardCatalog = new HashMap<>();
    public static HashMap<Essentia, Item> SymbolChart = new HashMap<>();


    public Essentia(String name, @Nullable Essentia[] components, int number, Item shard, Item symbol) {
        this.name = name;
        this.components = components;
        this.number = number;
        Dictonary.put(name, this);
        Enumeration.put(number, this);
        ShardCatalog.put(this, shard);
        SymbolChart.put(this, symbol);
    }



    public String getName() {
        return name;
    }



    public Essentia[] getComponents() {
        return components;
    }
    
    public static Essentia getEssentia(String key){
        return Dictonary.get(key);
    }

    public static Essentia getEssentia(int key){
        return Enumeration.get(key);
    }

    public int getNumber(){
        return number;
    }
    

    //////////////////PRIMARIA ESSENTIA//////////////////

    public static Essentia AIR = new Essentia("air", null, 1, ModItems.AIR_SHARD.get(), ModItems.AIR_SYMBOL.get());
    public static Essentia FIRE = new Essentia("ignis", null, 2, ModItems.FIRE_SHARD.get(), ModItems.FIRE_SYMBOL.get());
    public static Essentia WATER = new Essentia("aqua", null, 3, ModItems.WATER_SHARD.get(), ModItems.WATER_SYMBOL.get());
    public static Essentia EARTH = new Essentia("terra", null, 4, ModItems.EARTH_SHARD.get(), ModItems.EARTH_SYMBOL.get());
    public static Essentia ORDER = new Essentia("ordo", null, 5, ModItems.ORDER_SHARD.get(), ModItems.ORDER_SYMBOL.get());
    public static Essentia ENTROPY = new Essentia("perditio", null, 6, ModItems.ENTROPY_SHARD.get(), ModItems.ENTROPY_SYMBOL.get());

    

    //////////////////SECUNDAE ESSENTIA//////////////////

    public static Essentia VOID = new Essentia("vacuos", new Essentia[] {AIR, ENTROPY}, 7, ModItems.VOID_SHARD.get(), ModItems.VOID_SYMBOL.get());
    public static Essentia LIGHT = new Essentia("lux", new Essentia[] {AIR, FIRE}, 8, ModItems.LIGHT_SHARD.get(), ModItems.LIGHT_SYMBOL.get());
    public static Essentia MOTION = new Essentia("motus", new Essentia[] {AIR, ORDER}, 9, ModItems.MOTION_SHARD.get(), ModItems.MOTION_SYMBOL.get());
    public static Essentia COLD = new Essentia("gelum", new Essentia[] {FIRE, ENTROPY}, 10, ModItems.COLD_SHARD.get(), ModItems.COLD_SYMBOL.get());
    public static Essentia CRYSTAL = new Essentia("vitreus", new Essentia[] {EARTH, AIR}, 11, ModItems.CRYSTAL_SHARD.get(), ModItems.CRYSTAL_SYMBOL.get());
    public static Essentia METAL = new Essentia("metallum", new Essentia[] {EARTH, ORDER}, 12, ModItems.METAL_SHARD.get(), ModItems.METAL_SYMBOL.get());
    public static Essentia LIFE = new Essentia("victus", new Essentia[] {EARTH, WATER}, 13, ModItems.LIFE_SHARD.get(), ModItems.LIFE_SYMBOL.get());
    public static Essentia DEATH = new Essentia("mortuus", new Essentia[] {WATER, ENTROPY}, 14, ModItems.DEATH_SHARD.get(), ModItems.DEATH_SYMBOL.get());
    public static Essentia ENERGY = new Essentia("potentia", new Essentia[] {ORDER, FIRE}, 15, ModItems.ENERGY_SHARD.get(), ModItems.ENERGY_SYMBOL.get());
    public static Essentia EXCHANGE = new Essentia("permutatio", new Essentia[] {ENTROPY, ORDER}, 16, ModItems.EXCHANGE_SHARD.get(), ModItems.EXCHANGE_SYMBOL.get());
    
    
    //////////////////TERTIARIUS ESSENTIA//////////////////

    public static Essentia MAGIC = new Essentia("praecantatio", new Essentia[] {ENERGY, AIR}, 17, ModItems.MAGIC_SHARD.get(), ModItems.MAGIC_SYMBOL.get());
    public static Essentia AURA = new Essentia("auram", new Essentia[] {MAGIC, AIR}, 18, ModItems.AURA_SHARD.get(), ModItems.AURA_SYMBOL.get());
    public static Essentia ALCHEMY = new Essentia("alkimia", new Essentia[] {MAGIC, WATER}, 19, ModItems.ALCHEMY_SHARD.get(), ModItems.ALCHEMY_SYMBOL.get());
    public static Essentia FLUX = new Essentia("vitium", new Essentia[] {ENTROPY, MAGIC}, 20, ModItems.FLUX_SHARD.get(), ModItems.FLUX_SYMBOL.get());
    public static Essentia DARKNESS = new Essentia("tenebrae", new Essentia[] {VOID, LIGHT}, 21, ModItems.DARKNESS_SHARD.get(), ModItems.DARKNESS_SYMBOL.get());
    public static Essentia ELDRITCH = new Essentia("alienis", new Essentia[] {VOID, DARKNESS}, 22, ModItems.ELDRITCH_SHARD.get(), ModItems.ELDRITCH_SYMBOL.get());
    public static Essentia FLIGHT = new Essentia("volatus", new Essentia[] {AIR, MOTION}, 23, ModItems.FLIGHT_SHARD.get(), ModItems.FLIGHT_SYMBOL.get());
    public static Essentia PLANT = new Essentia("herba", new Essentia[] {LIFE, EARTH}, 24, ModItems.PLANT_SHARD.get(), ModItems.PLANT_SYMBOL.get());
    public static Essentia TOOL = new Essentia("instrumentum", new Essentia[] {METAL, ENERGY}, 25, ModItems.TOOL_SHARD.get(), ModItems.TOOL_SYMBOL.get());
    public static Essentia CRAFT = new Essentia("fabrico", new Essentia[] {EXCHANGE, TOOL}, 26, ModItems.CRAFT_SHARD.get(), ModItems.CRAFT_SYMBOL.get());
    public static Essentia MECHANISM = new Essentia("machina", new Essentia[] {MOTION, TOOL}, 27, ModItems.MECHANISM_SHARD.get(), ModItems.MECHANISM_SYMBOL.get());
    public static Essentia TRAP = new Essentia("vinculum", new Essentia[] {MOTION, ENTROPY}, 28, ModItems.TRAP_SHARD.get(), ModItems.TRAP_SYMBOL.get());
    public static Essentia SOUL = new Essentia("spiritus", new Essentia[] {LIFE, DEATH}, 29, ModItems.SOUL_SHARD.get(), ModItems.SOUL_SYMBOL.get());
    public static Essentia MIND = new Essentia("cognitio", new Essentia[] {FIRE, SOUL}, 30, ModItems.MIND_SHARD.get(), ModItems.MIND_SYMBOL.get());
    public static Essentia SENSES = new Essentia("sensus", new Essentia[] {AIR, SOUL}, 31, ModItems.SENSES_SHARD.get(), ModItems.SENSES_SYMBOL.get());
    public static Essentia AVERSION = new Essentia("aversio", new Essentia[] {SOUL, ENTROPY}, 32, ModItems.AVERSION_SHARD.get(), ModItems.AVERSION_SYMBOL.get());
    public static Essentia PROTECT = new Essentia("praemunio", new Essentia[] {SOUL, EARTH}, 33, ModItems.PROTECT_SHARD.get(), ModItems.PROTECT_SYMBOL.get());
    public static Essentia DESIRE = new Essentia("desiderium", new Essentia[] {SOUL, VOID}, 34, ModItems.DESIRE_SHARD.get(), ModItems.DESIRE_SYMBOL.get());
    public static Essentia UNDEAD = new Essentia("exanimis", new Essentia[] {MOTION, DEATH}, 35, ModItems.UNDEAD_SHARD.get(), ModItems.UNDEAD_SYMBOL.get());
    public static Essentia BEAST = new Essentia("bestia", new Essentia[] {MOTION, LIFE}, 36, ModItems.BEAST_SHARD.get(), ModItems.BEAST_SYMBOL.get());
    public static Essentia MAN = new Essentia("humanus", new Essentia[] {SOUL, LIFE}, 37, ModItems.MAN_SHARD.get(), ModItems.MAN_SYMBOL.get());


    


}
