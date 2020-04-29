package fr.lmf.mffjam.init;

import fr.lmf.mffjam.items.ItemPlayerSling;
import fr.lmf.mffjam.utils.Utils;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit
{

	public static final DeferredRegister<Item> REGISTRY = new DeferredRegister<>(ForgeRegistries.ITEMS, Utils.MODID);

	public static final RegistryObject<Item> PLAYER_SLING = REGISTRY.register("player_sling", ItemPlayerSling::new);

}
