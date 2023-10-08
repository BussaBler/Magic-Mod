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


    public Essentia(String name, @Nullable Essentia[] components, int number, Item shard) {
        this.name = name;
        this.components = components;
        this.number = number;
        Dictonary.put(name, this);
        Enumeration.put(number, this);
        ShardCatalog.put(this, shard);
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

    public static Essentia AIR = new Essentia("air", null, 1, ModItems.AIR_SHARD.get());
    public static Essentia FIRE = new Essentia("ignis", null, 2, ModItems.FIRE_SHARD.get());
    public static Essentia WATER = new Essentia("aqua", null, 3, ModItems.WATER_SHARD.get());
    public static Essentia EARTH = new Essentia("terra", null, 4, ModItems.EARTH_SHARD.get());
    public static Essentia LIGHT = new Essentia("lux", null, 5, ModItems.LIGHT_SHARD.get());
    public static Essentia DARK = new Essentia("tenebris", null, 6, ModItems.DARK_CRYSTAL.get());
    





}
