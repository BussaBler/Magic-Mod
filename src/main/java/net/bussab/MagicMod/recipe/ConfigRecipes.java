package net.bussab.MagicMod.recipe;

import net.bussab.MagicMod.essentia.Essentia;
import net.bussab.MagicMod.essentia.EssentiaList;
import net.bussab.MagicMod.item.ModItems;
import net.minecraft.resources.ResourceLocation;

public class ConfigRecipes {
    




    public static void initializeAlchemyRecipes(){
        
        for (Essentia E: Essentia.Dictonary.values()){
           CrucibleRecipes.addCrucibleRecipes(new ResourceLocation("magicmod:"+E.getName()+"_shard"), new CrucibleRecipes(ModItems.BLANK_SHARD.get(),
               Essentia.ShardCatalog.get(E).getDefaultInstance(), new ResourceLocation("magicmod:"+E.getName()+"_shard"), new EssentiaList().add(E, 2)));
         }
        
        
    }
}
