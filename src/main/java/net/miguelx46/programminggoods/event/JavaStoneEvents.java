package net.miguelx46.programminggoods.event;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;

@Mod.EventBusSubscriber(modid = ProgrammingGoods.MOD_ID)
public class JavaStoneEvents {

    @SubscribeEvent
    public static void onBreak(BlockEvent.BreakEvent event) {

        if (!(event.getLevel() instanceof ServerLevel level)) {
            return;
        }

        if (!level.getBlockState(event.getPos())
                .is(ModBlocks.JAVA_STONE.get())) {
            return;
        }

        Optional<StructureTemplate> template =
                level.getStructureManager().get(
                        ResourceLocation.fromNamespaceAndPath(
                                ProgrammingGoods.MOD_ID,
                                "java_lab"
                        )
                );

        if (template.isEmpty()) {
            System.out.println("java_lab.nbt no encontrado");
            return;
        }

        System.out.println("JAVA STONE ROTA - GENERANDO LAB");

        template.get().placeInWorld(
                level,
                event.getPos(),
                event.getPos(),
                new StructurePlaceSettings(),
                level.random,
                2
        );
    }
}