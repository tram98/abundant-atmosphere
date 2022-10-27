package net.sheddmer.abundant_atmosphere;

import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(AbundantAtmosphere.MOD_ID)
public class AbundantAtmosphere {
    public static final String MOD_ID = "abundant_atmosphere";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

    public AbundantAtmosphere() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        REGISTRY_HELPER.register(bus);


        bus.addListener(this::rendererSetup);

    }
    private void rendererSetup(EntityRenderersEvent.RegisterRenderers event) {}
}