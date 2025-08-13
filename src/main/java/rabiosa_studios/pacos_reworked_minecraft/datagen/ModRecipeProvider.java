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

                // region COPPER
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.COPPER_NUGGET, RecipeCategory.MISC, Items.COPPER_INGOT);

                List<ItemConvertible> copper_items = List.of(ModItems.COPPER_SWORD, ModItems.COPPER_AXE, ModItems.COPPER_PICKAXE, ModItems.COPPER_SHOVEL, ModItems.COPPER_HOE, ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS);
                offerSmelting(copper_items, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.1f, 200, "copper_nugget_from_smelting");
                offerBlasting(copper_items, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.1f, 100, "copper_nugget_from_blasting");
                // endregion

                // region FOODS
                createShaped(RecipeCategory.FOOD, ModItems.MELON_JAM)
                        .pattern("ibi")
                        .pattern("sis")
                        .input('b', Items.GLASS_BOTTLE)
                        .input('s', Items.SUGAR)
                        .input('i', Items.MELON_SLICE)
                        .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                        .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                        .criterion(hasItem(Items.MELON_SLICE), conditionsFromItem(Items.MELON_SLICE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.FOOD, ModItems.SWEET_BERRIES_JAM)
                        .pattern("ibi")
                        .pattern("sis")
                        .input('b', Items.GLASS_BOTTLE)
                        .input('s', Items.SUGAR)
                        .input('i', Items.SWEET_BERRIES)
                        .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                        .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                        .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                        .offerTo(exporter);

                createShaped(RecipeCategory.FOOD, ModItems.GLOW_BERRIES_JAM)
                        .pattern("ibi")
                        .pattern("sis")
                        .input('b', Items.GLASS_BOTTLE)
                        .input('s', Items.SUGAR)
                        .input('i', Items.GLOW_BERRIES)
                        .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                        .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                        .criterion(hasItem(Items.GLOW_BERRIES), conditionsFromItem(Items.GLOW_BERRIES))
                        .offerTo(exporter);

                // endregion
            }
        };
    }

    @Override
    public String getName() {
        return "PacosReworkedMinecraftRecipeProvider";
    }
}
