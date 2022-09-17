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
import net.sheddmer.abundant_atmosphere.block.custom.*;
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

    public static final RegistryObject<Block> POLISHED_CALCITE = registerBlock("polished_calcite",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.75f)
                    .requiresCorrectToolForDrops().explosionResistance(0.75f).sound(SoundType.CALCITE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CALCITE_BRICKS = registerBlock("calcite_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.75f)
                    .requiresCorrectToolForDrops().explosionResistance(0.75f).sound(SoundType.CALCITE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CHISELED_CALCITE_BRICKS = registerBlock("chiseled_calcite_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.75f)
                    .requiresCorrectToolForDrops().explosionResistance(0.75f).sound(SoundType.CALCITE)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_DRIPSTONE = registerBlock("polished_dripstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f)
                    .requiresCorrectToolForDrops().explosionResistance(1).sound(SoundType.DRIPSTONE_BLOCK)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DRIPSTONE_TILES = registerBlock("dripstone_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f)
                    .requiresCorrectToolForDrops().explosionResistance(1).sound(SoundType.DRIPSTONE_BLOCK)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BASALT_BRICKS = registerBlock("basalt_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.25f)
                    .requiresCorrectToolForDrops().explosionResistance(4.2f).sound(SoundType.BASALT)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CHISELED_BASALT_BRICKS = registerBlock("chiseled_basalt_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.25f)
                    .requiresCorrectToolForDrops().explosionResistance(4.2f).sound(SoundType.BASALT)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLACKSTONE_BASALT_TILES = registerBlock("blackstone_basalt_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.25f)
                    .requiresCorrectToolForDrops().explosionResistance(4.2f).sound(SoundType.BASALT)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> ANCIENT_POT = registerBlock("ancient_pot",
            () -> new DeepslatePotBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f)
                    .requiresCorrectToolForDrops().explosionResistance(6).sound(SoundType.DEEPSLATE)),
            CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> DEEPSLATE_POT = registerBlock("deepslate_pot",
            () -> new DeepslatePotBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f)
                    .requiresCorrectToolForDrops().explosionResistance(6).sound(SoundType.DEEPSLATE)),
            CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> DEEPSLATE_PILLAR = registerBlock("deepslate_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f)
                    .requiresCorrectToolForDrops().explosionResistance(6).sound(SoundType.DEEPSLATE_BRICKS)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CHISELED_DEEPSLATE_TILES = registerBlock("chiseled_deepslate_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f)
                    .requiresCorrectToolForDrops().explosionResistance(6).sound(SoundType.DEEPSLATE_TILES)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

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
    public static final RegistryObject<Block> FOXFIRE_SHELF = registerBlock("foxfire_shelf",
            () -> new FoxfireShelfBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak()
                    .sound(SoundType.FUNGUS).noCollission().lightLevel(
                            (state) -> state.getValue(FoxfireShelfBlock.UNLIT) ? 0 : 6)),
            CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CATSBANE = registerBlock("catsbane",
            () -> new CatsbaneBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak()
                    .sound(SoundType.FUNGUS).noCollission()),
            CreativeModeTab.TAB_DECORATIONS);


    public static final RegistryObject<Block> CURVED_MANGROVE_ROOTS = registerBlock("curved_mangrove_roots",
            () -> new CurvedRootsBlock(BlockBehaviour.Properties.of(Material.WOOD).instabreak()
                    .sound(SoundType.MANGROVE_ROOTS).noCollission()),
            CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> CENTERPIECE_STATUE = registerBlock("centerpiece_statue",
            () -> new CenterPieceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f)
                    .requiresCorrectToolForDrops().explosionResistance(6)
                    .sound(SoundType.DEEPSLATE)),
            CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> MOSS_CLUMP = registerBlock("moss_clump",
            () -> new GlowLichenBlock(BlockBehaviour.Properties.of(Material.MOSS).instabreak()
                    .sound(SoundType.MOSS).noCollission()),
            CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> SMALL_LILY_PAD = registerBlock("small_lily_pad",
            () -> new WaterlilyBlock(BlockBehaviour.Properties.of(Material.WATER_PLANT).instabreak()
                    .sound(SoundType.LILY_PAD)),
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
