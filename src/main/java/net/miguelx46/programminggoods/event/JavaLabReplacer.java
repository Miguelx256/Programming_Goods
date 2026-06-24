package net.miguelx46.programminggoods.event;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Optional;

public class JavaLabReplacer {

    @SubscribeEvent
    public void onChunkLoad(ChunkEvent.Load event) {

        if (!(event.getLevel() instanceof ServerLevel level))
            return;

        LevelChunk chunk = (LevelChunk) event.getChunk();

        ChunkPos cp = chunk.getPos();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = -64; y < 320; y++) {

                    BlockPos pos =
                            new BlockPos(
                                    cp.getMinBlockX() + x,
                                    y,
                                    cp.getMinBlockZ() + z
                            );

                    if (level.getBlockState(pos)
                            .is(Blocks.GOLD_BLOCK)) {

                        Optional<StructureTemplate> template =
                                level.getStructureManager().get(
                                        ResourceLocation.fromNamespaceAndPath(
                                                ProgrammingGoods.MOD_ID,
                                                "java_lab"
                                        )
                                );

                        if (template.isPresent()) {

                            level.setBlock(
                                    pos,
                                    Blocks.AIR.defaultBlockState(),
                                    3
                            );

                            template.get().placeInWorld(
                                    level,
                                    pos,
                                    pos,
                                    new StructurePlaceSettings(),
                                    level.random,
                                    2
                            );
                        }

                        return;
                    }
                }
            }
        }
    }
}