package rabiosa_studios.pacos_reworked_minecraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import rabiosa_studios.pacos_reworked_minecraft.PacosReworkedMinecraft;

import java.util.function.Function;

public class ModItem {
    // Copper
    public static final Item COPPER_SWORD = registerItem("copper_sword", Item::new, new Item.Settings().sword(ModToolMaterial.COPPER_TOOL_MATERIAL, 1, 1f));
    public static final Item COPPER_NUGGET = registerItem("copper_nugget", Item::new, new Item.Settings());

    // Miscellaneous
    public static final Item SUSPICIOUS_SUBSTANCE = registerItem("suspicious_substance", Item::new, new Item.Settings());

    ///// Functions /////
    public static Item registerItem(String name, Function<Item.Settings, Item> item_factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PacosReworkedMinecraft.MOD_ID, name));
        Item item = item_factory.apply(settings.registryKey(key));
        Registry.register(Registries.ITEM, key, item);

        return item;
    }

    private static void addItemsToItemsGroup(FabricItemGroupEntries item_group) {
        item_group.add(COPPER_NUGGET);
        item_group.add(SUSPICIOUS_SUBSTANCE);
        item_group.add(COPPER_SWORD);
    }

    public static void initialize () {
        PacosReworkedMinecraft.LOGGER.info("Adding items...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItem::addItemsToItemsGroup);

        PacosReworkedMinecraft.LOGGER.info("Items Added!");
    }
}
