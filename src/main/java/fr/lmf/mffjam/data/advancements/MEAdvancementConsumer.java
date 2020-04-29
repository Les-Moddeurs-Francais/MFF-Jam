package fr.lmf.mffjam.data.advancements;

import fr.lmf.mffjam.utils.Utils;
import net.minecraft.advancements.Advancement;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class MEAdvancementConsumer implements Consumer<Consumer<Advancement>>
{
	public static Advancement AUTEL_ADVANCEMENT_TEST;

	@Override
	public void accept(Consumer<Advancement> advancementConsumer)
	{
	}

	public static String getID(String name)
	{
		return Utils.MODID + ":" + name;
	}

	public static ResourceLocation getLocation(String name)
	{
		return new ResourceLocation(Utils.MODID, name);
	}
}
