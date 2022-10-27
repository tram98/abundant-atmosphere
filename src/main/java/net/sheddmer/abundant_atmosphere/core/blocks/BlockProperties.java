package net.sheddmer.abundant_atmosphere.core.blocks;

import com.teamabnormals.blueprint.core.util.PropertyUtil;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.sheddmer.abundant_atmosphere.core.blocks.vegetation.FoxfireShelfBlock;

public class BlockProperties {
        // Natural blocks
    public static final BlockBehaviour.Properties MOSSY_STONE = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5F).explosionResistance(6).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties MOSSY_DEEPSLATE = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(3).explosionResistance(6).sound(SoundType.DEEPSLATE);
    public static final BlockBehaviour.Properties ASH_WOOD = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GRAY).sound(SoundType.WOOD).strength(2);
    public static final BlockBehaviour.Properties ASH_WOOD_NOT_SOLID = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GRAY).sound(SoundType.WOOD).noOcclusion().strength(2, 10);
    public static final PropertyUtil.WoodSetProperties ASH = PropertyUtil.WoodSetProperties.builder(MaterialColor.TERRACOTTA_YELLOW).build();
        // Deco blocks
    public static final BlockBehaviour.Properties MIXED_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.PODZOL).requiresCorrectToolForDrops().strength(2).explosionResistance(6).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties CALCITE_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE).requiresCorrectToolForDrops().strength(0.75F).explosionResistance(0.75F).sound(SoundType.CALCITE);
    public static final BlockBehaviour.Properties DRIPSTONE_TILES = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).requiresCorrectToolForDrops().strength(1.5F).explosionResistance(1).sound(SoundType.DRIPSTONE_BLOCK);
    public static final BlockBehaviour.Properties BASALT_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(1.25F).explosionResistance(4.2F).sound(SoundType.BASALT);
    public static final BlockBehaviour.Properties BLACKSTONE_BASALT_TILES = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(1.25F).explosionResistance(4.2F).sound(SoundType.BASALT);
    public static final BlockBehaviour.Properties CHISELED_MUD_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).requiresCorrectToolForDrops().strength(1).explosionResistance(3).sound(SoundType.MUD_BRICKS);
    public static final BlockBehaviour.Properties DEEPSLATE_PILLAR = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(3).explosionResistance(6).sound(SoundType.DEEPSLATE_BRICKS);
    public static final BlockBehaviour.Properties CHISELED_DEEPSLATE_TILES = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(3).explosionResistance(6).sound(SoundType.DEEPSLATE_TILES);
    public static final BlockBehaviour.Properties MANGROVE_WEAVE = BlockBehaviour.Properties.of(Material.WOOD).strength(0.7F).randomTicks().sound(SoundType.MANGROVE_ROOTS).noOcclusion();
        // Pot blocks
    public static final BlockBehaviour.Properties DEEPSLATE_POT = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).strength(3).explosionResistance(6).sound(SoundType.DEEPSLATE);
    public static final BlockBehaviour.Properties MUD_POT = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).strength(1).explosionResistance(3).sound(SoundType.PACKED_MUD);
        // Nature deco
    public static final BlockBehaviour.Properties PORESHROOM = BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.FUNGUS).noCollission().noOcclusion();
    public static final BlockBehaviour.Properties PORESHROOM_SHELF = BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.FUNGUS).noCollission();
    public static final BlockBehaviour.Properties FOXFIRE_MUSHROOM = BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.FUNGUS).noCollission().noOcclusion().lightLevel((state) -> state.getValue(FoxfireShelfBlock.UNLIT) ? 0 : 4);
    public static final BlockBehaviour.Properties FOXFIRE_SHELF = BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.FUNGUS).noCollission().lightLevel((state) -> state.getValue(FoxfireShelfBlock.UNLIT) ? 0 : 4);
    public static final BlockBehaviour.Properties CATSBANE = BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.FUNGUS).noCollission();
    public static final BlockBehaviour.Properties CURVED_MANGROVE_ROOTS = BlockBehaviour.Properties.of(Material.WOOD).instabreak().sound(SoundType.MANGROVE_ROOTS).noCollission();
    public static final BlockBehaviour.Properties MOSS_CLUMP = BlockBehaviour.Properties.of(Material.MOSS).instabreak().sound(SoundType.MOSS).noCollission();
    public static final BlockBehaviour.Properties SMALL_LILY_PAD = BlockBehaviour.Properties.of(Material.WATER_PLANT).instabreak().sound(SoundType.LILY_PAD);
        // Trophy blocks
    public static final BlockBehaviour.Properties CENTERPIECE_STATUE = BlockBehaviour.Properties.of(Material.STONE).strength(4f).explosionResistance(6).sound(SoundType.DEEPSLATE);

    public static BlockBehaviour.Properties getAshWood(boolean ticksRandomly, boolean doesNotBlockMovement) {
        Block.Properties ash = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GRAY).sound(SoundType.WOOD).strength(2, 10);
        if (ticksRandomly) {
            ash.randomTicks();
        }
        if (doesNotBlockMovement) {
            ash.noCollission();
        }
        return ash;
    }
    public static BlockBehaviour.Properties leaves(MaterialColor color) {
        return BlockBehaviour.Properties.of(Material.LEAVES, color).noOcclusion().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).isValidSpawn(PropertyUtil::ocelotOrParrot).isSuffocating(PropertyUtil::never).isViewBlocking(PropertyUtil::never);
    }
}
