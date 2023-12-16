package net.bussab.MagicMod.item;

import net.bussab.MagicMod.MagicMod;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {

    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.BASE_WAND.get(), new ResourceLocation(MagicMod.MOD_ID, "speel"), (pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0);
    }
}
