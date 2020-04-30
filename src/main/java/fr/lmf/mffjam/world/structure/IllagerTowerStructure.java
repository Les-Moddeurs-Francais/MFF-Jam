package fr.lmf.mffjam.world.structure;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;
import java.util.function.Function;

public class IllagerTowerStructure extends ScatteredStructure<NoFeatureConfig> {

    private static final int FEATURE_DISTANCE = 31;
    private static final int FEATURE_SEPARATION = 8;

    public IllagerTowerStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51470_1_) {
        super(p_i51470_1_);
    }

    public String getStructureName() {
        return this.getRegistryName().toString();
    }

    public int getSize() {
        return 3;
    }


    @Override
    protected ChunkPos getStartPositionForPosition(ChunkGenerator<?> generator, Random random, int chunkX, int chunkZ, int offsetX, int offsetZ) {
        int lvt_9_1_ = chunkX + FEATURE_DISTANCE * offsetX;
        int lvt_10_1_ = chunkZ + FEATURE_DISTANCE * offsetZ;
        int lvt_11_1_ = lvt_9_1_ < 0 ? lvt_9_1_ - FEATURE_DISTANCE + 1 : lvt_9_1_;
        int lvt_12_1_ = lvt_10_1_ < 0 ? lvt_10_1_ - FEATURE_DISTANCE + 1 : lvt_10_1_;
        int lvt_13_1_ = lvt_11_1_ / FEATURE_DISTANCE;
        int lvt_14_1_ = lvt_12_1_ / FEATURE_DISTANCE;
        ((SharedSeedRandom)random).setLargeFeatureSeedWithSalt(generator.getSeed(), lvt_13_1_, lvt_14_1_, 10387312);
        lvt_13_1_ *= FEATURE_DISTANCE;
        lvt_14_1_ *= FEATURE_DISTANCE;
        lvt_13_1_ += random.nextInt(FEATURE_DISTANCE - FEATURE_SEPARATION);
        lvt_14_1_ += random.nextInt(FEATURE_DISTANCE - FEATURE_SEPARATION);
        return new ChunkPos(lvt_13_1_, lvt_14_1_);
    }


    @Override
    public boolean func_225558_a_(BiomeManager p_225558_1_, ChunkGenerator<?> p_225558_2_, Random p_225558_3_, int p_225558_4_, int p_225558_5_, Biome p_225558_6_) {
        ChunkPos chunkpos = this.getStartPositionForPosition(p_225558_2_, p_225558_3_, p_225558_4_, p_225558_5_, 0, 0);
        if (p_225558_4_ == chunkpos.x && p_225558_5_ == chunkpos.z) {
            int i = p_225558_4_ >> 4;
            int j = p_225558_5_ >> 4;
            p_225558_3_.setSeed((long)(i ^ j << 4) ^ p_225558_2_.getSeed());
            p_225558_3_.nextInt();
            if (p_225558_3_.nextInt(5) != 0) {
                return false;
            }

            if (p_225558_2_.hasStructure(p_225558_6_, this)) {
                for(int k = p_225558_4_ - 10; k <= p_225558_4_ + 10; ++k) {
                    for(int l = p_225558_5_ - 10; l <= p_225558_5_ + 10; ++l) {
                        if (Feature.VILLAGE.func_225558_a_(p_225558_1_, p_225558_2_, p_225558_3_, k, l, p_225558_1_.getBiome(new BlockPos((k << 4) + 9, 0, (l << 4) + 9)))) {
                            return false;
                        }
                    }
                }

                return true;
            }
        }

        return false;
    }

    public IStartFactory getStartFactory() {
        return IllagerTowerStructure.Start::new;
    }

    protected int getSeedModifier() {
        return 165745296;
    }

    public static class Start extends MarginedStructureStart {
        public Start(Structure<?> p_i225815_1_, int p_i225815_2_, int p_i225815_3_, MutableBoundingBox p_i225815_4_, int p_i225815_5_, long p_i225815_6_) {
            super(p_i225815_1_, p_i225815_2_, p_i225815_3_, p_i225815_4_, p_i225815_5_, p_i225815_6_);
        }

        public void init(ChunkGenerator<?> p_214625_1_, TemplateManager p_214625_2_, int p_214625_3_, int p_214625_4_, Biome p_214625_5_) {
            BlockPos lvt_6_1_ = new BlockPos(p_214625_3_ * 16, 90, p_214625_4_ * 16);
            IllagerTowerPieces.func_215139_a(p_214625_1_, p_214625_2_, lvt_6_1_, this.components, this.rand);
            this.recalculateStructureSize();
        }
    }
}

