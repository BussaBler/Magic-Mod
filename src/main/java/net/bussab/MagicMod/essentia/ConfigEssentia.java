package net.bussab.MagicMod.essentia;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ConfigEssentia {
    
    public static void postInit(){
        registerItemEssentia();
    }


    private static void registerItemEssentia(){
        EssentiaRegister.registerObjectTag(new ItemStack(Items.DIRT), new EssentiaList().add(Essentia.EARTH, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Items.COAL), new EssentiaList().add(Essentia.FIRE, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Items.SLIME_BALL), new EssentiaList().add(Essentia.WATER, 5));
    }



    




}
