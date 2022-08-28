package net.sheddmer.abundant_atmosphere.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DeepslatePotBlock extends Block {

    public DeepslatePotBlock(Properties properties) {super(properties);
    }

    private static final VoxelShape SHAPE =  Block.box(1, 0, 1, 15, 16, 15);

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}