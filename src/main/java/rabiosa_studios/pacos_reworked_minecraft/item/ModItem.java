package rabiosa_studios.pacos_reworked_minecraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import rabiosa_studios.pacos_reworked_minecraft.PacosReworkedMinecraft;

public class ModItem {
    public static final Item SUSPICIOUS_SUBSTANCE = registerItem("suspicious_substance", new Item.Settings());

    private static Item registerItem(String name, Item.Settings itemSettings) {
        Identifier id = Identifier.of(PacosReworkedMinecraft.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = itemSettings.registryKey(key);

        return Registry.register(Registries.ITEM, key, new Item(settings));
    }

    private static void addItemsToItemsGroup(FabricItemGroupEntries item_group) {
        item_group.add(SUSPICIOUS_SUBSTANCE);
    }

    public static void initialize () {
        PacosReworkedMinecraft.LOGGER.info("Adding items...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItem::addItemsToItemsGroup);

        PacosReworkedMinecraft.LOGGER.info("Items Added!");
    }
}
