package fr.lmf.mffjam.data;

import fr.lmf.mffjam.init.BlockInit;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;

import java.util.function.Consumer;

public class MERecipesProvider extends RecipeProvider
{
	public MERecipesProvider(DataGenerator generatorIn)
	{
		super(generatorIn);
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
	{
		registerCraftingRecipe(consumer);
		registerFurnaceRecipes(consumer);
		registerBlastingRecipes(consumer);
		registerSmokerRecipes(consumer);


	}

	private void registerCraftingRecipe(Consumer<IFinishedRecipe> consumer)
	{

		ShapedRecipeBuilder.shapedRecipe(BlockInit.ENTITY_DETECTOR.get(), 1)
				.key('C', Blocks.COBBLESTONE)
				.key('R', Items.REDSTONE)
				.key('B', Items.BONE)
				.key('E', Items.SPIDER_EYE)
				.key('O', Blocks.COMPARATOR)
				.patternLine("CBC")
				.patternLine("ROR")
				.patternLine("CEC")
				.addCriterion("obtention", InventoryChangeTrigger.Instance.forItems(Blocks.COMPARATOR))
				.build(consumer);

		System.out.println(ItemTags.LEAVES.getAllElements());

		ShapedRecipeBuilder.shapedRecipe(BlockInit.VANISHING_BLOCK.get())
				.key('L', ItemTags.LEAVES)
				.key('S', Items.STRING)
				.patternLine(" L ")
				.patternLine("LSL")
				.patternLine(" L ")
				.addCriterion("obtention", InventoryChangeTrigger.Instance.forItems(ItemPredicate.Builder.create().tag(ItemTags.LEAVES).build()))
				.build(consumer);

	}

	private void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
	{

	}

	private void registerSmokerRecipes(Consumer<IFinishedRecipe> consumer)
	{


	}

	private void registerBlastingRecipes(Consumer<IFinishedRecipe> consumer)
	{

	}


}
