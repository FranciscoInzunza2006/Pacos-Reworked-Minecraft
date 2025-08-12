package rabiosa_studios.pacos_reworked_minecraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import rabiosa_studios.pacos_reworked_minecraft.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.COPPER_SWORD);

        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.COPPER_PICKAXE);

        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.COPPER_SHOVEL);

        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.COPPER_AXE);

        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.COPPER_HOE);

        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.COPPER_HELMET);

        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.COPPER_CHESTPLATE);

        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.COPPER_LEGGINGS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.COPPER_BOOTS);
    }
}
