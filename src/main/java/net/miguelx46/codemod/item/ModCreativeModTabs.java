package net.miguelx46.codemod.item;

import net.miguelx46.codemod.CodeMod;
import net.miguelx46.codemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    // lista para registrar tabs para el modo creativo
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CodeMod.MOD_ID);

    // en el json dentro de lang van a estar puestos los nombres de los items que se veran dentro del juego
    public static final RegistryObject<CreativeModeTab> CODEMOD_TAB = CREATIVE_MODE_TAB.register("codemod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.JAVA_COFFEE.get()))
                    .title(Component.translatable("creativetab.codemod_tab"))
                    .displayItems((pParameters, pOutput) -> { // aqui se van poniendo los items del mod
                        pOutput.accept(ModItems.JAVA_COFFEE.get());
                        pOutput.accept(ModItems.JAVA_JUICE.get());
                        pOutput.accept(ModItems.JAVA_OBJECT.get());
                        pOutput.accept(ModItems.JAVA_HELMET.get());
                        pOutput.accept(ModItems.JAVA_CHESTPLATE.get());
                        pOutput.accept(ModItems.JAVA_LEGGINGS.get());
                        pOutput.accept(ModItems.JAVA_BOOTS.get());

                        pOutput.accept(ModBlocks.JAVA_OBJECT_ORE.get());
                        pOutput.accept(ModBlocks.JAVA_COFFEE_BLOCK.get());
                        //pOutput.accept(ModBlocks.CODE_FURNACE.get()); arreglar
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
