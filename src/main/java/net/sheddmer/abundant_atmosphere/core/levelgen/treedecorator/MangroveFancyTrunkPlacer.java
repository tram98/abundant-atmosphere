package net.sheddmer.abundant_atmosphere.core.levelgen.treedecorator;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class MangroveFancyTrunkPlacer extends TrunkPlacer {
    public static final Codec<MangroveFancyTrunkPlacer> CODEC = RecordCodecBuilder.create((p_70136_) -> {
        return trunkPlacerParts(p_70136_).apply(p_70136_, MangroveFancyTrunkPlacer::new);
    });
    private static final double TRUNK_HEIGHT_SCALE = 0.618D;
    private static final double CLUSTER_DENSITY_MAGIC = 1.382D;
    private static final double BRANCH_SLOPE = 0.381D;
    private static final double BRANCH_LENGTH_MAGIC = 0.328D;

    public MangroveFancyTrunkPlacer(int p_70094_, int p_70095_, int p_70096_) {
        super(p_70094_, p_70095_, p_70096_);
    }

    protected TrunkPlacerType<?> type() {
        return TrunkPlacerType.FANCY_TRUNK_PLACER;
    }

    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader p_226093_, BiConsumer<BlockPos, BlockState> p_226094_, RandomSource p_226095_, int p_226096_, BlockPos p_226097_, TreeConfiguration p_226098_) {
        int i = 5;
        int j = p_226096_ + 2;
        int k = Mth.floor((double)j * 0.618D);
        double d0 = 1.0D;
        int l = Math.min(1, Mth.floor(1.382D + Math.pow(1.0D * (double)j / 13.0D, 2.0D)));
        int i1 = p_226097_.getY() + k;
        int j1 = j - 5;
        List<MangroveFancyTrunkPlacer.FoliageCoords> list = Lists.newArrayList();
        list.add(new MangroveFancyTrunkPlacer.FoliageCoords(p_226097_.above(j1), i1));

        for(; j1 >= 0; --j1) {
            float f = treeShape(j, j1);
            if (!(f < 0.0F)) {
                for(int k1 = 0; k1 < l; ++k1) {
                    double d1 = 1.0D;
                    double d2 = 1.0D * (double)f * ((double)p_226095_.nextFloat() + 0.328D);
                    double d3 = (double)(p_226095_.nextFloat() * 2.0F) * Math.PI;
                    double d4 = d2 * Math.sin(d3) + 0.5D;
                    double d5 = d2 * Math.cos(d3) + 0.5D;
                    BlockPos blockpos = p_226097_.offset(d4, (double)(j1 - 1), d5);
                    BlockPos blockpos1 = blockpos.above(5);
                    if (this.makeLimb(p_226093_, p_226094_, p_226095_, blockpos, blockpos1, false, p_226098_)) {
                        int l1 = p_226097_.getX() - blockpos.getX();
                        int i2 = p_226097_.getZ() - blockpos.getZ();
                        double d6 = (double)blockpos.getY() - Math.sqrt((double)(l1 * l1 + i2 * i2)) * 0.381D;
                        int j2 = d6 > (double)i1 ? i1 : (int)d6;
                        BlockPos blockpos2 = new BlockPos(p_226097_.getX(), j2, p_226097_.getZ());
                        if (this.makeLimb(p_226093_, p_226094_, p_226095_, blockpos2, blockpos, false, p_226098_)) {
                            list.add(new MangroveFancyTrunkPlacer.FoliageCoords(blockpos, blockpos2.getY()));
                        }
                    }
                }
            }
        }

        this.makeLimb(p_226093_, p_226094_, p_226095_, p_226097_, p_226097_.above(k), true, p_226098_);
        this.makeBranches(p_226093_, p_226094_, p_226095_, j, p_226097_, list, p_226098_);
        List<FoliagePlacer.FoliageAttachment> list1 = Lists.newArrayList();

        for(MangroveFancyTrunkPlacer.FoliageCoords mangrovefancytrunkplacer$foliagecoords : list) {
            if (this.trimBranches(j, mangrovefancytrunkplacer$foliagecoords.getBranchBase() - p_226097_.getY())) {
                list1.add(mangrovefancytrunkplacer$foliagecoords.attachment);
            }
        }

        return list1;
    }

    private boolean makeLimb(LevelSimulatedReader p_226108_, BiConsumer<BlockPos, BlockState> p_226109_, RandomSource p_226110_, BlockPos p_226111_, BlockPos p_226112_, boolean p_226113_, TreeConfiguration p_226114_) {
        if (!p_226113_ && Objects.equals(p_226111_, p_226112_)) {
            return true;
        } else {
            BlockPos blockpos = p_226112_.offset(-p_226111_.getX(), -p_226111_.getY(), -p_226111_.getZ());
            int i = this.getSteps(blockpos);
            float f = (float)blockpos.getX() / (float)i;
            float f1 = (float)blockpos.getY() / (float)i;
            float f2 = (float)blockpos.getZ() / (float)i;

            for(int j = 0; j <= i; ++j) {
                BlockPos blockpos1 = p_226111_.offset((double)(0.5F + (float)j * f), (double)(0.5F + (float)j * f1), (double)(0.5F + (float)j * f2));
                if (p_226113_) {
                    this.placeLog(p_226108_, p_226109_, p_226110_, blockpos1, p_226114_, (p_161826_) -> {
                        return p_161826_.setValue(RotatedPillarBlock.AXIS, this.getLogAxis(p_226111_, blockpos1));
                    });
                } else if (!this.isFree(p_226108_, blockpos1)) {
                    return false;
                }
            }

            return true;
        }
    }

    private int getSteps(BlockPos p_70128_) {
        int i = Mth.abs(p_70128_.getX());
        int j = Mth.abs(p_70128_.getY());
        int k = Mth.abs(p_70128_.getZ());
        return Math.max(i, Math.max(j, k));
    }

    private Direction.Axis getLogAxis(BlockPos p_70130_, BlockPos p_70131_) {
        Direction.Axis direction$axis = Direction.Axis.Y;
        int i = Math.abs(p_70131_.getX() - p_70130_.getX());
        int j = Math.abs(p_70131_.getZ() - p_70130_.getZ());
        int k = Math.max(i, j);
        if (k > 0) {
            if (i == k) {
                direction$axis = Direction.Axis.X;
            } else {
                direction$axis = Direction.Axis.Z;
            }
        }

        return direction$axis;
    }

    private boolean trimBranches(int p_70099_, int p_70100_) {
        return (double)p_70100_ >= (double)p_70099_ * 0.2D;
    }

    private void makeBranches(LevelSimulatedReader p_226100_, BiConsumer<BlockPos, BlockState> p_226101_, RandomSource p_226102_, int p_226103_, BlockPos p_226104_, List<FoliageCoords> p_226105_, TreeConfiguration p_226106_) {
        for(MangroveFancyTrunkPlacer.FoliageCoords mangrovefancytrunkplacer$foliagecoords : p_226105_) {
            int i = mangrovefancytrunkplacer$foliagecoords.getBranchBase();
            BlockPos blockpos = new BlockPos(p_226104_.getX(), i, p_226104_.getZ());
            if (!blockpos.equals(mangrovefancytrunkplacer$foliagecoords.attachment.pos()) && this.trimBranches(p_226103_, i - p_226104_.getY())) {
                this.makeLimb(p_226100_, p_226101_, p_226102_, blockpos, mangrovefancytrunkplacer$foliagecoords.attachment.pos(), true, p_226106_);
            }
        }

    }

    private static float treeShape(int p_70133_, int p_70134_) {
        if ((float)p_70134_ < (float)p_70133_ * 0.3F) {
            return -1.0F;
        } else {
            float f = (float)p_70133_ / 2.0F;
            float f1 = f - (float)p_70134_;
            float f2 = Mth.sqrt(f * f - f1 * f1);
            if (f1 == 0.0F) {
                f2 = f;
            } else if (Math.abs(f1) >= f) {
                return 0.0F;
            }

            return f2 * 0.5F;
        }
    }

    static class FoliageCoords {
        final FoliagePlacer.FoliageAttachment attachment;
        private final int branchBase;

        public FoliageCoords(BlockPos p_70140_, int p_70141_) {
            this.attachment = new FoliagePlacer.FoliageAttachment(p_70140_, 0, false);
            this.branchBase = p_70141_;
        }

        public int getBranchBase() {
            return this.branchBase;
        }
    }
}