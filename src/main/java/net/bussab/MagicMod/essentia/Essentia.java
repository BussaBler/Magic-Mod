package net.bussab.MagicMod.essentia;

import java.util.HashMap;

import javax.annotation.Nullable;

public class Essentia {
    
    String name; 
    Essentia[] components;
    private int number;
    public static HashMap<String, Essentia> Dictonary = new HashMap<>();
    private static HashMap<Integer, Essentia> Enumeration = new HashMap<>();


    public Essentia(String name, @Nullable Essentia[] components, int number) {
        this.name = name;
        this.components = components;
        this.number = number;
        Dictonary.put(name, this);
        Enumeration.put(number, this);
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

    public static Essentia AIR = new Essentia("air", null, 1);
    public static Essentia FIRE = new Essentia("ignis", null, 2);
    public static Essentia WATER = new Essentia("aqua", null, 3);
    public static Essentia EARTH = new Essentia("terra", null, 4);
    public static Essentia LIGHT = new Essentia("lux", null, 5);
    public static Essentia DARK = new Essentia("tenebris", null, 6);
    





}
