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
        simpleItem(ModItems.ORDER_SHARD);
        simpleItem(ModItems.LIGHT_CRYSTAL);
        simpleItem(ModItems.MANA_CRYSTAL);

        simpleItem(ModItems.FIRE_SHARD);
        simpleItem(ModItems.WATER_SHARD);
        simpleItem(ModItems.EARTH_SHARD);
        simpleItem(ModItems.AIR_SHARD);
        simpleItem(ModItems.ENTROPY_SHARD);
        simpleItem(ModItems.LIGHT_SHARD);
        simpleItem(ModItems.ALL_SHARD);
        simpleItem(ModItems.BLANK_SHARD);
        simpleItem(ModItems.SALIS_MUNDUS);

        simpleItem(ModItems.VOID_SHARD);
        simpleItem(ModItems.LIGHT_SHARD);
        simpleItem(ModItems.MOTION_SHARD);
        simpleItem(ModItems.COLD_SHARD);
        simpleItem(ModItems.CRYSTAL_SHARD);
        simpleItem(ModItems.METAL_SHARD);
        simpleItem(ModItems.LIFE_SHARD);
        simpleItem(ModItems.DEATH_SHARD);
        simpleItem(ModItems.ENERGY_SHARD);
        simpleItem(ModItems.EXCHANGE_SHARD);
        simpleItem(ModItems.MAGIC_SHARD);
        simpleItem(ModItems.AURA_SHARD);
        simpleItem(ModItems.ALCHEMY_SHARD);
        simpleItem(ModItems.FLUX_SHARD);
        simpleItem(ModItems.DARKNESS_SHARD);
        simpleItem(ModItems.ELDRITCH_SHARD);
        simpleItem(ModItems.FLIGHT_SHARD);
        simpleItem(ModItems.PLANT_SHARD);
        simpleItem(ModItems.TOOL_SHARD);
        simpleItem(ModItems.CRAFT_SHARD);
        simpleItem(ModItems.MECHANISM_SHARD);
        simpleItem(ModItems.TRAP_SHARD);
        simpleItem(ModItems.SOUL_SHARD);
        simpleItem(ModItems.MIND_SHARD);
        simpleItem(ModItems.SENSES_SHARD);
        simpleItem(ModItems.AVERSION_SHARD);
        simpleItem(ModItems.PROTECT_SHARD);
        simpleItem(ModItems.DESIRE_SHARD);
        simpleItem(ModItems.UNDEAD_SHARD);
        simpleItem(ModItems.BEAST_SHARD);
        simpleItem(ModItems.MAN_SHARD);

        simpleItem(ModItems.GOGGLES);

        simpleItem(ModItems.FIRE_SYMBOL);
        simpleItem(ModItems.WATER_SYMBOL);
        simpleItem(ModItems.EARTH_SYMBOL);
        simpleItem(ModItems.ORDER_SYMBOL);
        simpleItem(ModItems.ENTROPY_SYMBOL);
        simpleItem(ModItems.ALL_SYMBOL);

        simpleItem(ModItems.VOID_SYMBOL);
        simpleItem(ModItems.LIGHT_SYMBOL);
        simpleItem(ModItems.MOTION_SYMBOL);
        simpleItem(ModItems.COLD_SYMBOL);
        simpleItem(ModItems.CRYSTAL_SYMBOL);
        simpleItem(ModItems.METAL_SYMBOL);
        simpleItem(ModItems.LIFE_SYMBOL);
        simpleItem(ModItems.DEATH_SYMBOL);
        simpleItem(ModItems.ENERGY_SYMBOL);
        simpleItem(ModItems.EXCHANGE_SYMBOL);
        simpleItem(ModItems.MAGIC_SYMBOL);
        simpleItem(ModItems.AURA_SYMBOL);
        simpleItem(ModItems.ALCHEMY_SYMBOL);
        simpleItem(ModItems.FLUX_SYMBOL);
        simpleItem(ModItems.DARKNESS_SYMBOL);
        simpleItem(ModItems.ELDRITCH_SYMBOL);
        simpleItem(ModItems.FLIGHT_SYMBOL);
        simpleItem(ModItems.PLANT_SYMBOL);
        simpleItem(ModItems.TOOL_SYMBOL);
        simpleItem(ModItems.CRAFT_SYMBOL);
        simpleItem(ModItems.MECHANISM_SYMBOL);
        simpleItem(ModItems.TRAP_SYMBOL);
        simpleItem(ModItems.SOUL_SYMBOL);
        simpleItem(ModItems.MIND_SYMBOL);
        simpleItem(ModItems.SENSES_SYMBOL);
        simpleItem(ModItems.AVERSION_SYMBOL);
        simpleItem(ModItems.PROTECT_SYMBOL);
        simpleItem(ModItems.DESIRE_SYMBOL);
        simpleItem(ModItems.UNDEAD_SYMBOL);
        simpleItem(ModItems.BEAST_SYMBOL);
        simpleItem(ModItems.MAN_SYMBOL);
    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> pItem){
        return withExistingParent(pItem.getId().getPath(), new ResourceLocation("item/generated"))
        .texture("layer0",  new ResourceLocation(MagicMod.MOD_ID, "item/" + pItem.getId().getPath()));
    }
}
