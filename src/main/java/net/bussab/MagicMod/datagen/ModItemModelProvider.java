package net.bussab.MagicMod.datagen;

import net.bussab.MagicMod.MagicMod;
import net.bussab.MagicMod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MagicMod.MOD_ID, existingFileHelper);
    }
    
    @Override
    protected void registerModels(){
        simpleItem(ModItems.FIRE_CRYSTAL);
        simpleItem(ModItems.AIR_CRYSTAL);
        simpleItem(ModItems.WATER_CRYSTAL);
        simpleItem(ModItems.EARTH_CRYSTAL);
        simpleItem(ModItems.DARK_CRYSTAL);
        simpleItem(ModItems.LIGHT_CRYSTAL);
        simpleItem(ModItems.MANA_CRYSTAL);

        simpleItem(ModItems.FIRE_SHARD);
        simpleItem(ModItems.WATER_SHARD);
        simpleItem(ModItems.EARTH_SHARD);
        simpleItem(ModItems.AIR_SHARD);
        simpleItem(ModItems.DARK_SHARD);
        simpleItem(ModItems.LIGHT_SHARD);
        simpleItem(ModItems.MANA_SHARD);
        simpleItem(ModItems.BLANK_SHARD);
        simpleItem(ModItems.SALIS_MUNDUS);

    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> pItem){
        return withExistingParent(pItem.getId().getPath(), new ResourceLocation("item/generated"))
        .texture("layer0",  new ResourceLocation(MagicMod.MOD_ID, "item/" + pItem.getId().getPath()));
    }
}
