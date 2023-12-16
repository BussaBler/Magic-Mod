package net.bussab.MagicMod.spells;

import net.bussab.MagicMod.essentia.Essentia;

public class Spell {

    public String name; 
    public Essentia baseElement;
    private int range;
    private int damage;


    public Spell(String pName, Essentia pEssentia, int pRange, int pDamage){

        this.name = pName;
        this.baseElement = pEssentia;
        this.range = pRange;
        this.damage = pDamage;

    }


    public Essentia getBaseElement() {
        return baseElement;
    }


    public int getRange() {
        return range;
    }


    public int getDamage() {
        return damage;
    }





}
