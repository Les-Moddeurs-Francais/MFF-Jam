package fr.lmf.mffjam.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;

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
