package net.sheddmer.abundant_atmosphere.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sheddmer.abundant_atmosphere.Abundant_Atmosphere;

public class ModItems {
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, Abundant_Atmosphere.MOD_ID);

    public static final RegistryObject<Item> AMBER_CHUNK = Items.register(  "amber_chunk",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> ANCIENT_AMBER = Items.register(  "ancient_amber",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }
}
