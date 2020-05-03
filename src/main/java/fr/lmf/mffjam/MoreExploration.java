package fr.lmf.mffjam;

import fr.lmf.mffjam.event.FallingEvent;
import fr.lmf.mffjam.event.MELootTablesEvent;
import fr.lmf.mffjam.init.*;
import fr.lmf.mffjam.utils.Utils;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Utils.MODID)
public class MoreExploration
{
	private static final Logger LOGGER = LogManager.getLogger();

	public static final ItemGroup me_group = new ItemGroup("me_group")
	{
		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(ItemInit.PLAYER_SLING.get());
		}
	};

	public MoreExploration()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemInit.REGISTRY.register(bus);
		BlockInit.REGISTRY.register(bus);
		TileEntityInit.REGISTRY.register(bus);
		EntityInit.REGISTRY.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new FallingEvent());
		MinecraftForge.EVENT_BUS.register(new MELootTablesEvent());
		MinecraftForge.EVENT_BUS.register(new StructureInit());
		MinecraftForge.EVENT_BUS.register(new ClientEvent());


	}

	private void setup(final FMLCommonSetupEvent event)
	{
		LOGGER.info("HELLO FROM PREINIT");
		Biomes.BIRCH_FOREST.addStructure(StructureInit.illagerTower.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		Biomes.BIRCH_FOREST.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, StructureInit.illagerTower.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

		Biomes.PLAINS.addStructure(StructureInit.villagerCamp.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		Biomes.PLAINS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, StructureInit.villagerCamp.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	}

	private void doClientStuff(final FMLClientSetupEvent event)
	{
		LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
		RenderTypeLookup.setRenderLayer(BlockInit.FAKE_LEAVES.get(), RenderType.getCutoutMipped());
	}

	private void enqueueIMC(final InterModEnqueueEvent event)
	{
		//InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
	}

	private void processIMC(final InterModProcessEvent event)
	{
        /*
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
        */
	}
}
