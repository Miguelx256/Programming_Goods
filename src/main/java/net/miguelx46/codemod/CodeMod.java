package net.miguelx46.codemod;

import com.mojang.logging.LogUtils;
import net.miguelx46.codemod.block.ModBlocks;
import net.miguelx46.codemod.item.ModCreativeModTabs;
import net.miguelx46.codemod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CodeMod.MOD_ID)
public class CodeMod {

    public static final String MOD_ID = "codemod";

    private static final Logger LOGGER = LogUtils.getLogger();

    public CodeMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeModTabs.register(modEventBus); //llamada al metodo register y se le pasa un bus de eventos
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // añade los items del mod a la lista de items vanilla del creativo
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // se añaden al tab ingredientes
         if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
              event.accept(ModItems.JAVA_COFFEE);
              event.accept(ModItems.JAVA_JUICE);
              event.accept(ModItems.JAVA_OBJECT);
         }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
