package fr.lmf.mffjam.data;

import fr.lmf.mffjam.data.block.MEBlockModelBuilder;
import fr.lmf.mffjam.utils.Utils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelProvider;

public class MEBlockModelProvider extends ModelProvider<BlockModelBuilder>
{
	public MEBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper)
	{
		super(generator, Utils.MODID, "block", MEBlockModelBuilder::new, existingFileHelper);
	}

	@Override
	protected void registerModels()
	{
		//cubeAll(BlockInit.tailor_table.getRegistryName().getPath(), modLoc("tailor_table"));
	}

	@Override
	public void clear()
	{
		super.clear();
	}

	@Override
	public void generateAll(DirectoryCache cache)
	{
		super.generateAll(cache);
	}

	@Override
	public String getName()
	{
		return Utils.MODID + "block_models_generator";
	}
}
