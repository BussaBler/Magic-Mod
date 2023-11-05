package net.bussab.MagicMod.essentia;

import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class EssentiaRegister {
    
    public static ConcurrentHashMap<Integer, EssentiaList> idToEssentia = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, EssentiaList> tagToEssentia = new ConcurrentHashMap<>();


    public static void registerObjectTag(ItemStack pItemStack, EssentiaList essentias){
        if (essentias == null) essentias = new EssentiaList();
        idToEssentia.put(generateItemID(pItemStack), essentias);
    }

    public static void registerObjectTag(String pTagKey, EssentiaList essentias){
        if (essentias == null) essentias = new EssentiaList();
        tagToEssentia.put(pTagKey, essentias);
    }



    public static int generateItemID(ItemStack pItemStack){
        ItemStack pCopy = pItemStack.copy();
        pCopy.setCount(1);
        String NBT = pCopy.serializeNBT().toString();
        return NBT.hashCode();
    }


    public static EssentiaList getObjectTag(ItemStack pItemStack){
        
        for (TagKey<Item> T : pItemStack.getTags().toList()){
            
            if (tagToEssentia.containsKey(T.location().getPath())){
                return tagToEssentia.get(T.location().getPath());
            }
        }


        int I = generateItemID(pItemStack);
        if (idToEssentia.containsKey(I)){
            return idToEssentia.get(I);
        }
        return null; 
    }




}
