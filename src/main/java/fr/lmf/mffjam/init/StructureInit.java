package fr.lmf.mffjam.init;

import fr.lmf.mffjam.utils.Utils;
import fr.lmf.mffjam.world.structure.IllagerTowerStructure;
import fr.lmf.mffjam.world.structure.VillagerCampStructure;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.Structures;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Locale;

@Mod.EventBusSubscriber(modid = Utils.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class StructureInit {

    public static Structure<NoFeatureConfig> illagerTower = new IllagerTowerStructure(NoFeatureConfig::deserialize);
    public static Structure<NoFeatureConfig> villagerCamp = new VillagerCampStructure(NoFeatureConfig::deserialize);

    @SubscribeEvent
    public static void registerFeature(final RegistryEvent.Register<Feature<?>> e)
    {

        e.getRegistry().registerAll(

                illagerTower.setRegistryName("illager_tower"),
                villagerCamp.setRegistryName("villager_camp")

        );

    }



}
