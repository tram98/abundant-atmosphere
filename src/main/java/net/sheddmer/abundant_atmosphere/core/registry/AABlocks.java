package net.sheddmer.abundant_atmosphere.core.registry;

import com.teamabnormals.blueprint.common.block.BlueprintFlowerBlock;
import com.teamabnormals.blueprint.common.block.wood.*;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.core.blocks.CenterPieceBlock;
import net.sheddmer.abundant_atmosphere.core.blocks.DeepslatePotBlock;
import net.sheddmer.abundant_atmosphere.core.blocks.MudPotBlock;
import net.sheddmer.abundant_atmosphere.core.blocks.BlockProperties;
import net.sheddmer.abundant_atmosphere.core.blocks.vegetation.*;
import net.sheddmer.abundant_atmosphere.core.levelgen.grower.AshTreeGrower;

@Mod.EventBusSubscriber(modid = AbundantAtmosphere.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AABlocks {

    public static final BlockSubRegistryHelper HELPER = AbundantAtmosphere.REGISTRY_HELPER.getBlockSubHelper();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AbundantAtmosphere.MOD_ID);

    // Natural blocks
    public static final RegistryObject<Block> MOSSY_STONE         = HELPER.createBlock("mossy_stone", () -> new Block(BlockProperties.MOSSY_STONE), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MOSSY_DEEPSLATE     = HELPER.createBlock("mossy_deepslate", () -> new RotatedPillarBlock(BlockProperties.MOSSY_DEEPSLATE), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_ASH_LOG    = HELPER.createBlock("stripped_ash_log", () -> new StrippedLogBlock(BlockProperties.ASH_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_ASH_WOOD   = HELPER.createBlock("stripped_ash_wood", () -> new StrippedWoodBlock(BlockProperties.ASH_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ASH_LOG             = HELPER.createBlock("ash_log", () -> new LogBlock(AABlocks.STRIPPED_ASH_LOG, BlockProperties.ASH_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ASH_WOOD            = HELPER.createBlock("ash_wood", () -> new WoodBlock(AABlocks.STRIPPED_ASH_WOOD, BlockProperties.ASH_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ASH_PLANKS          = HELPER.createBlock("ash_planks", () -> new PlanksBlock(BlockProperties.ASH_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ASH_DOOR            = HELPER.createBlock("ash_door", () -> new WoodDoorBlock(BlockProperties.ASH_WOOD_NOT_SOLID), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> ASH_SLAB            = HELPER.createBlock("ash_slab", () -> new WoodSlabBlock(BlockProperties.ASH_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ASH_STAIRS          = HELPER.createBlock("ash_stairs", () -> new WoodStairBlock(ASH_PLANKS.get().defaultBlockState(), BlockProperties.ASH_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ASH_FENCE           = HELPER.createFuelBlock("ash_fence", () -> new WoodFenceBlock(BlockProperties.ASH_WOOD), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> ASH_FENCE_GATE      = HELPER.createFuelBlock("ash_fence_gate", () -> new WoodFenceGateBlock(BlockProperties.ASH_WOOD), 300, CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> ASH_PRESSURE_PLATE  = HELPER.createBlock("ash_pressure_plate", () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockProperties.ASH_WOOD), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> ASH_BUTTON          = HELPER.createBlock("ash_button", () -> new BlueprintWoodButtonBlock(BlockProperties.getAshWood(false, true)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> ASH_TRAPDOOR        = HELPER.createBlock("ash_trapdoor", () -> new WoodTrapDoorBlock(BlockProperties.ASH_WOOD_NOT_SOLID), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> ASH_LEAVES          = HELPER.createBlock("ash_leaves", () -> new BlueprintLeavesBlock(BlockProperties.ASH.leaves()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> HANGING_ASH_LEAVES  = HELPER.createBlock("hanging_ash_leaves", () -> new HangingAshLeavesBlock(BlockProperties.ASH.leaves()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> ASH_SAPLING         = HELPER.createBlock("ash_sapling", () -> new BlueprintSaplingBlock(new AshTreeGrower(), PropertyUtil.SAPLING), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_ASH_SAPLING  = HELPER.createBlockNoItem("potted_ash_sapling", () -> new FlowerPotBlock(ASH_SAPLING.get(), PropertyUtil.FLOWER_POT));
    public static final RegistryObject<Block> MANGROVE_WEAVE      = HELPER.createBlock("mangrove_weave", () -> new Block(BlockProperties.MANGROVE_WEAVE), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MANGROVE_WEAVE_MAT  = HELPER.createBlock("mangrove_weave_mat", () -> new CarpetBlock(BlockProperties.MANGROVE_WEAVE), CreativeModeTab.TAB_DECORATIONS);

    // Deco blocks
    public static final RegistryObject<Block> MIXED_BRICKS        = HELPER.createBlock("mixed_bricks", () -> new Block(BlockProperties.MIXED_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MIXED_BRICK_SLAB    = HELPER.createBlock("mixed_brick_slab", () -> new SlabBlock(BlockProperties.MIXED_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MIXED_BRICK_STAIRS  = HELPER.createBlock("mixed_brick_stairs", () -> new StairBlock(MIXED_BRICKS.get().defaultBlockState(), BlockProperties.MIXED_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MIXED_BRICK_WALL    = HELPER.createBlock("mixed_brick_wall", () -> new WallBlock(BlockProperties.MIXED_BRICKS), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> POLISHED_CALCITE    = HELPER.createBlock("polished_calcite", () -> new Block(BlockProperties.CALCITE_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_CALCITE_SLAB = HELPER.createBlock("polished_calcite_slab", () -> new SlabBlock(BlockProperties.CALCITE_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_CALCITE_STAIRS  = HELPER.createBlock("polished_calcite_stairs", () -> new StairBlock(() -> POLISHED_CALCITE.get().defaultBlockState(), BlockProperties.CALCITE_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_CALCITE_WALL = HELPER.createBlock("polished_calcite_wall", () -> new WallBlock(BlockProperties.CALCITE_BRICKS), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CALCITE_BRICKS      = HELPER.createBlock("calcite_bricks", () -> new Block(BlockProperties.CALCITE_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CALCITE_BRICK_SLAB  = HELPER.createBlock("calcite_brick_slab", () -> new SlabBlock(BlockProperties.CALCITE_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CALCITE_BRICK_STAIRS = HELPER.createBlock("calcite_brick_stairs", () -> new StairBlock(() -> CALCITE_BRICKS.get().defaultBlockState(), BlockProperties.CALCITE_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CALCITE_BRICK_WALL  = HELPER.createBlock("calcite_brick_wall", () -> new WallBlock(BlockProperties.CALCITE_BRICKS), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CHISELED_CALCITE_BRICKS = HELPER.createBlock("chiseled_calcite_bricks", () -> new Block(BlockProperties.CALCITE_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> POLISHED_DRIPSTONE  = HELPER.createBlock("polished_dripstone", () -> new Block(BlockProperties.DRIPSTONE_TILES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_DRIPSTONE_SLAB = HELPER.createBlock("polished_dripstone_slab", () -> new SlabBlock(BlockProperties.DRIPSTONE_TILES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_DRIPSTONE_STAIRS = HELPER.createBlock("polished_dripstone_stairs", () -> new StairBlock(() -> POLISHED_DRIPSTONE.get().defaultBlockState(), BlockProperties.DRIPSTONE_TILES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_DRIPSTONE_WALL = HELPER.createBlock("polished_dripstone_wall", () -> new WallBlock(BlockProperties.DRIPSTONE_TILES), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> DRIPSTONE_TILES     = HELPER.createBlock("dripstone_tiles", () -> new Block(BlockProperties.DRIPSTONE_TILES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DRIPSTONE_TILE_SLAB = HELPER.createBlock("dripstone_tile_slab", () -> new SlabBlock(BlockProperties.DRIPSTONE_TILES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DRIPSTONE_TILE_STAIRS = HELPER.createBlock("dripstone_tile_stairs", () -> new StairBlock(() -> DRIPSTONE_TILES.get().defaultBlockState(), BlockProperties.DRIPSTONE_TILES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DRIPSTONE_TILE_WALL = HELPER.createBlock("dripstone_tile_wall", () -> new WallBlock(BlockProperties.DRIPSTONE_TILES), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> BASALT_BRICKS       = HELPER.createBlock("basalt_bricks", () -> new Block(BlockProperties.BASALT_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CHISELED_BASALT_BRICKS = HELPER.createBlock("chiseled_basalt_bricks", () -> new Block(BlockProperties.BASALT_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLACKSTONE_BASALT_TILES = HELPER.createBlock("blackstone_basalt_tiles", () -> new Block(BlockProperties.BLACKSTONE_BASALT_TILES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CHISELED_MUD_BRICKS = HELPER.createBlock("chiseled_mud_bricks", () -> new Block(BlockProperties.CHISELED_MUD_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEEPSLATE_PILLAR    = HELPER.createBlock("deepslate_pillar", () -> new RotatedPillarBlock(BlockProperties.DEEPSLATE_PILLAR), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CHISELED_DEEPSLATE_TILES = HELPER.createBlock("chiseled_deepslate_tiles", () -> new Block(BlockProperties.CHISELED_DEEPSLATE_TILES), CreativeModeTab.TAB_BUILDING_BLOCKS);

        // Pot blocks
    public static final RegistryObject<Block> ANCIENT_POT         = HELPER.createBlock("ancient_pot", () -> new DeepslatePotBlock(BlockProperties.DEEPSLATE_POT), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEEPSLATE_POT       = HELPER.createBlock("deepslate_pot", () -> new DeepslatePotBlock(BlockProperties.DEEPSLATE_POT), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MUD_POT             = HELPER.createBlock("mud_pot", () -> new MudPotBlock(BlockProperties.MUD_POT), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CARVED_MUD_POT      = HELPER.createBlock("carved_mud_pot", () -> new MudPotBlock(BlockProperties.MUD_POT), CreativeModeTab.TAB_BUILDING_BLOCKS);

        // Nature deco blocks
    public static final RegistryObject<Block> PORESHROOM          = HELPER.createBlock("poreshroom", () -> new BlueprintFlowerBlock(() -> MobEffects.GLOWING, 12, PropertyUtil.FLOWER), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_PORESHROOM   = HELPER.createBlockNoItem("potted_poreshroom", () -> new FlowerPotBlock(PORESHROOM.get(), PropertyUtil.FLOWER_POT));
    public static final RegistryObject<Block> PORESHROOM_SHELF    = HELPER.createBlock("poreshroom_shelf", () -> new PoreshroomShelfBlock(BlockProperties.PORESHROOM_SHELF), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FOXFIRE_MUSHROOM    = HELPER.createBlock("foxfire_mushroom", () -> new BlueprintFlowerBlock(() -> MobEffects.GLOWING, 12, PropertyUtil.FLOWER), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_FOXFIRE_MUSHROOM = HELPER.createBlockNoItem("potted_foxfire_mushroom", () -> new FlowerPotBlock(FOXFIRE_MUSHROOM.get(), PropertyUtil.FLOWER_POT));
    public static final RegistryObject<Block> FOXFIRE_SHELF       = HELPER.createBlock("foxfire_shelf", () -> new FoxfireShelfBlock(BlockProperties.FOXFIRE_SHELF), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CATSBANE            = HELPER.createBlock("catsbane", () -> new CatsbaneBlock(BlockProperties.CATSBANE), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_CATSBANE   = HELPER.createBlockNoItem("potted_catsbane", () -> new FlowerPotBlock(CATSBANE.get(), PropertyUtil.FLOWER_POT));
    public static final RegistryObject<Block> CURVED_MANGROVE_ROOTS = HELPER.createBlock("curved_mangrove_roots", () -> new CurvedRootsBlock(BlockProperties.CURVED_MANGROVE_ROOTS), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MOSS_CLUMP          = HELPER.createBlock("moss_clump", () -> new GlowLichenBlock(BlockProperties.MOSS_CLUMP), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> SMALL_LILY_PAD    = HELPER.createBlock("small_lily_pad", () -> new WaterlilyBlock(BlockProperties.SMALL_LILY_PAD), CreativeModeTab.TAB_DECORATIONS);

        // Trophy blocks
    public static final RegistryObject<Block> CENTERPIECE_STATUE  = HELPER.createBlock("centerpiece_statue", () -> new CenterPieceBlock(BlockProperties.CENTERPIECE_STATUE), CreativeModeTab.TAB_BUILDING_BLOCKS);

}
