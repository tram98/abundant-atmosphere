package net.sheddmer.abundant_atmosphere.block;

import cpw.mods.util.LambdaExceptionUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sheddmer.abundant_atmosphere.Abundant_Atmosphere;
import net.sheddmer.abundant_atmosphere.block.custom.MossyDeepslateBlock;
import net.sheddmer.abundant_atmosphere.item.ModItems;
import org.antlr.v4.Tool;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Abundant_Atmosphere.MOD_ID);

    public static final RegistryObject<Block> MOSSY_STONE = registerBlock("mossy_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f)
                    .requiresCorrectToolForDrops().explosionResistance(6).sound(SoundType.STONE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> MOSSY_DEEPSLATE = registerBlock("mossy_deepslate",
            () -> new MossyDeepslateBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f)
                    .requiresCorrectToolForDrops().explosionResistance(6).sound(SoundType.DEEPSLATE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
      RegistryObject<T> toReturn = BLOCKS.register(name, block);
      registerBlockItem(name, toReturn, tab);
      return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
        return ModItems.Items.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
