package fr.lmf.mffjam.data.item;

import com.google.common.base.Preconditions;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelBuilder;

public class MEItemBuilder extends ItemModelBuilder
{
	public MEItemBuilder(ResourceLocation outputLocation, ExistingFileHelper existingFileHelper)
	{
		super(outputLocation, existingFileHelper);
	}

	@Override
	public ItemModelBuilder texture(String key, ResourceLocation texture)
	{
		Preconditions.checkNotNull(key, "Key must not be null");
		Preconditions.checkNotNull(texture, "Texture must not be null");
		this.textures.put(key, texture.toString());
		return this;
	}
}
