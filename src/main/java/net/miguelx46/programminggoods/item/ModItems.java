package net.miguelx46.programminggoods.item;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.block.custom.FuelItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // lista de items del mod para registrar
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProgrammingGoods.MOD_ID);

    // objetos de tipo item que son registrados a la lista de items
    public static final RegistryObject<Item> JAVA_COFFEE = ITEMS.register("java_coffee", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JAVA_JUICE = ITEMS.register("java_juice", () -> new Item(new Item.Properties().food(ModFoods.JAVA_JUICE).stacksTo(16)));

    public static final RegistryObject<Item> JAVA_OBJECT = ITEMS.register("java_object", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JAVA_HELMET = ITEMS.register("java_helmet", () -> new ArmorItem(ModArmorMaterials.JAVA, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> JAVA_CHESTPLATE = ITEMS.register("java_chestplate", () -> new ArmorItem(ModArmorMaterials.JAVA, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> JAVA_LEGGINGS = ITEMS.register("java_leggings", () -> new ArmorItem(ModArmorMaterials.JAVA, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> JAVA_BOOTS = ITEMS.register("java_boots", () -> new ArmorItem(ModArmorMaterials.JAVA, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> JAVA_APPLE = ITEMS.register("java_apple", () -> new Item(new Item.Properties().food(ModFoods.JAVA_APPLE).stacksTo(64)));

    public static final RegistryObject<Item> ARRAY_FUEL = ITEMS.register("array_fuel", () -> new FuelItem(new Item.Properties().stacksTo(64), 2500));

    public static final RegistryObject<Item> JAVA_SWORD = ITEMS.register("java_sword",
            () -> new SwordItem(ModToolTiers.JAVA, 9, 3, new Item.Properties().stacksTo(1).durability(3000)));

    public static final RegistryObject<Item> JAVA_PICKAXE = ITEMS.register("java_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JAVA, 1, 1, new Item.Properties().stacksTo(1).durability(3000)));

    public static final RegistryObject<Item> JAVA_AXE = ITEMS.register("java_axe",
            () -> new AxeItem(ModToolTiers.JAVA, 7, 1, new Item.Properties().stacksTo(1).durability(3000)));

    public static final RegistryObject<Item> JAVA_SHOVEL = ITEMS.register("java_shovel",
            () -> new ShovelItem(ModToolTiers.JAVA, 0, 0, new Item.Properties().stacksTo(1).durability(3000)));

    public static final RegistryObject<Item> JAVA_HOE = ITEMS.register("java_hoe",
            () -> new HoeItem(ModToolTiers.JAVA, 0, 0, new Item.Properties().stacksTo(1).durability(3000)));

    // registrar los items dado un bus de eventos
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
