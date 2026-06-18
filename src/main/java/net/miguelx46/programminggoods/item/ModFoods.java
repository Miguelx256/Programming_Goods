package net.miguelx46.programminggoods.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    // items de comidas
    public static final FoodProperties JAVA_JUICE = new FoodProperties.Builder().nutrition(9)
            .saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 4000, 2), 10f).build();

    public static final FoodProperties JAVA_APPLE = new FoodProperties.Builder().nutrition(7)
            .saturationMod(0.4f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 4300, 2), 10f).build();

    public static final FoodProperties JAVA_ARRAYLIST = new FoodProperties.Builder().nutrition(8)
            .saturationMod(0.4f).effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 5500, 3), 10f).build();

    public static final FoodProperties JAVA_HASHMAP = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 750, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 750, 4), 1.0f)
            .build();

    public static final FoodProperties JAVA_STACK = new FoodProperties.Builder()
            .nutrition(7)
            .saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 3000, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 3000, 3), 1.0f)
            .build();

    public static final FoodProperties JAVA_BINARYTREE = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 3500, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 3500, 2), 1.0f)
            .build();

}
