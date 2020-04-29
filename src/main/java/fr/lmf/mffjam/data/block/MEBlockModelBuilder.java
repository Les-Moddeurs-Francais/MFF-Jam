package fr.lmf.mffjam.data.block;

import com.google.common.base.Preconditions;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class MEBlockModelBuilder extends BlockModelBuilder
{
	public MEBlockModelBuilder(ResourceLocation outputLocation, ExistingFileHelper existingFileHelper)
	{
		super(outputLocation, existingFileHelper);
	}

	@Override
	public BlockModelBuilder texture(String key, ResourceLocation texture)
	{
		Preconditions.checkNotNull(key, "Key must not be null");
		Preconditions.checkNotNull(texture, "Texture must not be null");
		this.textures.put(key, texture.toString());
		return this;
	}
}
