package net.miguelx46.codemod.item;

import net.miguelx46.codemod.CodeMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // lista generica para registrar los items del mod
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CodeMod.MOD_ID);
    // objeto para registrar un objeto de tipo item
    public static final RegistryObject<Item> JAVA_COFFEE = ITEMS.register("java_coffee", () -> new Item(new Item.Properties()));

    // registrar los items dado un bus de eventos
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
