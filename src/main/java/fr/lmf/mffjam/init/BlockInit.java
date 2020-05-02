package fr.lmf.mffjam.init;

import fr.lmf.mffjam.MoreExploration;
import fr.lmf.mffjam.blocks.BlockEntityDetector;
import fr.lmf.mffjam.blocks.BlockFakeLeaves;
import fr.lmf.mffjam.blocks.BlockVanishing;
import fr.lmf.mffjam.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockInit
{

	public static final DeferredRegister<Block> REGISTRY = new DeferredRegister<>(ForgeRegistries.BLOCKS, Utils.MODID);

	public static final RegistryObject<Block> VANISHING_BLOCK = createBlock("vanishing_block", BlockVanishing::new);
	public static final RegistryObject<Block> FAKE_LEAVES = createBlock("fake_leaves", BlockFakeLeaves::new);
	public static final RegistryObject<Block> ENTITY_DETECTOR = createBlock("entity_detector", BlockEntityDetector::new);


	private static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
	{
		RegistryObject<Block> block = REGISTRY.register(name, supplier);
		ItemInit.REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(MoreExploration.me_group)));
		return block;
	}

}
