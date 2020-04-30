package fr.lmf.mffjam.init;

import fr.lmf.mffjam.items.ItemGrapple;
import fr.lmf.mffjam.items.ItemPlayerSling;
import fr.lmf.mffjam.items.MEItemFood;
import fr.lmf.mffjam.utils.Utils;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit
{

	public static final DeferredRegister<Item> REGISTRY = new DeferredRegister<>(ForgeRegistries.ITEMS, Utils.MODID);

	public static final RegistryObject<Item> PLAYER_SLING = REGISTRY.register("player_sling", ItemPlayerSling::new);
	public static final RegistryObject<Item> GRAPPLE = REGISTRY.register("grapple", ItemGrapple::new);

	public static final RegistryObject<Item> ORANGE = REGISTRY.register("orange", () -> new MEItemFood(3, 0.5f));
	public static final RegistryObject<Item> PEAR = REGISTRY.register("pear", () -> new MEItemFood(2, 0.25f));
	public static final RegistryObject<Item> CHERRY = REGISTRY.register("cherry", () -> new MEItemFood(1, 0.1f));
	public static final RegistryObject<Item> CLEMENTINE = REGISTRY.register("clementine", () -> new MEItemFood(2, 0.2f));

}
