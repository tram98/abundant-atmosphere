package net.sheddmer.abundant_atmosphere.core.levelgen.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.sheddmer.abundant_atmosphere.core.levelgen.treedecorator.PoreshroomDecorator;

import java.util.List;


public class FancyBirchTreeFeature {

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FANCY_BIRCH_TREE = FeatureUtils.register("fancy_birch_tree", Feature.TREE,
            (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.BIRCH_LOG),
                    new StraightTrunkPlacer(7, 4, 3), BlockStateProvider.simple(Blocks.BIRCH_LEAVES),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(new PoreshroomDecorator(0.125F))
            ).ignoreVines().build()));

}
