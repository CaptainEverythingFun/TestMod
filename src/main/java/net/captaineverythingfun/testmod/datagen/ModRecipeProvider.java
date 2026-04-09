package net.captaineverythingfun.testmod.datagen;

import net.captaineverythingfun.testmod.TestMod;
import net.captaineverythingfun.testmod.block.ModBlocks;
import net.captaineverythingfun.testmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

   private static final List<ItemLike> TEST_ITEM_SMELTABLES = List.of(ModBlocks.TEST_BLOCK2.get(),
           ModBlocks.TEST_ORE.get(),
           ModBlocks.TEST_DEEPSLATE_ORE.get(),
           ModBlocks.TEST_NETHER_ORE.get(),
           ModBlocks.TEST_END_ORE.get()
           );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        oreSmelting(pWriter, TEST_ITEM_SMELTABLES, RecipeCategory.MISC, ModItems.TEST_ITEM.get(), 0.25f, 100, "test_item");
        oreBlasting(pWriter, TEST_ITEM_SMELTABLES, RecipeCategory.MISC, ModItems.TEST_ITEM.get(), 0.25f, 100, "test_item");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TEST_BLOCK.get())
                .pattern("#D#")
                .pattern("#D#")
                .pattern("#D#")
                .define('#', ModItems.TEST_ITEM.get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.TEST_ITEM.get()), has(ModItems.TEST_ITEM.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TEST_ITEM.get(), 9)
                .requires(ModBlocks.TEST_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TEST_BLOCK.get()), has(ModBlocks.TEST_BLOCK.get()))
                .save(pWriter);

    }

        protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List< ItemLike > pIngredients, RecipeCategory
        pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
            oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
        }

        protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
            oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
        }

        protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe > pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
            for(ItemLike itemlike : pIngredients) {
                SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                        pExperience, pCookingTime, pCookingSerializer)
                        .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                        .save(pFinishedRecipeConsumer, TestMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
            }



    }
}
