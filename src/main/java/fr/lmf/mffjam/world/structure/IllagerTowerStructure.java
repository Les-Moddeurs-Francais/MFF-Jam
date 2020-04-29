package fr.lmf.mffjam.world.structure;

import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class IllagerTowerStructure extends ScatteredStructure<NoFeatureConfig> {
    private static final List<Biome.SpawnListEntry> PILLAGE_OUTPOST_ENEMIES;

    public IllagerTowerStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51470_1_) {
        super(p_i51470_1_);
    }

    public String getStructureName() {
        return this.getRegistryName().toString();
    }

    public int getSize() {
        return 3;
    }

    public List<Biome.SpawnListEntry> getSpawnList() {
        return PILLAGE_OUTPOST_ENEMIES;
    }

    public boolean func_225558_a_(BiomeManager p_225558_1_, ChunkGenerator<?> p_225558_2_, Random p_225558_3_, int p_225558_4_, int p_225558_5_, Biome p_225558_6_) {
        ChunkPos lvt_7_1_ = this.getStartPositionForPosition(p_225558_2_, p_225558_3_, p_225558_4_, p_225558_5_, 0, 0);
        if (p_225558_4_ == lvt_7_1_.x && p_225558_5_ == lvt_7_1_.z) {
            int lvt_8_1_ = p_225558_4_ >> 4;
            int lvt_9_1_ = p_225558_5_ >> 4;
            p_225558_3_.setSeed((long)(lvt_8_1_ ^ lvt_9_1_ << 4) ^ p_225558_2_.getSeed());
            p_225558_3_.nextInt();
            if (p_225558_3_.nextInt(5) != 0) {
                return false;
            }

            if (p_225558_2_.hasStructure(p_225558_6_, this)) {
                for(int lvt_10_1_ = p_225558_4_ - 10; lvt_10_1_ <= p_225558_4_ + 10; ++lvt_10_1_) {
                    for(int lvt_11_1_ = p_225558_5_ - 10; lvt_11_1_ <= p_225558_5_ + 10; ++lvt_11_1_) {
                        if (Feature.VILLAGE.func_225558_a_(p_225558_1_, p_225558_2_, p_225558_3_, lvt_10_1_, lvt_11_1_, p_225558_1_.getBiome(new BlockPos((lvt_10_1_ << 4) + 9, 0, (lvt_11_1_ << 4) + 9)))) {
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

    static {
        PILLAGE_OUTPOST_ENEMIES = Lists.newArrayList(new Biome.SpawnListEntry[]{new Biome.SpawnListEntry(EntityType.PILLAGER, 1, 1, 1)});
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

