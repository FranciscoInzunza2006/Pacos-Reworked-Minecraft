package rabiosa_studios.pacos_reworked_minecraft.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;

import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import rabiosa_studios.pacos_reworked_minecraft.PacosReworkedMinecraft;

import java.util.function.Function;

public class ModItems {
    // Copper
    public static final Item COPPER_SWORD = register("copper_sword",
            new Item.Settings().sword(ModToolMaterials.COPPER, 4, -2.4F));
    public static final Item COPPER_PICKAXE = register("copper_pickaxe",
            new Item.Settings().pickaxe(ModToolMaterials.COPPER, 1, -2.8F));

    public static final Item COPPER_SHOVEL = register("copper_shovel",
            settings -> new ShovelItem(ModToolMaterials.COPPER, 1.5F, -3.0F, settings));
    public static final Item COPPER_AXE = register("copper_axe",
            settings -> new AxeItem(ModToolMaterials.COPPER, 7, -3.1F, settings));
    public static final Item COPPER_HOE = register("copper_hoe",
            settings -> new HoeItem(ModToolMaterials.COPPER, 0, -1.0F, settings));

    public static final Item COPPER_HELMET = register("copper_helmet", new Item.Settings()
            .armor(ModArmorMaterials.INSTANCE, EquipmentType.HELMET).maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.BASE_DURABILITY)));

    public static final Item COPPER_CHESTPLATE = register("copper_chestplate", new Item.Settings()
            .armor(ModArmorMaterials.INSTANCE, EquipmentType.CHESTPLATE).maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ModArmorMaterials.BASE_DURABILITY)));

    public static final Item COPPER_LEGGINGS = register("copper_leggings", new Item.Settings()
            .armor(ModArmorMaterials.INSTANCE, EquipmentType.LEGGINGS).maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
    );

    public static final Item COPPER_BOOTS = register("copper_boots", new Item.Settings()
            .armor(ModArmorMaterials.INSTANCE, EquipmentType.BOOTS).maxDamage(EquipmentType.BOOTS.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
    );

    public static final Item COPPER_NUGGET = register("copper_nugget");

    // Reinforced Golden Tools
    public static final Item AMETHYST_UPGRADE_SMITHING_TEMPLATE = register("amethyst_upgrade_smithing_template", ModSmithingTemplates::createAmethystUpgrade);

    public static final Item REINFORCED_GOLDEN_SWORD = register("reinforced_golden_sword",
            new Item.Settings().sword(ModToolMaterials.REINFORCED_GOLD, 7, -2.4F));
    public static final Item REINFORCED_GOLDEN_PICKAXE = register("reinforced_golden_pickaxe",
            new Item.Settings().pickaxe(ModToolMaterials.REINFORCED_GOLD, 1, -2.8F));

    public static final Item REINFORCED_GOLDEN_SHOVEL = register("reinforced_golden_shovel",
            settings -> new ShovelItem(ModToolMaterials.REINFORCED_GOLD, 1.5F, -3.0F, settings));
    public static final Item REINFORCED_GOLDEN_AXE = register("reinforced_golden_axe",
            settings -> new AxeItem(ModToolMaterials.REINFORCED_GOLD, 7, -3.1F, settings));
    public static final Item REINFORCED_GOLDEN_HOE = register("reinforced_golden_hoe",
            settings -> new HoeItem(ModToolMaterials.REINFORCED_GOLD, 0, -1.0F, settings));

    // Foods
    private static Item.Settings JamSettings (ConsumableComponent consumable_component) {
        return new Item.Settings().food(ModFoodComponents.JAM, consumable_component)
                .recipeRemainder(Items.GLASS_BOTTLE)
                .useRemainder(Items.GLASS_BOTTLE)
                .maxCount(16);
    }
    public static final Item MELON_JAM = register("melon_jam", JamSettings(ModConsumableComponents.MELON_JAM));
    public static final Item SWEET_BERRIES_JAM = register("sweet_berries_jam", JamSettings(ModConsumableComponents.SWEET_BERRIES));
    public static final Item GLOW_BERRIES_JAM = register("glow_berries_jam", JamSettings(ModConsumableComponents.GLOW_BERRIES));

    // Miscellaneous
    public static final Item SUSPICIOUS_SUBSTANCE = register("suspicious_substance");
    public static final Item WENOMECHAINSAMA = register("wenomechainsama", new Item.Settings().food(new FoodComponent(20, 20, true)));

    //region Register Functions
    public static Item register(String name) {
        return register(name, new Item.Settings());
    }

    public static Item register(String name, Item.Settings settings) {
        return register(name, Item::new, settings);
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory) {
        return register(name, itemFactory, new Item.Settings());
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PacosReworkedMinecraft.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void registerItems() {
        PacosReworkedMinecraft.LOGGER.info("Registering Mod Items for" + PacosReworkedMinecraft.MOD_ID);
    }
    //endregion
}
