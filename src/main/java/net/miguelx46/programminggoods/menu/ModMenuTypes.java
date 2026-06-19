package net.miguelx46.programminggoods.menu;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(
                    ForgeRegistries.MENU_TYPES,
                    ProgrammingGoods.MOD_ID);

    public static final RegistryObject<MenuType<JavaCompilerMenu>>
            JAVA_COMPILER_MENU =
            MENUS.register("java_compiler_menu",
                    () -> IForgeMenuType.create(JavaCompilerMenu::new));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}