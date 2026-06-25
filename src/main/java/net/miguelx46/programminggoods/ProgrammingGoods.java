package net.miguelx46.programminggoods;

import com.mojang.logging.LogUtils;
import net.miguelx46.programminggoods.block.ModBlocks;
import net.miguelx46.programminggoods.block.entity.ModBlockEntities;
import net.miguelx46.programminggoods.client.renderer.JavaGolemRenderer;
import net.miguelx46.programminggoods.client.screen.JavaCompilerScreen;
import net.miguelx46.programminggoods.command.ModCommands;
import net.miguelx46.programminggoods.entity.ModEntities;
import net.miguelx46.programminggoods.event.JavaLabReplacer;
import net.miguelx46.programminggoods.event.VillageJavaGolemSpawner;
import net.miguelx46.programminggoods.item.ModCreativeModTabs;
import net.miguelx46.programminggoods.item.ModItems;
import net.miguelx46.programminggoods.menu.ModMenuTypes;
import net.miguelx46.programminggoods.world.ModBiomeModifiers;
import net.miguelx46.programminggoods.world.ModFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ProgrammingGoods.MOD_ID)
public class ProgrammingGoods {

    public static final String MOD_ID = "programminggoods";

    private static final Logger LOGGER = LogUtils.getLogger();

    public ProgrammingGoods() {

        IEventBus modEventBus =
                FMLJavaModLoadingContext.get()
                        .getModEventBus();

        ModCreativeModTabs.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModEntities.register(modEventBus);
        ModFeatures.FEATURES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        MinecraftForge.EVENT_BUS.register(
                new VillageJavaGolemSpawner()
        );

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

    @SubscribeEvent
    public void registerCommands(
            RegisterCommandsEvent event) {

        ModCommands.register(
                event.getDispatcher());
    }

    @Mod.EventBusSubscriber(
            modid = MOD_ID,
            bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {

        @SubscribeEvent
        public static void registerAttributes(
                EntityAttributeCreationEvent event) {

            event.put(
                    ModEntities.JAVA_GOLEM.get(),

                    IronGolem.createAttributes()

                            .add(Attributes.MAX_HEALTH, 300.0D)
                            .add(Attributes.ATTACK_DAMAGE, 25.0D)
                            .add(Attributes.MOVEMENT_SPEED, 0.60D)
                            .build()
            );
        }
    }

    @Mod.EventBusSubscriber(
            modid = MOD_ID,
            bus = Mod.EventBusSubscriber.Bus.MOD,
            value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            event.enqueueWork(() -> {

                MenuScreens.register(
                        ModMenuTypes.JAVA_COMPILER_MENU.get(),
                        JavaCompilerScreen::new);
            });
        }

        @SubscribeEvent
        public static void registerRenderers(
                EntityRenderersEvent.RegisterRenderers event) {

            event.registerEntityRenderer(
                    ModEntities.JAVA_GOLEM.get(),
                    JavaGolemRenderer::new
            );
        }
    }
}
