package net.sheddmer.abundant_atmosphere.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sheddmer.abundant_atmosphere.Abundant_Atmosphere;
import net.sheddmer.abundant_atmosphere.item.custom.ModFoods;

public class ModItems {
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, Abundant_Atmosphere.MOD_ID);

    public static final RegistryObject<Item> AMBER_CHUNKS = Items.register(  "amber_chunks",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> ANCIENT_AMBER = Items.register(  "ancient_amber",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> FROG_LEG = Items.register(  "frog_leg",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.FROG_LEG)));

    public static final RegistryObject<Item> COOKED_FROG_LEG = Items.register(  "cooked_frog_leg",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.COOKED_FROG_LEG)));

    public static final RegistryObject<Item> FROG_HIDE = Items.register(  "frog_hide",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }
}
