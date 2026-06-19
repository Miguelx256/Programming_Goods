package net.miguelx46.programminggoods.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class JavaCompilerMenu extends AbstractContainerMenu {

    public JavaCompilerMenu(int id,
                            Inventory inventory,
                            FriendlyByteBuf buffer) {

        super(ModMenuTypes.JAVA_COMPILER_MENU.get(), id);
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