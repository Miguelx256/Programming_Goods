package net.miguelx46.programminggoods.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class JavaCompilerMenu extends AbstractContainerMenu {

    private final ItemStackHandler inventory;

    public JavaCompilerMenu(int id,
                            Inventory playerInventory,
                            FriendlyByteBuf buffer) {

        this(id, playerInventory, new ItemStackHandler(10));
    }

    public JavaCompilerMenu(int id,
                            Inventory playerInventory,
                            ItemStackHandler inventory) {

        super(ModMenuTypes.JAVA_COMPILER_MENU.get(), id);

        this.inventory = inventory;

        // CRAFTING 3x3
        int slot = 0;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                this.addSlot(new SlotItemHandler(
                        inventory,
                        slot++,
                        30 + col * 18,
                        17 + row * 18
                ));
            }
        }

        // OUTPUT
        this.addSlot(new JavaCompilerResultSlot(
                inventory,
                9,
                124,
                35
        ));

        // INVENTARIO DEL JUGADOR
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {

                this.addSlot(new Slot(
                        playerInventory,
                        col + row * 9 + 9,
                        8 + col * 18,
                        84 + row * 18
                ));
            }
        }

        // HOTBAR
        for (int col = 0; col < 9; col++) {

            this.addSlot(new Slot(
                    playerInventory,
                    col,
                    8 + col * 18,
                    142
            ));
        }
    }

    public ItemStackHandler getInventory() {
        return inventory;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {

        Slot sourceSlot = this.slots.get(index);

        if (!sourceSlot.hasItem()) {
            return ItemStack.EMPTY;
        }

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Slot de resultado
        if (index == 9) {

            if (!this.moveItemStackTo(
                    sourceStack,
                    10,
                    46,
                    true)) {

                return ItemStack.EMPTY;
            }

            sourceSlot.onQuickCraft(
                    sourceStack,
                    copyOfSourceStack);
        }

        // Inventario del compilador
        else if (index >= 0 && index <= 9) {

            if (!this.moveItemStackTo(
                    sourceStack,
                    10,
                    46,
                    false)) {

                return ItemStack.EMPTY;
            }
        }

        // Inventario del jugador
        else {

            if (!this.moveItemStackTo(
                    sourceStack,
                    0,
                    9,
                    false)) {

                return ItemStack.EMPTY;
            }
        }

        if (sourceStack.isEmpty()) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }

        sourceSlot.onTake(player, sourceStack);

        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}