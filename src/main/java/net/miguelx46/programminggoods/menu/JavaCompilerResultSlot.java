package net.miguelx46.programminggoods.menu;

import net.miguelx46.programminggoods.block.entity.JavaCompilerBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
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

        consumeIngredients();

        super.onTake(player, stack);
    }

    private void consumeIngredients() {

        for (int i = 0; i < 9; i++) {

            ItemStack ingredient =
                    inventory.getStackInSlot(i);

            if (!ingredient.isEmpty()) {

                ingredient.shrink(1);

                inventory.setStackInSlot(i, ingredient);
            }
        }
    }
}