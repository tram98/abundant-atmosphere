package net.sheddmer.abundant_atmosphere;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sheddmer.abundant_atmosphere.block.ModBlocks;
import net.sheddmer.abundant_atmosphere.item.ModItems;
import org.slf4j.Logger;


@Mod(Abundant_Atmosphere.MOD_ID)
public class Abundant_Atmosphere
{
    public static final String MOD_ID = "abundant_atmosphere";

    private static final Logger LOGGER = LogUtils.getLogger();

    public Abundant_Atmosphere()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PORESHROOM.getId(), ModBlocks.POTTED_PORESHROOM);
        });
    }
}
