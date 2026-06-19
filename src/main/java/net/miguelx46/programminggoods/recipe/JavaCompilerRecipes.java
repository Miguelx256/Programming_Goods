package net.miguelx46.programminggoods.recipe;

import net.miguelx46.programminggoods.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.items.ItemStackHandler;

public class JavaCompilerRecipes {

    public static ItemStack getResult(ItemStackHandler inventory) {

        if (isJavaNodeRecipe(inventory)) {
            return new ItemStack(ModItems.JAVA_NODE.get());
        }

        return ItemStack.EMPTY;
    }

    private static boolean isJavaNodeRecipe(ItemStackHandler inventory) {

        return

                inventory.getStackInSlot(0).isEmpty() &&

                        inventory.getStackInSlot(1).is(Items.IRON_INGOT) &&

                        inventory.getStackInSlot(2).isEmpty() &&

                        inventory.getStackInSlot(3).is(Items.IRON_INGOT) &&

                        inventory.getStackInSlot(4).is(ModItems.JAVA_COFFEE.get()) &&

                        inventory.getStackInSlot(5).is(Items.IRON_INGOT) &&

                        inventory.getStackInSlot(6).isEmpty() &&

                        inventory.getStackInSlot(7).is(Items.IRON_INGOT) &&

                        inventory.getStackInSlot(8).isEmpty();
    }
}