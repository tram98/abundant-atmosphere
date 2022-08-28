package net.sheddmer.abundant_atmosphere.block;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sheddmer.abundant_atmosphere.Abundant_Atmosphere;
import net.sheddmer.abundant_atmosphere.block.custom.DeepslatePotBlock;
import net.sheddmer.abundant_atmosphere.block.custom.PoreshroomShelfBlock;
import net.sheddmer.abundant_atmosphere.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Abundant_Atmosphere.MOD_ID);

    public static final RegistryObject<Block> MOSSY_STONE = registerBlock("mossy_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f)
                    .requiresCorrectToolForDrops().explosionResistance(6).sound(SoundType.STONE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> MOSSY_DEEPSLATE = registerBlock("mossy_deepslate",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f)
                    .requiresCorrectToolForDrops().explosionResistance(6).sound(SoundType.DEEPSLATE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> MIXED_BRICKS = registerBlock("mixed_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f)
                    .requiresCorrectToolForDrops().explosionResistance(6).sound(SoundType.STONE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_POT = registerBlock("deepslate_pot",
            () -> new DeepslatePotBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f)
                    .requiresCorrectToolForDrops().explosionResistance(6).sound(SoundType.DEEPSLATE)),
            CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> PORESHROOM = registerBlock("poreshroom",
            () -> new MushroomBlock(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(SoundType.FUNGUS).instabreak().noCollission().noOcclusion(), () -> {
                return TreeFeatures.HUGE_BROWN_MUSHROOM;
            }), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_PORESHROOM = registerBlockWithoutBlockItem("potted_poreshroom",
            () -> new FlowerPotBlock(null, ModBlocks.PORESHROOM,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.FUNGUS).noOcclusion()));

    public static final RegistryObject<Block> PORESHROOM_SHELF = registerBlock("poreshroom_shelf",
            () -> new PoreshroomShelfBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak()
                    .sound(SoundType.FUNGUS).noCollission()),
            CreativeModeTab.TAB_DECORATIONS);

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

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
