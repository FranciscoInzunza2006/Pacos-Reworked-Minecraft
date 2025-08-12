package rabiosa_studios.pacos_reworked_minecraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import rabiosa_studios.pacos_reworked_minecraft.PacosReworkedMinecraft;
import rabiosa_studios.pacos_reworked_minecraft.item.ModItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }


    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry stone_pickaxe_advancement = new AdvancementEntry(Identifier.ofVanilla("story/upgrade_tools"), null);
        AdvancementEntry copper_ingot_advancement = Advancement.Builder.create()
                .parent(stone_pickaxe_advancement)
                .display(
                        Items.COPPER_INGOT,
                        Text.translatable("advancements.pacos-reworked-minecraft.smelt_copper.title"),
                        Text.translatable("advancements.pacos-reworked-minecraft.smelt_copper.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_copper_ingot", InventoryChangedCriterion.Conditions.items(Items.COPPER_INGOT))
                .build(consumer, PacosReworkedMinecraft.MOD_ID + ":story/get_copper_ingot");

        AdvancementEntry copper_pickaxe_advancement = Advancement.Builder.create()
                .parent(copper_ingot_advancement)
                .display(
                        ModItems.COPPER_PICKAXE,
                        Text.translatable("advancements.pacos-reworked-minecraft.copper_tools.title"),
                        Text.translatable("advancements.pacos-reworked-minecraft.copper_tools.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_copper_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.COPPER_PICKAXE))
                .build(consumer, PacosReworkedMinecraft.MOD_ID + ":story/get_copper_pickaxe");
    }
}
