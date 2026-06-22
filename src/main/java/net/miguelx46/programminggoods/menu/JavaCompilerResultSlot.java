package net.miguelx46.programminggoods.menu;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class JavaCompilerResultSlot extends SlotItemHandler {

    private final ItemStackHandler inventory;

    public JavaCompilerResultSlot(ItemStackHandler inventory,
                                  int index,
                                  int xPosition,
                                  int yPosition) {

        super(inventory, index, xPosition, yPosition);

        this.inventory = inventory;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return false;
    }

    @Override
    public void onTake(Player player, ItemStack stack) {

        if (!stack.isEmpty()) {

            player.displayClientMessage(
                    Component.literal(
                            "[Java Compiler] Successfully compiled: "
                                    + stack.getHoverName().getString()
                    ).withStyle(ChatFormatting.GOLD),
                    true
            );
        }

        consumeIngredients();

        super.onTake(player, stack);
    }

    private void consumeIngredients() {

        for (int i = 0; i < 9; i++) {

            ItemStack ingredient =
                    inventory.getStackInSlot(i);

            if (!ingredient.isEmpty()) {

                ingredient.shrink(1);

                if (ingredient.getCount() <= 0) {
                    inventory.setStackInSlot(i, ItemStack.EMPTY);
                } else {
                    inventory.setStackInSlot(i, ingredient);
                }
            }
        }
    }
}