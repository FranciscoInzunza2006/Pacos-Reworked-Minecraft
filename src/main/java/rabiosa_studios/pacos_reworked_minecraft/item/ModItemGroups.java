package rabiosa_studios.pacos_reworked_minecraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import rabiosa_studios.pacos_reworked_minecraft.PacosReworkedMinecraft;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> MOD_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(PacosReworkedMinecraft.MOD_ID, "item_group"));
    public static final ItemGroup MOD_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.COPPER_SWORD))
            .displayName(Text.translatable("itemGroup.pacos_reworked_minecraft"))
            .build();

    private static void registerIngredients(FabricItemGroupEntries item_group) {
        item_group.add(ModItems.COPPER_NUGGET);
        item_group.add(ModItems.AMETHYST_UPGRADE_SMITHING_TEMPLATE);
    }

    private static void registerEquipment (FabricItemGroupEntries item_group) {
        item_group.add(ModItems.COPPER_SWORD);

        item_group.add(ModItems.COPPER_HELMET);
        item_group.add(ModItems.COPPER_CHESTPLATE);
        item_group.add(ModItems.COPPER_LEGGINGS);
        item_group.add(ModItems.COPPER_BOOTS);

        item_group.add(ModItems.REINFORCED_GOLDEN_SWORD);
    }

    private static void registerTools (FabricItemGroupEntries item_group) {
        item_group.add(ModItems.COPPER_SHOVEL);
        item_group.add(ModItems.COPPER_PICKAXE);
        item_group.add(ModItems.COPPER_AXE);
        item_group.add(ModItems.COPPER_HOE);

        item_group.add(ModItems.REINFORCED_GOLDEN_SHOVEL);
        item_group.add(ModItems.REINFORCED_GOLDEN_PICKAXE);
        item_group.add(ModItems.REINFORCED_GOLDEN_AXE);
        item_group.add(ModItems.REINFORCED_GOLDEN_HOE);
    }

    private static void registerFoods (FabricItemGroupEntries item_group) {
        item_group.add(ModItems.MELON_JAM);
        item_group.add(ModItems.SWEET_BERRIES_JAM);
        item_group.add(ModItems.GLOW_BERRIES_JAM);
    }

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, MOD_ITEM_GROUP_KEY, MOD_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItemGroups::registerIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItemGroups::registerEquipment);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItemGroups::registerTools);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItemGroups::registerFoods);

        ItemGroupEvents.modifyEntriesEvent(MOD_ITEM_GROUP_KEY).register(ModItemGroups::registerIngredients);
        ItemGroupEvents.modifyEntriesEvent(MOD_ITEM_GROUP_KEY).register(ModItemGroups::registerEquipment);
        ItemGroupEvents.modifyEntriesEvent(MOD_ITEM_GROUP_KEY).register(ModItemGroups::registerTools);
        ItemGroupEvents.modifyEntriesEvent(MOD_ITEM_GROUP_KEY).register(ModItemGroups::registerFoods);
    }


}
