package net.miguelx46.programminggoods.entity;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.entity.custom.JavaGolemEntity;
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

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}