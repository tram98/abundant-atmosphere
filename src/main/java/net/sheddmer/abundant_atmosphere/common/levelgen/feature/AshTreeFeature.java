package net.sheddmer.abundant_atmosphere.common.levelgen.feature;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.sheddmer.abundant_atmosphere.common.levelgen.treedecorator.FoxfireDecorator;

import java.util.List;
import static net.sheddmer.abundant_atmosphere.common.registry.AAFeatures.States.HANGING_ASH_LEAVES;
import static net.sheddmer.abundant_atmosphere.common.registry.AAFeatures.States.ASH_LEAVES;
import static net.sheddmer.abundant_atmosphere.common.registry.AAFeatures.States.ASH_LOG;


public class AshTreeFeature {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> ASH_TREE = FeatureUtils.register("ash", Feature.TREE,
            (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ASH_LOG),
                    new FancyTrunkPlacer(5, 4, 4), BlockStateProvider.simple(ASH_LEAVES),
                    new RandomSpreadFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(3), 60),
                    new TwoLayersFeatureSize(2, 2, 4))).decorators(List.of(new FoxfireDecorator(0.5F),
                            new AttachedToLeavesDecorator(0.5F, 1, 0, BlockStateProvider.simple(HANGING_ASH_LEAVES), 2, List.of(Direction.DOWN))
            )).ignoreVines().build());
}
