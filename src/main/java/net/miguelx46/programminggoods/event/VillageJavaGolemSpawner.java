package net.miguelx46.programminggoods.event;

import net.miguelx46.programminggoods.entity.ModEntities;
import net.miguelx46.programminggoods.entity.custom.JavaGolemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class VillageJavaGolemSpawner {

    private static final List<Runnable> PENDING_SPAWNS =
            new ArrayList<>();

    @SubscribeEvent
    public void onEntityJoinLevel(
            EntityJoinLevelEvent event) {

        if (!(event.getLevel() instanceof ServerLevel level)) {
            return;
        }

        if (!(event.getEntity() instanceof IronGolem ironGolem)) {
            return;
        }

        if (ironGolem instanceof JavaGolemEntity) {
            return;
        }

        System.out.println("VANILLA IRON GOLEM DETECTED");

        PENDING_SPAWNS.add(() -> {

            JavaGolemEntity javaGolem =
                    ModEntities.JAVA_GOLEM.get()
                            .create(level);

            if (javaGolem == null) {
                return;
            }

            javaGolem.moveTo(
                    ironGolem.getX() + 1,
                    ironGolem.getY(),
                    ironGolem.getZ() + 1,
                    0,
                    0
            );

            level.addFreshEntity(javaGolem);

            System.out.println(
                    "JAVA GOLEM SPAWNED"
            );
        });
    }

    @SubscribeEvent
    public void onLevelTick(
            TickEvent.LevelTickEvent event) {

        if (event.level.isClientSide()) {
            return;
        }

        if (PENDING_SPAWNS.isEmpty()) {
            return;
        }

        List<Runnable> copy =
                new ArrayList<>(PENDING_SPAWNS);

        PENDING_SPAWNS.clear();

        copy.forEach(Runnable::run);
    }
}