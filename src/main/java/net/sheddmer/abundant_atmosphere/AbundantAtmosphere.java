package net.sheddmer.abundant_atmosphere;

import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sheddmer.abundant_atmosphere.common.levelgen.event.MiscEvents;
import net.sheddmer.abundant_atmosphere.common.registry.*;

@Mod(AbundantAtmosphere.MOD_ID)
public class AbundantAtmosphere {

    public static final String MOD_ID = "abundant_atmosphere";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);


    public AbundantAtmosphere() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus eventBus = MinecraftForge.EVENT_BUS;
        modEventBus.addListener(this::commonSetup);

        AABlocks.BLOCKS.register(modEventBus);
        AAFeatures.FEATURES.register(modEventBus);
        AAItems.ITEMS.register(modEventBus);


        eventBus.register(this);
        eventBus.register(new MiscEvents());

        modEventBus.addListener(this::rendererSetup);

    }
    private void rendererSetup(EntityRenderersEvent.RegisterRenderers event) {}

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AAConfiguredFeatures.init();
            AAPlacedFeatures.init();
        });
    }
}