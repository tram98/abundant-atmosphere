package net.sheddmer.abundant_atmosphere.core.blocks.vegetation;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class FoxfireMushroomBlock extends BushBlock implements BonemealableBlock {
    protected static final float AABB_OFFSET = 3.0F;
    protected static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 12, 13);
    private final Supplier<Holder<? extends ConfiguredFeature<?, ?>>> featureSupplier;
    public static final BooleanProperty UNLIT = BooleanProperty.create("unlit");


    public FoxfireMushroomBlock(Properties p_153983_, Supplier<Holder<? extends ConfiguredFeature<?, ?>>> p_153984_) {
        super(p_153983_);
        this.featureSupplier = p_153984_;
    }

    public VoxelShape getShape(BlockState p_54889_, BlockGetter p_54890_, BlockPos p_54891_, CollisionContext p_54892_) {
        return SHAPE;
    }

    public void randomTick(BlockState p_221784_, ServerLevel p_221785_, BlockPos p_221786_, RandomSource p_221787_) {
        if (p_221787_.nextInt(25) == 0) {
            int i = 5;
            int j = 4;

            for(BlockPos blockpos : BlockPos.betweenClosed(p_221786_.offset(-4, -1, -4), p_221786_.offset(4, 1, 4))) {
                if (p_221785_.getBlockState(blockpos).is(this)) {
                    --i;
                    if (i <= 0) {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = p_221786_.offset(p_221787_.nextInt(3) - 1, p_221787_.nextInt(2) - p_221787_.nextInt(2), p_221787_.nextInt(3) - 1);

            for(int k = 0; k < 4; ++k) {
                if (p_221785_.isEmptyBlock(blockpos1) && p_221784_.canSurvive(p_221785_, blockpos1)) {
                    p_221786_ = blockpos1;
                }

                blockpos1 = p_221786_.offset(p_221787_.nextInt(3) - 1, p_221787_.nextInt(2) - p_221787_.nextInt(2), p_221787_.nextInt(3) - 1);
            }

            if (p_221785_.isEmptyBlock(blockpos1) && p_221784_.canSurvive(p_221785_, blockpos1)) {
                p_221785_.setBlock(blockpos1, p_221784_, 2);
            }
        }

    }

    protected boolean mayPlaceOn(BlockState p_54894_, BlockGetter p_54895_, BlockPos p_54896_) {
        return p_54894_.isSolidRender(p_54895_, p_54896_);
    }

    public boolean canSurvive(BlockState p_54880_, LevelReader p_54881_, BlockPos p_54882_) {
        BlockPos blockpos = p_54882_.below();
        BlockState blockstate = p_54881_.getBlockState(blockpos);
        if (blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return true;
        } else {
            return p_54881_.getRawBrightness(p_54882_, 0) < 13 && blockstate.canSustainPlant(p_54881_, blockpos, net.minecraft.core.Direction.UP, this);
        }
    }

    public boolean growMushroom(ServerLevel p_221774_, BlockPos p_221775_, BlockState p_221776_, RandomSource p_221777_) {
        p_221774_.removeBlock(p_221775_, false);
        if (this.featureSupplier.get().value().place(p_221774_, p_221774_.getChunkSource().getGenerator(), p_221777_, p_221775_)) {
            return true;
        } else {
            p_221774_.setBlock(p_221775_, p_221776_, 3);
            return false;
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            boolean currentState = pState.getValue(UNLIT);
            pLevel.setBlock(pPos, pState.setValue(UNLIT, !currentState), 3);
        }

        return InteractionResult.SUCCESS;
    }

    public boolean isValidBonemealTarget(BlockGetter p_54870_, BlockPos p_54871_, BlockState p_54872_, boolean p_54873_) {
        return true;
    }

    public boolean isBonemealSuccess(Level p_221779_, RandomSource p_221780_, BlockPos p_221781_, BlockState p_221782_) {
        return (double)p_221780_.nextFloat() < 0.4D;
    }

    public void performBonemeal(ServerLevel p_221769_, RandomSource p_221770_, BlockPos p_221771_, BlockState p_221772_) {
        this.growMushroom(p_221769_, p_221771_, p_221772_, p_221770_);

    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(UNLIT);
    }
}
