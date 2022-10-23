package net.sheddmer.abundant_atmosphere.common.levelgen.grower;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.sheddmer.abundant_atmosphere.common.levelgen.feature.FancyBirchTreeFeature;

import javax.annotation.Nullable;

public class FancyBirchTreeGrower extends AbstractTreeGrower {
    @Nullable
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222916_, boolean p_222917_) {
        return FancyBirchTreeFeature.FANCY_BIRCH_TREE;
    }
}