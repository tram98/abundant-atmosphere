package net.sheddmer.abundant_atmosphere.common.registry;

import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

@Mod.EventBusSubscriber(modid = AbundantAtmosphere.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AAItems {
    public static final ItemSubRegistryHelper HELPER = AbundantAtmosphere.REGISTRY_HELPER.getItemSubHelper();

    // Regular items
    public static final RegistryObject<Item> AMBER_CHUNKS = HELPER.createItem("amber_chunks", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> ANCIENT_AMBER = HELPER.createItem("ancient_amber", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> FROG_HIDE = HELPER.createItem("frog_hide", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    // Food items
    public static final RegistryObject<Item> FROG_LEG = HELPER.createItem("frog_leg", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(AAFoods.FROG_LEG)));
    public static final RegistryObject<Item> COOKED_FROG_LEG = HELPER.createItem("cooked_frog_leg", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(AAFoods.COOKED_FROG_LEG)));

    public static class AAFoods {
        public static final FoodProperties FROG_LEG = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
        public static final FoodProperties COOKED_FROG_LEG = new FoodProperties.Builder().nutrition(6).saturationMod(0.4F).build();
    }
}