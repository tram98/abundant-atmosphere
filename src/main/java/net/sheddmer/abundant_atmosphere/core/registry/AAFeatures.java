package net.sheddmer.abundant_atmosphere.core.registry;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;


@Mod.EventBusSubscriber(modid = AbundantAtmosphere.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AAFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, AbundantAtmosphere.MOD_ID);

}