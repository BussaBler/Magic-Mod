package net.bussab.MagicMod.datagen;

import java.util.function.Consumer;

import net.bussab.MagicMod.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SALIS_MUNDUS.get(), 2).requires(Items.BOWL)
        .requires(ModItems.AIR_SHARD.get())
        .requires(ModItems.EARTH_SHARD.get())
        .requires(ModItems.ENTROPY_SHARD.get())
        .requires(ModItems.FIRE_SHARD.get())
        .requires(ModItems.ORDER_SHARD.get())
        .requires(ModItems.WATER_SHARD.get())
        .unlockedBy("has shard", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.AIR_SHARD.get()).build()))
        .save(pWriter);
    
    }

    
    
}
