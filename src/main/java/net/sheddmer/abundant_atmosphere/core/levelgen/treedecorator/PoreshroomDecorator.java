package net.sheddmer.abundant_atmosphere.core.levelgen.treedecorator;

import com.mojang.serialization.Codec;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.sheddmer.abundant_atmosphere.core.blocks.vegetation.PoreshroomShelfBlock;
import net.sheddmer.abundant_atmosphere.core.registry.AABlocks;

public class PoreshroomDecorator extends TreeDecorator {
    public static final Codec<PoreshroomDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(PoreshroomDecorator::new, (p_69989_) -> {
        return p_69989_.probability;
    }).codec();
    private final float probability;

    public PoreshroomDecorator(float p_69976_) {
        this.probability = p_69976_;
    }

    protected TreeDecoratorType<?> type() {
        return TreeDecoratorType.COCOA;
    }

    public void place(Context p_226028_) {
        RandomSource randomsource = p_226028_.random();
        if (!(randomsource.nextFloat() >= this.probability)) {
            List<BlockPos> list = p_226028_.logs();
            int i = list.get(0).getY();
            list.stream().filter((p_69980_) -> {
                return p_69980_.getY() - i <= 2;
            }).forEach((p_226026_) -> {
                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    if (randomsource.nextFloat() <= 0.25F) {
                        Direction direction1 = direction.getOpposite();
                        BlockPos blockpos = p_226026_.offset(direction1.getStepX(), 0, direction1.getStepZ());
                        if (p_226028_.isAir(blockpos)) {
                            p_226028_.setBlock(blockpos, AABlocks.PORESHROOM_SHELF.get().defaultBlockState().setValue(PoreshroomShelfBlock.FACING, direction.getOpposite()));
                        }
                    }
                }

            });
        }
    }
}