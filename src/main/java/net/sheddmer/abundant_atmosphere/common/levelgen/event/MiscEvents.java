package net.sheddmer.abundant_atmosphere.common.levelgen.event;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.levelgen.grower.FancyBirchTreeGrower;
import net.sheddmer.abundant_atmosphere.common.levelgen.grower.FancyMangroveTreeGrower;

@Mod.EventBusSubscriber(modid = AbundantAtmosphere.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MiscEvents {

    @SubscribeEvent
    public void onSaplingGrow(SaplingGrowTreeEvent event) {
        BlockPos pos = event.getPos();
        LevelAccessor world = event.getLevel();
        BlockState state = world.getBlockState(pos);
        RandomSource random = event.getRandomSource();
        if (world instanceof ServerLevel serverLevel) {
            ChunkGenerator generator = serverLevel.getChunkSource().getGenerator();
            if (state.is(Blocks.MANGROVE_PROPAGULE)) {
                event.setResult(Event.Result.DENY);
                FancyMangroveTreeGrower grower = new FancyMangroveTreeGrower(0.85F);
                grower.growTree(serverLevel, generator, pos, state, random);
            }
        }
        if (world instanceof ServerLevel serverLevel) {
            ChunkGenerator generator = serverLevel.getChunkSource().getGenerator();
            if (state.is(Blocks.BIRCH_SAPLING)) {
                event.setResult(Event.Result.DENY);
                FancyBirchTreeGrower grower = new FancyBirchTreeGrower();
                grower.growTree(serverLevel, generator, pos, state, random);
            }
        }
    }
}