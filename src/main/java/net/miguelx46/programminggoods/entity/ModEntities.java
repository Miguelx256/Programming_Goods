package net.miguelx46.programminggoods.entity;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.entity.custom.JavaGolemEntity;
import net.miguelx46.programminggoods.entity.custom.JavaSkeletonEntity;
import net.miguelx46.programminggoods.entity.custom.JavaZombieEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(
                    ForgeRegistries.ENTITY_TYPES,
                    ProgrammingGoods.MOD_ID);

    public static final RegistryObject<EntityType<JavaGolemEntity>>
            JAVA_GOLEM =

            ENTITIES.register(
                    "java_golem",

                    () -> EntityType.Builder
                            .of(
                                    JavaGolemEntity::new,
                                    MobCategory.CREATURE
                            )
                            .sized(1.4F, 2.7F)
                            .build("java_golem"));

    public static final RegistryObject<EntityType<JavaZombieEntity>>
            JAVA_ZOMBIE =

            ENTITIES.register(
                    "java_zombie",

                    () -> EntityType.Builder
                            .of(
                                    JavaZombieEntity::new,
                                    MobCategory.MONSTER
                            )
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8)
                            .setUpdateInterval(3)
                            .build("java_zombie"));

    public static final RegistryObject<EntityType<JavaSkeletonEntity>>
            JAVA_SKELETON =

            ENTITIES.register(
                    "java_skeleton",

                    () -> EntityType.Builder
                            .of(
                                    JavaSkeletonEntity::new,
                                    MobCategory.MONSTER
                            )
                            .sized(0.6F, 1.99F)
                            .build("java_skeleton"));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}