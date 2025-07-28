package net.miguelx46.programminggoods.item;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier JAVA = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_JAVA_TOOL, () -> Ingredient.of(ModItems.JAVA_COFFEE.get())),
            new ResourceLocation(ProgrammingGoods.MOD_ID, "sapphire"), List.of(Tiers.NETHERITE), List.of());
}
