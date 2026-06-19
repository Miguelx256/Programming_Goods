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

        this(id, playerInventory, new ItemStackHandler(4));
    }

    public JavaCompilerMenu(int id,
                            Inventory playerInventory,
                            ItemStackHandler inventory) {

        super(ModMenuTypes.JAVA_COMPILER_MENU.get(), id);

        this.inventory = inventory;

        // INPUT 1
        this.addSlot(new SlotItemHandler(
                inventory,
                0,
                44,
                35));

        // INPUT 2
        this.addSlot(new SlotItemHandler(
                inventory,
                1,
                62,
                35));

        // INPUT 3
        this.addSlot(new SlotItemHandler(
                inventory,
                2,
                80,
                35));

        // OUTPUT
        this.addSlot(new SlotItemHandler(
                inventory,
                3,
                134,
                35));

        // Inventario principal
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

        // Hotbar
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
    public ItemStack quickMoveStack(Player player, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}