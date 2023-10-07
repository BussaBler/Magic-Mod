package net.bussab.MagicMod.essentia;

import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.world.item.ItemStack;

public class EssentiaRegister {
    
    public static ConcurrentHashMap<Integer, EssentiaList> objectTags = new ConcurrentHashMap<>();


    public static void registerObjectTag(ItemStack pItemStack, EssentiaList essentias){
        if (essentias == null) essentias = new EssentiaList();
        objectTags.put(generateItemID(pItemStack), essentias);
    }




    public static int generateItemID(ItemStack pItemStack){
        ItemStack pCopy = pItemStack.copy();
        pCopy.setCount(1);
        String NBT = pCopy.serializeNBT().toString();
        return NBT.hashCode();
    }


    public static EssentiaList getObjectTag(ItemStack pItemStack){
        int I = generateItemID(pItemStack);
        return objectTags.get(I);
    }




}
