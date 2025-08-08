package rabiosa_studios.pacos_reworked_minecraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;

import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import rabiosa_studios.pacos_reworked_minecraft.PacosReworkedMinecraft;

import java.util.function.Function;

import static rabiosa_studios.pacos_reworked_minecraft.item.ModItemGroups.MOD_ITEM_GROUP_KEY;
import static rabiosa_studios.pacos_reworked_minecraft.item.ModToolMaterials.COPPER_TOOL_MATERIAL;

public class ModItems {
    // Copper
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new Item.Settings().sword(COPPER_TOOL_MATERIAL, 4, -2.4F));

    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new Item.Settings().pickaxe(COPPER_TOOL_MATERIAL, 1, -2.8F));

    public static final Item COPPER_SHOVEL = registerItemExt("copper_shovel",
            settings -> new ShovelItem(ToolMaterial.IRON, 1.5F, -3.0F, settings), new Item.Settings());
    public static final Item COPPER_AXE = registerItemExt("copper_axe",
            settings -> new AxeItem(COPPER_TOOL_MATERIAL, 7, -3.1F, settings), new Item.Settings());
    public static final Item COPPER_HOE = registerItemExt("copper_hoe",
            settings -> new HoeItem(COPPER_TOOL_MATERIAL, 0, -1.0F, settings), new Item.Settings());

    public static final Item COPPER_HELMET = registerItem("copper_helmet",
            new Item.Settings().armor(ModArmorMaterials.INSTANCE, EquipmentType.HELMET).maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
    );
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", new Item.Settings().armor(ModArmorMaterials.INSTANCE, EquipmentType.CHESTPLATE).maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
    );
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings",
            new Item.Settings().armor(ModArmorMaterials.INSTANCE, EquipmentType.LEGGINGS).maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
    );
    public static final Item COPPER_BOOTS = registerItem("copper_boots",
            new Item.Settings().armor(ModArmorMaterials.INSTANCE, EquipmentType.BOOTS).maxDamage(EquipmentType.BOOTS.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
    );

    /*
    public static final Item IRON_SWORD = register("iron_sword", new Item.Settings().sword(ToolMaterial.IRON, 3.0F, -2.4F));
    public static final Item IRON_SHOVEL = register("iron_shovel", settings -> new ShovelItem(ToolMaterial.IRON, 1.5F, -3.0F, settings));
    public static final Item IRON_PICKAXE = register("iron_pickaxe", new Item.Settings().pickaxe(ToolMaterial.IRON, 1.0F, -2.8F));
    public static final Item IRON_AXE = register("iron_axe", settings -> new AxeItem(ToolMaterial.IRON, 6.0F, -3.1F, settings));
    public static final Item IRON_HOE = register("iron_hoe", settings -> new HoeItem(ToolMaterial.IRON, -2.0F, -1.0F, settings));
    */


    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item.Settings());

    // Miscellaneous
    public static final Item SUSPICIOUS_SUBSTANCE = registerItem("suspicious_substance", new Item.Settings());

    ///// Functions /////
    public static Item registerItem(String name, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PacosReworkedMinecraft.MOD_ID, name));
        Item item = new Item(settings.registryKey(key));
        Registry.register(Registries.ITEM, key, item);

        return item;
    }

    public static Item registerItemExt(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PacosReworkedMinecraft.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    private static void registerModItems(FabricItemGroupEntries item_group) {
        item_group.add(COPPER_NUGGET);
        item_group.add(SUSPICIOUS_SUBSTANCE);
    }

    private static void registerEquipment (FabricItemGroupEntries item_group) {
        item_group.add(COPPER_SWORD);

        item_group.add(COPPER_HELMET);
        item_group.add(COPPER_CHESTPLATE);
        item_group.add(COPPER_LEGGINGS);
        item_group.add(COPPER_BOOTS);
    }

    private static void registerTools (FabricItemGroupEntries item_group) {
        item_group.add(COPPER_SHOVEL);
        item_group.add(COPPER_PICKAXE);
        item_group.add(COPPER_AXE);
        item_group.add(COPPER_HOE);
    }

    public static void registerItems () {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::registerModItems);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::registerEquipment);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::registerTools);

        ItemGroupEvents.modifyEntriesEvent(MOD_ITEM_GROUP_KEY).register(ModItems::registerModItems);
        ItemGroupEvents.modifyEntriesEvent(MOD_ITEM_GROUP_KEY).register(ModItems::registerEquipment);
        ItemGroupEvents.modifyEntriesEvent(MOD_ITEM_GROUP_KEY).register(ModItems::registerTools);
    }
}
