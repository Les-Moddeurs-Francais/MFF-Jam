package fr.lmf.mffjam.data;

import fr.lmf.mffjam.utils.Utils;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Utils.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGathering
{

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent e)
	{
		DataGenerator generator = e.getGenerator();

		if( e.includeClient() )
		{

			MEBlockModelProvider blockModelProvider = new MEBlockModelProvider(generator, e.getExistingFileHelper());

			generator.addProvider(new MELangProvider(generator, "en_us"));
			generator.addProvider(new MELangProvider(generator, "fr_fr"));
			generator.addProvider(new MEItemModelProvider(generator, e.getExistingFileHelper()));
			generator.addProvider(blockModelProvider);
			//generator.addProvider(new VEBlockStateProvider(generator, blockModelProvider, e.getExistingFileHelper()));
			generator.addProvider(new MEAdvancementGenerator(generator));
		}

		if( e.includeServer() )
		{
			generator.addProvider(new MERecipesProvider(generator));
			generator.addProvider(new MELootTableProvider(generator));
		}

	}

}
