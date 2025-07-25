package net.miguelx46.codemod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    // comidas
    public static final FoodProperties JAVA_JUICE = new FoodProperties.Builder().nutrition(9)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10500), 10f).build();
}
