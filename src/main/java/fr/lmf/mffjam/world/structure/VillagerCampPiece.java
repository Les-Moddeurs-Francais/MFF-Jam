package fr.lmf.mffjam.world.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import fr.lmf.mffjam.init.StructurePieceInit;
import fr.lmf.mffjam.utils.Utils;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.template.*;

import java.util.List;

public class VillagerCampPiece {
    public static void func_215139_a(ChunkGenerator<?> p_215139_0_, TemplateManager p_215139_1_, BlockPos p_215139_2_, List<StructurePiece> p_215139_3_, SharedSeedRandom p_215139_4_) {
        JigsawManager.func_214889_a(new ResourceLocation("village_camp/camp_center"), 4, VillagerCampPiece.VillagerCamp::new, p_215139_0_, p_215139_1_, p_215139_2_, p_215139_3_, p_215139_4_);
    }

    static {
        ImmutableList<StructureProcessor> lvt_1_1_ = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()))));
        ImmutableList<StructureProcessor> lvt_2_1_ = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new BlockMatchRuleTest(Blocks.GRASS_PATH), new BlockMatchRuleTest(Blocks.WATER), Blocks.OAK_PLANKS.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GRASS_PATH, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.GRASS_BLOCK.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.GRASS_BLOCK), new BlockMatchRuleTest(Blocks.WATER), Blocks.WATER.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.DIRT), new BlockMatchRuleTest(Blocks.WATER), Blocks.WATER.getDefaultState()))));

        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village_camp/camp_center"), new ResourceLocation("empty"), ImmutableList.of(new Pair(new SingleJigsawPiece(new ResourceLocation(Utils.MODID, "camp/camp_center").toString(), ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()))))), 50)), JigsawPattern.PlacementBehaviour.RIGID));

        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village_camp/base_plate"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(new SingleJigsawPiece(new ResourceLocation(Utils.MODID, "camp/base_plate").toString()), 1)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village_camp/tent"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(new SingleJigsawPiece(new ResourceLocation(Utils.MODID, "camp/tent/tent_1").toString(), lvt_1_1_), 1), Pair.of(new SingleJigsawPiece(new ResourceLocation(Utils.MODID, "camp/tent/tent_2").toString()), 1), Pair.of(new SingleJigsawPiece(new ResourceLocation(Utils.MODID, "camp/tent/tent_3").toString()), 1)), JigsawPattern.PlacementBehaviour.RIGID));
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village_camp/streets"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(new SingleJigsawPiece(new ResourceLocation(Utils.MODID, "camp/streets/corner_01").toString(),lvt_2_1_), 1),Pair.of(new SingleJigsawPiece(new ResourceLocation(Utils.MODID, "camp/streets/corner_02").toString(),lvt_2_1_), 1),Pair.of(new SingleJigsawPiece(new ResourceLocation(Utils.MODID, "camp/streets/straight_01").toString(),lvt_2_1_), 1),Pair.of(new SingleJigsawPiece(new ResourceLocation(Utils.MODID, "camp/streets/straight_02").toString(),lvt_2_1_), 1),Pair.of(new SingleJigsawPiece(new ResourceLocation(Utils.MODID, "camp/streets/straight_03").toString(),lvt_2_1_), 1),Pair.of(new SingleJigsawPiece(new ResourceLocation(Utils.MODID, "camp/streets/straight_04").toString(),lvt_2_1_), 1)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village/plains/villagers"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new SingleJigsawPiece("village/plains/villagers/nitwit"), 1), new Pair<>(new SingleJigsawPiece("village/plains/villagers/baby"), 1), new Pair<>(new SingleJigsawPiece("village/plains/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));
    }

    public static class VillagerCamp extends AbstractVillagePiece {
        public VillagerCamp(TemplateManager p_i50560_1_, JigsawPiece p_i50560_2_, BlockPos p_i50560_3_, int p_i50560_4_, Rotation p_i50560_5_, MutableBoundingBox p_i50560_6_) {
            super(StructurePieceInit.VILLAGER_CAMP, p_i50560_1_, p_i50560_2_, p_i50560_3_, p_i50560_4_, p_i50560_5_, p_i50560_6_);
        }

        public VillagerCamp(TemplateManager p_i50561_1_, CompoundNBT p_i50561_2_) {
            super(p_i50561_1_, p_i50561_2_, StructurePieceInit.VILLAGER_CAMP);
        }
    }
}
