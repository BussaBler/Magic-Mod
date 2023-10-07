package net.bussab.MagicMod.essentia;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ConfigEssentia {
    
    public static void postInit(){
        registerItemEssentia();
    }


    private static void registerItemEssentia(){
        EssentiaRegister.registerObjectTag(new ItemStack(Items.DIRT), new EssentiaList().add(Essentia.EARTH, 5));
    }



    




}
