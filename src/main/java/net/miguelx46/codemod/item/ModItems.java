package net.miguelx46.codemod.item;

import net.miguelx46.codemod.CodeMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // lista de items del mod para registrar
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CodeMod.MOD_ID);

    // objetos de tipo item que son registrados a la lista de items
    public static final RegistryObject<Item> JAVA_COFFEE = ITEMS.register("java_coffee", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JAVA_JUICE = ITEMS.register("java_juice", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> JAVA_OBJECT = ITEMS.register("java_object", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JAVA_HELMET = ITEMS.register("java_helmet", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JAVA_CHESTPLATE = ITEMS.register("java_chestplate", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JAVA_LEGGINGS = ITEMS.register("java_leggings", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JAVA_BOOTS = ITEMS.register("java_boots", () -> new Item(new Item.Properties().stacksTo(1)));

    // registrar los items dado un bus de eventos
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
