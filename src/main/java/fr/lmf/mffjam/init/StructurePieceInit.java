package fr.lmf.mffjam.init;

import fr.lmf.mffjam.utils.Utils;
import fr.lmf.mffjam.world.structure.IllagerTowerPieces;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class StructurePieceInit {

    public static final IStructurePieceType ILLAGER_TOWER = Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(Utils.MODID, "illager_tower_piece"), IllagerTowerPieces.IllagerTower::new);

}
