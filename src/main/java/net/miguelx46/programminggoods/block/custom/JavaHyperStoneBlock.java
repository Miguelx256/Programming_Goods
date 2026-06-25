package net.miguelx46.programminggoods.block.custom;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.entity.custom.JavaGolemEntity;
import net.miguelx46.programminggoods.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.Optional;

public class JavaHyperStoneBlock extends Block {

    public JavaHyperStoneBlock(Properties properties) {
        super(properties);
    }

    /**
     * Solo el pico de Netherite o el pico Java pueden romper este bloque.
     */
    @Override
    public float getDestroyProgress(
            BlockState state,
            Player player,
            BlockGetter level,
            BlockPos pos) {

        ItemStack tool = player.getMainHandItem();

        if (tool.is(Items.NETHERITE_PICKAXE)
                || tool.is(ModItems.JAVA_PICKAXE.get())) {

            return super.getDestroyProgress(
                    state,
                    player,
                    level,
                    pos
            );
        }

        // Imposible de romper con otra herramienta
        return 0.0F;
    }

    @Override
    public void playerWillDestroy(
            Level level,
            BlockPos pos,
            BlockState state,
            Player player) {

        if (!(level instanceof ServerLevel serverLevel)) {
            super.playerWillDestroy(level, pos, state, player);
            return;
        }

        ItemStack tool = player.getMainHandItem();

        if (!tool.is(Items.NETHERITE_PICKAXE)
                && !tool.is(ModItems.JAVA_PICKAXE.get())) {

            super.playerWillDestroy(level, pos, state, player);
            return;
        }

        Optional<StructureTemplate> template =
                serverLevel.getStructureManager().get(
                        ResourceLocation.fromNamespaceAndPath(
                                ProgrammingGoods.MOD_ID,
                                "java_lab"
                        )
                );

        if (template.isPresent()) {

            System.out.println("JAVA HYPER STONE ACTIVADA");

            BlockPos labPos = pos.above();

            template.get().placeInWorld(
                    serverLevel,
                    labPos,
                    labPos,
                    new StructurePlaceSettings(),
                    serverLevel.random,
                    2
            );

// Buscar los Java Golem del laboratorio y marcarlos como guardianes
            AABB area = new AABB(labPos).inflate(40);

            for (JavaGolemEntity golem :
                    serverLevel.getEntitiesOfClass(
                            JavaGolemEntity.class,
                            area)) {

                golem.setGuardian(true);

                System.out.println("JAVA GOLEM MARCADO COMO GUARDIAN");
            }
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void animateTick(
            BlockState state,
            Level level,
            BlockPos pos,
            RandomSource random) {

        super.animateTick(state, level, pos, random);

        if (random.nextInt(6) != 0)
            return;

        double x = pos.getX() + 0.2 + random.nextDouble() * 0.6;
        double y = pos.getY() + 0.2 + random.nextDouble() * 0.6;
        double z = pos.getZ() + 0.2 + random.nextDouble() * 0.6;

        level.addParticle(
                ParticleTypes.ENCHANT,
                x,
                y,
                z,
                0.0,
                0.02,
                0.0
        );
    }
}