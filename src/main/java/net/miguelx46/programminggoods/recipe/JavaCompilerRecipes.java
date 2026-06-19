package net.miguelx46.programminggoods.recipe;

import net.miguelx46.programminggoods.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraft.world.item.Items;

public class JavaCompilerRecipes {

    public static ItemStack getResult(ItemStackHandler inventory) {

        if (isJavaNodeRecipe(inventory)) {
            return new ItemStack(ModItems.JAVA_NODE.get());
        }

        if (isJavaArrayListRecipe(inventory)) {
            return new ItemStack(ModItems.JAVA_ARRAYLIST.get());
        }

        if (isJavaHashMapRecipe(inventory)) {
            return new ItemStack(ModItems.JAVA_HASHMAP.get());
        }

        if (isJavaStackRecipe(inventory)) {
            return new ItemStack(ModItems.JAVA_STACK.get());
        }

        if (isJavaBinaryTreeRecipe(inventory)) {
            return new ItemStack(ModItems.JAVA_BINARYTREE.get());
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

    private static boolean isJavaArrayListRecipe(ItemStackHandler inventory) {

        return

                inventory.getStackInSlot(0).is(Items.GOLD_INGOT) &&

                        inventory.getStackInSlot(1).is(Items.GOLD_INGOT) &&

                        inventory.getStackInSlot(2).is(Items.GOLD_INGOT) &&

                        inventory.getStackInSlot(3).is(ModItems.JAVA_NODE.get()) &&

                        inventory.getStackInSlot(4).is(ModItems.JAVA_NODE.get()) &&

                        inventory.getStackInSlot(5).is(ModItems.JAVA_NODE.get()) &&

                        inventory.getStackInSlot(6).is(Items.GOLD_INGOT) &&

                        inventory.getStackInSlot(7).is(Items.GOLD_INGOT) &&

                        inventory.getStackInSlot(8).is(Items.GOLD_INGOT);
    }

    private static boolean isJavaHashMapRecipe(ItemStackHandler inventory) {

        return

                inventory.getStackInSlot(0).is(Items.DIAMOND) &&

                        inventory.getStackInSlot(1).is(Items.DIAMOND) &&

                        inventory.getStackInSlot(2).is(Items.DIAMOND) &&

                        inventory.getStackInSlot(3).is(ModItems.JAVA_NODE.get()) &&

                        inventory.getStackInSlot(4).is(ModItems.JAVA_NODE.get()) &&

                        inventory.getStackInSlot(5).is(ModItems.JAVA_NODE.get()) &&

                        inventory.getStackInSlot(6).is(Items.DIAMOND) &&

                        inventory.getStackInSlot(7).is(Items.DIAMOND) &&

                        inventory.getStackInSlot(8).is(Items.DIAMOND);
    }

    private static boolean isJavaStackRecipe(ItemStackHandler inventory) {

        return

                inventory.getStackInSlot(0).is(Items.LAPIS_LAZULI) &&

                        inventory.getStackInSlot(1).is(Items.LAPIS_LAZULI) &&

                        inventory.getStackInSlot(2).is(Items.LAPIS_LAZULI) &&

                        inventory.getStackInSlot(3).is(ModItems.JAVA_NODE.get()) &&

                        inventory.getStackInSlot(4).is(ModItems.JAVA_NODE.get()) &&

                        inventory.getStackInSlot(5).is(ModItems.JAVA_NODE.get()) &&

                        inventory.getStackInSlot(6).is(Items.LAPIS_LAZULI) &&

                        inventory.getStackInSlot(7).is(Items.LAPIS_LAZULI) &&

                        inventory.getStackInSlot(8).is(Items.LAPIS_LAZULI);
    }

    private static boolean isJavaBinaryTreeRecipe(ItemStackHandler inventory) {

        return

                inventory.getStackInSlot(0).is(Items.EMERALD) &&

                        inventory.getStackInSlot(1).is(Items.EMERALD) &&

                        inventory.getStackInSlot(2).is(Items.EMERALD) &&

                        inventory.getStackInSlot(3).is(ModItems.JAVA_NODE.get()) &&

                        inventory.getStackInSlot(4).is(ModItems.JAVA_NODE.get()) &&

                        inventory.getStackInSlot(5).is(ModItems.JAVA_NODE.get()) &&

                        inventory.getStackInSlot(6).is(Items.EMERALD) &&

                        inventory.getStackInSlot(7).is(Items.EMERALD) &&

                        inventory.getStackInSlot(8).is(Items.EMERALD);
    }

}