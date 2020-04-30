package fr.lmf.mffjam.data;

import fr.lmf.mffjam.data.item.MEItemBuilder;
import fr.lmf.mffjam.init.ItemInit;
import fr.lmf.mffjam.utils.Utils;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelProvider;

public class MEItemModelProvider extends ModelProvider<ItemModelBuilder>
{
	public MEItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper)
	{
		super(generator, Utils.MODID, "item", MEItemBuilder::new, existingFileHelper);
	}

	@Override
	protected void registerModels()
	{
		layer0(ItemInit.ORANGE.get());
		layer0(ItemInit.PEAR.get());
		layer0(ItemInit.CHERRY.get());
		layer0(ItemInit.CLEMENTINE.get());
	}

	@Override
	public String getName()
	{
		return Utils.MODID + ".item_models_generator";
	}

	private void layer0(final Item item)
	{
		singleTexture(item.getRegistryName().getPath(), mcLoc("generated"), "layer0", modLoc("item/" + item.getRegistryName().getPath()));
	}

	private void tool(final Item item)
	{
		singleTexture(item.getRegistryName().getPath(), mcLoc("handheld"), "layer0", modLoc("item/" + item.getRegistryName().getPath()));
	}
}
