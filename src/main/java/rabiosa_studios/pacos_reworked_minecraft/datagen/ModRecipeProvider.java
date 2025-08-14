package rabiosa_studios.pacos_reworked_minecraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
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
            public void offerJamRecipe(ItemConvertible jam, ItemConvertible ingredient, RecipeExporter exporter) {
                createShaped(RecipeCategory.FOOD, jam)
                        .pattern("XBX")
                        .pattern("#X#")
                        .input('B', Items.GLASS_BOTTLE)
                        .input('#', Items.SUGAR)
                        .input('X', ingredient)
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .offerTo(exporter);
            }

            public void offerAmethystUpgradeRecipe(Item input, RecipeCategory category, Item result) {
                SmithingTransformRecipeJsonBuilder.create(
                                Ingredient.ofItem(ModItems.AMETHYST_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.ofItem(input),
                                Ingredient.ofItem(Items.AMETHYST_SHARD),
                                category,
                                result
                        )
                        .criterion(hasItem(Items.AMETHYST_SHARD), this.conditionsFromItem(Items.AMETHYST_SHARD))
                        .offerTo(this.exporter, getItemPath(result) + "_smithing");
            }

            @Override
            public void generate() {
                //RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                // region COPPER
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.COPPER_NUGGET, RecipeCategory.MISC, Items.COPPER_INGOT);

                List<ItemConvertible> copper_items = List.of(ModItems.COPPER_SWORD, ModItems.COPPER_AXE, ModItems.COPPER_PICKAXE, ModItems.COPPER_SHOVEL, ModItems.COPPER_HOE, ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS);
                offerSmelting(copper_items, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.1f, 200, "copper_nugget_from_smelting");
                offerBlasting(copper_items, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.1f, 100, "copper_nugget_from_blasting");
                // endregion

                // region REINFORCED GOLD
                createShaped(RecipeCategory.MISC, ModItems.AMETHYST_UPGRADE_SMITHING_TEMPLATE)
                        .input('#', Items.GOLD_INGOT)
                        .input('C', Items.AMETHYST_SHARD)
                        .input('S', Items.COBBLED_DEEPSLATE)
                        .pattern("#S#")
                        .pattern("#C#")
                        .pattern("###")
                        .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                        .offerTo(exporter);

                offerAmethystUpgradeRecipe(Items.GOLDEN_SWORD,RecipeCategory.COMBAT, ModItems.REINFORCED_GOLDEN_SWORD);
                offerAmethystUpgradeRecipe(Items.GOLDEN_PICKAXE,RecipeCategory.TOOLS, ModItems.REINFORCED_GOLDEN_PICKAXE);
                offerAmethystUpgradeRecipe(Items.GOLDEN_AXE,RecipeCategory.TOOLS, ModItems.REINFORCED_GOLDEN_AXE);
                offerAmethystUpgradeRecipe(Items.GOLDEN_SHOVEL,RecipeCategory.TOOLS, ModItems.REINFORCED_GOLDEN_SHOVEL);
                offerAmethystUpgradeRecipe(Items.GOLDEN_HOE,RecipeCategory.TOOLS, ModItems.REINFORCED_GOLDEN_HOE);

                List<ItemConvertible> reinforced_golden_items = List.of(ModItems.REINFORCED_GOLDEN_SWORD, ModItems.REINFORCED_GOLDEN_PICKAXE, ModItems.REINFORCED_GOLDEN_AXE, ModItems.REINFORCED_GOLDEN_HOE, ModItems.REINFORCED_GOLDEN_SHOVEL);
                offerSmelting(reinforced_golden_items, RecipeCategory.MISC, Items.GOLD_INGOT, 0.1f, 200, "gold_ingot_from_smelting");
                offerBlasting(reinforced_golden_items, RecipeCategory.MISC, Items.GOLD_INGOT, 0.1f, 100, "gold_ingot_from_blasting");
                // endregion

                // region FOODS
                offerJamRecipe(ModItems.MELON_JAM, Items.MELON_SLICE, exporter);
                offerJamRecipe(ModItems.SWEET_BERRIES_JAM, Items.SWEET_BERRIES, exporter);
                offerJamRecipe(ModItems.GLOW_BERRIES_JAM, Items.GLOW_BERRIES, exporter);
                // endregion
            }
        };
    }

    @Override
    public String getName() {
        return "PacosReworkedMinecraftRecipeProvider";
    }
}
