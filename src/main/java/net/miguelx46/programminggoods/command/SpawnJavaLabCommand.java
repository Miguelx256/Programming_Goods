package net.miguelx46.programminggoods.command;

import com.mojang.brigadier.CommandDispatcher;
import net.miguelx46.programminggoods.ProgrammingGoods;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class SpawnJavaLabCommand {

    public static void register(
            CommandDispatcher<CommandSourceStack> dispatcher) {

        dispatcher.register(
                Commands.literal("spawnjavalab")
                        .requires(source -> source.hasPermission(2))
                        .executes(context -> {

                            ServerLevel level =
                                    context.getSource().getLevel();

                            BlockPos pos =
                                    BlockPos.containing(
                                            context.getSource().getPosition()
                                    );

                            StructureTemplate template =
                                    level.getStructureManager()
                                            .getOrCreate(
                                                    ResourceLocation.fromNamespaceAndPath(
                                                            ProgrammingGoods.MOD_ID,
                                                            "java_lab"
                                                    )
                                            );

                            template.placeInWorld(
                                    level,
                                    pos,
                                    pos,
                                    new StructurePlaceSettings(),
                                    level.random,
                                    2
                            );

                            return 1;
                        })
        );
    }
}