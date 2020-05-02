package fr.lmf.mffjam.init;

import fr.lmf.mffjam.tileentity.TileEntityEntityDetector;
import fr.lmf.mffjam.utils.Utils;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit
{

	public static final DeferredRegister<TileEntityType<?>> REGISTRY = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Utils.MODID);

	public static final RegistryObject<TileEntityType<?>> TE_ENTITY_DETECTOR = REGISTRY.register("entity_detector", () -> TileEntityType.Builder.create(TileEntityEntityDetector::new, BlockInit.ENTITY_DETECTOR.get()).build(null));

}
