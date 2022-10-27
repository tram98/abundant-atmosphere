package net.sheddmer.abundant_atmosphere.core.blocks.vegetation;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PoreshroomShelfBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final float AABB_OFFSET = 3.0F;
    protected static final VoxelShape NORTH_AABB = Block.box(1.0D, 1.0D, 8.0D, 15.0D, 15.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.box(0.0D, 1.0D, 1.0D, 8.0D, 15.0D, 15.0D);
    protected static final VoxelShape SOUTH_AABB = Block.box(1.0D, 1.0D, 0.0D, 15.0D, 15.0D, 8.0D);
    protected static final VoxelShape WEST_AABB = Block.box(8.0D, 1.0D, 1.0D, 16.0D, 15.0D, 15.0D);


    public PoreshroomShelfBlock(Properties properties) {super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public VoxelShape getShape(BlockState p_51787_, BlockGetter p_51788_, BlockPos p_51789_, CollisionContext p_51790_) {
        switch ((Direction)p_51787_.getValue(FACING)) {
            case NORTH:
            default:
                return NORTH_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            case EAST:
                return EAST_AABB;
        }
    }

    private boolean canAttachTo(BlockGetter p_54349_, BlockPos p_54350_, Direction p_54351_) {
        BlockState blockstate = p_54349_.getBlockState(p_54350_);
        return blockstate.isFaceSturdy(p_54349_, p_54350_, p_54351_);
    }

    public boolean canSurvive(BlockState p_54353_, LevelReader p_54354_, BlockPos p_54355_) {
        Direction direction = p_54353_.getValue(FACING);
        return this.canAttachTo(p_54354_, p_54355_.relative(direction.getOpposite()), direction);
    }

    /* FACING */

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    public BlockState updateShape(BlockState p_51771_, Direction p_51772_, BlockState p_51773_, LevelAccessor p_51774_, BlockPos p_51775_, BlockPos p_51776_) {
        return p_51772_ == p_51771_.getValue(FACING) && !p_51771_.canSurvive(p_51774_, p_51775_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_51771_, p_51772_, p_51773_, p_51774_, p_51775_, p_51776_);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51778_) {
        p_51778_.add(FACING);
    }

}