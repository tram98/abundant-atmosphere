package net.sheddmer.abundant_atmosphere.common.registry;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

@Mod.EventBusSubscriber(modid = AbundantAtmosphere.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AAFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, AbundantAtmosphere.MOD_ID);



    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, AbundantAtmosphere.MOD_ID);

    public static final class States {
        public static final BlockState ASH_LOG = AABlocks.ASH_LOG.get().defaultBlockState();
        public static final BlockState ASH_LEAVES = AABlocks.ASH_LEAVES.get().defaultBlockState();
        public static final BlockState HANGING_ASH_LEAVES = AABlocks.HANGING_ASH_LEAVES.get().defaultBlockState();

        public static final BlockState PORESHROOM_SHELF = AABlocks.PORESHROOM_SHELF.get().defaultBlockState();

    }
}