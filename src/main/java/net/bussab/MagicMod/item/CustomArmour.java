package net.bussab.MagicMod.item;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.OverrideOnly;

import java.util.function.Consumer;
import net.bussab.MagicMod.MagicMod;
import net.bussab.MagicMod.item.armour.model.GogglesModel;
import net.bussab.MagicMod.item.armour.model.ModModelLayers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.ForgeRegistries;

public class CustomArmour extends ArmorItem {

    public CustomArmour(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }
    
    @Override
    public String getArmorTexture(ItemStack pItemStack, Entity pEntity, EquipmentSlot pSlot, String pType){
        String Item = ForgeRegistries.ITEMS.getKey(CustomArmour.this).getPath();
        return new ResourceLocation(MagicMod.MOD_ID, "textures/models/armor/"+Item+".png").toString();
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> pConsumer){
        pConsumer.accept(new IClientItemExtensions() {
            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity pLivingEntity, ItemStack pItemStack, EquipmentSlot pEquipmentSlot, HumanoidModel<?> pHumanoidModel){
                return switch (ForgeRegistries.ITEMS.getKey(CustomArmour.this).getPath()){
                    case "goggles" -> new GogglesModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModModelLayers.GOGGLES));

                    default -> pHumanoidModel;
                };
            }
        });
    }



}
