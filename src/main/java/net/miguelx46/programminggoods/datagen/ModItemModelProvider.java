package net.miguelx46.programminggoods.datagen;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, ProgrammingGoods.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.JAVA_COFFEE);
        simpleItem(ModItems.JAVA_JUICE);
        simpleItem(ModItems.JAVA_OBJECT);
        simpleItem(ModItems.ARRAY_FUEL);
        simpleItem(ModItems.JAVA_APPLE);
        simpleItem(ModItems.JAVA_HELMET);
        simpleItem(ModItems.JAVA_CHESTPLATE);
        simpleItem(ModItems.JAVA_LEGGINGS);
        simpleItem(ModItems.JAVA_BOOTS);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
         return withExistingParent(item.getId().getPath(),
                 new ResourceLocation("item/generated")).texture("layer0",
                 new ResourceLocation(ProgrammingGoods.MOD_ID, "item/" + item.getId().getPath()));
    }
}
