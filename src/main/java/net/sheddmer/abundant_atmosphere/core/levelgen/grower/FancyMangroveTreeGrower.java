package net.sheddmer.abundant_atmosphere.core.levelgen.grower;

import javax.annotation.Nullable;
import net.minecraft.core.Holder;
import net.sheddmer.abundant_atmosphere.core.levelgen.feature.FancyMangroveTreeFeature;
import net.sheddmer.abundant_atmosphere.core.levelgen.feature.FancyTallMangroveTreeFeature;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class FancyMangroveTreeGrower extends AbstractTreeGrower {
    private final float tallProbability;

    public FancyMangroveTreeGrower(float p_222933_) {
        this.tallProbability = p_222933_;
    }

    @Nullable
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222935_, boolean p_222936_) {
        return p_222935_.nextFloat() < this.tallProbability ? FancyTallMangroveTreeFeature.FANCY_TALL_MANGROVE_TREE : FancyMangroveTreeFeature.FANCY_MANGROVE_TREE;
    }
}