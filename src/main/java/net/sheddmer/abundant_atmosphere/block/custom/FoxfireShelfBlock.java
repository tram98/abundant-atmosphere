package net.sheddmer.abundant_atmosphere.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FoxfireShelfBlock extends HorizontalDirectionalBlock {
    
    //All your blockstates will be up here. Directions is already here
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    //Here I'm adding another blockstate "lit". It is a boolean property (boolean means true or false) so it will have two options.
    //Also be careful not to add to many blockstates to one block. It can create a lot of lag for the game. In this scenario we have
    //4 directions and two possibilities for lit, making 4x2= 8 possibilities. This isn't problematic but you can see how they can add up fast
    public static final BooleanProperty LIT = BooleanProperty.create("lit");
    
    public FoxfireShelfBlock(Properties properties) {super(properties);
    }

    private static final VoxelShape SHAPE_NORTH = Block.box(1, 1, 8, 15, 15, 16);
    private static final VoxelShape SHAPE_EAST = Block.box(1, 1, 0, 15, 15, 8);
    private static final VoxelShape SHAPE_SOUTH = Block.box(8, 1, 1, 16, 15, 15);
    private static final VoxelShape SHAPE_WEST = Block.box(0, 1, 1, 8, 15, 15);

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch ((Direction)pState.getValue(FACING)) {
            case NORTH:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_EAST;
            case WEST:
                return SHAPE_SOUTH;
            case EAST:
            default:
                return SHAPE_WEST;
        }
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
    
    //Blockstate definition is pretty much the registry for your blockstates within the block. If you don't put them here your game will have errors
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, LIT);
    }
}
