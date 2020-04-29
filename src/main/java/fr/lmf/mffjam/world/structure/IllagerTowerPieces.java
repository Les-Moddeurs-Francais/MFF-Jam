package fr.lmf.mffjam.world.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import fr.lmf.mffjam.Main;
import fr.lmf.mffjam.init.StructurePieceInit;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.jigsaw.*;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.PillagerOutpostPieces;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.template.IntegrityProcessor;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;

public class IllagerTowerPieces {
    public static void func_215139_a(ChunkGenerator<?> p_215139_0_, TemplateManager p_215139_1_, BlockPos p_215139_2_, List<StructurePiece> p_215139_3_, SharedSeedRandom p_215139_4_) {
        JigsawManager.func_214889_a(new ResourceLocation("illager_tower/base_plate"), 7, PillagerOutpostPieces.PillageOutpost::new, p_215139_0_, p_215139_1_, p_215139_2_, p_215139_3_, p_215139_4_);
    }

    static {
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("illager_tower/base_plate"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(new SingleJigsawPiece(new ResourceLocation(Main.MODID,"illager_tower/base_plate").toString()), 1)), JigsawPattern.PlacementBehaviour.RIGID));
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("illager_tower/towers"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(new SingleJigsawPiece(new ResourceLocation(Main.MODID,"illager_tower/illager_tower").toString()), 1)), JigsawPattern.PlacementBehaviour.RIGID));
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("illager_tower/illager"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(new SingleJigsawPiece(new ResourceLocation(Main.MODID,"illager_tower/illager").toString()), 1)), JigsawPattern.PlacementBehaviour.RIGID));
    }

    public static class IllagerTower extends AbstractVillagePiece {
        public IllagerTower(TemplateManager p_i50560_1_, JigsawPiece p_i50560_2_, BlockPos p_i50560_3_, int p_i50560_4_, Rotation p_i50560_5_, MutableBoundingBox p_i50560_6_) {
            super(StructurePieceInit.ILLAGER_TOWER, p_i50560_1_, p_i50560_2_, p_i50560_3_, p_i50560_4_, p_i50560_5_, p_i50560_6_);
        }

        public IllagerTower(TemplateManager p_i50561_1_, CompoundNBT p_i50561_2_) {
            super(p_i50561_1_, p_i50561_2_, StructurePieceInit.ILLAGER_TOWER);
        }
    }
}
