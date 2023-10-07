package net.bussab.MagicMod.recipe;

import java.util.HashMap;

import net.bussab.MagicMod.essentia.Essentia;
import net.bussab.MagicMod.essentia.EssentiaList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CrucibleRecipes {
    
    public static HashMap<ResourceLocation, CrucibleRecipes> alchemyRecipeCatalog = new HashMap<>();


    private final Item inputItem; 
    private final ItemStack output; 
    private final ResourceLocation id; 
    private final EssentiaList essentiaList;


    public CrucibleRecipes(Item inputItem, ItemStack output, ResourceLocation id,
            EssentiaList essentiaList) {
        this.inputItem = inputItem;
        this.output = output;
        this.id = id;
        this.essentiaList = essentiaList;
    } 

    public Item getInputItem() {
        return inputItem;
    }

    public ItemStack getOutput() {
        return output;
    }

    public ResourceLocation getId() {
        return id;
    }

    public EssentiaList getEssentiaList() {
        return essentiaList;
    }

    public boolean matches(Item Catalyst, EssentiaList essentia, Level pLevel){
        if (pLevel.isClientSide) return false;
        if (inputItem!=(Catalyst)) return false;
        if (essentia==null) return false;
        for (Essentia E:essentiaList.getEssentias()){
            if (essentia.getAmount(E)<essentiaList.getAmount(E)) 
            return false;
        }
        return true; 
    

    }

    public static void addCrucibleRecipes (ResourceLocation pLocation, CrucibleRecipes recipes){
        alchemyRecipeCatalog.put(pLocation, recipes);
    }

    public static CrucibleRecipes findMatchingRecipe (Item pStack, EssentiaList eList, Level pLevel){
        
        
        
        CrucibleRecipes out=null;
        for (CrucibleRecipes CR: alchemyRecipeCatalog.values()){
            if (CR.matches(pStack, eList, pLevel))
            out = CR;

        }
        return out;
    }

    

}