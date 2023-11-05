package net.bussab.MagicMod.item.armour.model;

import net.bussab.MagicMod.MagicMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    

    public static final ModelLayerLocation GOGGLES = register("goggles");

    public static ModelLayerLocation register(String pName){
        return new ModelLayerLocation(new ResourceLocation(MagicMod.MOD_ID, pName), "main");
    }



}
