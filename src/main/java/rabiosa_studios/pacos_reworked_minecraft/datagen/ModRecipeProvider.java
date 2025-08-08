package rabiosa_studios.pacos_reworked_minecraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import rabiosa_studios.pacos_reworked_minecraft.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                //RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);


                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.COPPER_NUGGET, RecipeCategory.MISC, Items.COPPER_INGOT);

                List<ItemConvertible> copper_items = List.of(ModItems.COPPER_SWORD, ModItems.COPPER_AXE, ModItems.COPPER_PICKAXE, ModItems.COPPER_SHOVEL, ModItems.COPPER_HOE, ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS);
                offerSmelting(copper_items, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.1f, 200, "copper_nugget_from_smelting");
                offerBlasting(copper_items, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.1f, 100, "copper_nugget_from_blasting");
            }
        };
    }

    @Override
    public String getName() {
        return "PacosReworkedMinecraftRecipeProvider";
    }
}
