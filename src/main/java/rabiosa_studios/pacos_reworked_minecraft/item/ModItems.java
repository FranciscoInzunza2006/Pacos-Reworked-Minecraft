package rabiosa_studios.pacos_reworked_minecraft.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;

import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import rabiosa_studios.pacos_reworked_minecraft.PacosReworkedMinecraft;

import java.util.function.Function;

public class ModItems {
    // Copper
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            settings -> new Item(settings.sword(ModToolMaterials.COPPER, 4, -2.4F)));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            settings -> new Item(settings.pickaxe(ModToolMaterials.COPPER, 1, -2.8F)));

    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            settings -> new ShovelItem(ModToolMaterials.COPPER, 1.5F, -3.0F, settings));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            settings -> new AxeItem(ModToolMaterials.COPPER, 7, -3.1F, settings));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            settings -> new HoeItem(ModToolMaterials.COPPER, 0, -1.0F, settings));

    public static final Item COPPER_HELMET = registerItem("copper_helmet",
            settings -> new Item(settings.armor(ModArmorMaterials.INSTANCE, EquipmentType.HELMET).maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.BASE_DURABILITY)))
    );
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
            settings -> new Item(settings.armor(ModArmorMaterials.INSTANCE, EquipmentType.CHESTPLATE).maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ModArmorMaterials.BASE_DURABILITY)))
    );
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings",
            settings -> new Item(settings.armor(ModArmorMaterials.INSTANCE, EquipmentType.LEGGINGS).maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ModArmorMaterials.BASE_DURABILITY)))
    );
    public static final Item COPPER_BOOTS = registerItem("copper_boots",
            settings -> new Item(settings.armor(ModArmorMaterials.INSTANCE, EquipmentType.BOOTS).maxDamage(EquipmentType.BOOTS.getMaxDamage(ModArmorMaterials.BASE_DURABILITY)))
    );

    public static final Item COPPER_NUGGET = registerItem("copper_nugget", Item::new);

    // Reinforced Golden Tools
    public static final Item AMETHYST_UPGRADE_SMITHING_TEMPLATE = registerItem("amethyst_upgrade_smithing_template",
            settings -> new SmithingTemplateItem(
                    Text.translatable("item.pacos-reworked-minecraft.smithing_template.amethyst_upgrade.applies_to").formatted(ModSmithingTemplates.DESCRIPTION_FORMATTING),
                    Text.translatable("item.pacos-reworked-minecraft.smithing_template.amethyst_upgrade.ingredients").formatted(ModSmithingTemplates.DESCRIPTION_FORMATTING),
                    Text.translatable("item.pacos-reworked-minecraft.smithing_template.amethyst_upgrade.base_slot_description"),
                    Text.translatable("item.pacos-reworked-minecraft.smithing_template.amethyst_upgrade.additions_slot_description"),
                    ModSmithingTemplates.getAmethystUpgradeEmptyBaseSlotTextures(),
                    ModSmithingTemplates.getAmethystUpgradeEmptyAdditionsSlotTextures(),
                    settings.rarity(Rarity.UNCOMMON)
            ));

    public static final Item REINFORCED_GOLDEN_SWORD = registerItem("reinforced_golden_sword",
            settings -> new Item(settings.sword(ModToolMaterials.REINFORCED_GOLD, 7, -2.4F)));
    public static final Item REINFORCED_GOLDEN_PICKAXE = registerItem("reinforced_golden_pickaxe",
            settings -> new Item(settings.pickaxe(ModToolMaterials.REINFORCED_GOLD, 1, -2.8F)));

    public static final Item REINFORCED_GOLDEN_SHOVEL = registerItem("reinforced_golden_shovel",
            settings -> new ShovelItem(ToolMaterial.IRON, 1.5F, -3.0F, settings));
    public static final Item REINFORCED_GOLDEN_AXE = registerItem("reinforced_golden_axe",
            settings -> new AxeItem(ModToolMaterials.REINFORCED_GOLD, 7, -3.1F, settings));
    public static final Item REINFORCED_GOLDEN_HOE = registerItem("reinforced_golden_hoe",
            settings -> new HoeItem(ModToolMaterials.REINFORCED_GOLD, 0, -1.0F, settings));

    // Foods
    public static final Item MELON_JAM = registerItem("melon_jam",
            settings -> new Item(
                    settings.food(ModFoodComponents.JAM, ModConsumableComponents.MELON_JAM)
                            .recipeRemainder(Items.GLASS_BOTTLE)
                            .useRemainder(Items.GLASS_BOTTLE)
                            .maxCount(16)
            )
    );

    public static final Item SWEET_BERRIES_JAM = registerItem("sweet_berries_jam",
            settings -> new Item(
                    settings.food(ModFoodComponents.JAM, ModConsumableComponents.SWEET_BERRIES)
                            .recipeRemainder(Items.GLASS_BOTTLE)
                            .useRemainder(Items.GLASS_BOTTLE)
                            .maxCount(16)
            )
    );

    public static final Item GLOW_BERRIES_JAM = registerItem("glow_berries_jam",
            settings -> new Item(
                    settings.food(ModFoodComponents.JAM, ModConsumableComponents.GLOW_BERRIES)
                            .recipeRemainder(Items.GLASS_BOTTLE)
                            .useRemainder(Items.GLASS_BOTTLE)
                            .maxCount(16)
            )
    );

    // Miscellaneous
    public static final Item SUSPICIOUS_SUBSTANCE = registerItem("suspicious_substance", Item::new);

    public static final Item WENOMECHAINSAMA = registerItem("wenomechainsama",
            settings -> new Item(settings.food(new FoodComponent(20, 20, true))));

    public static Item registerItem(String name, Function<Item.Settings, Item> item_factory) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PacosReworkedMinecraft.MOD_ID, name));
        Item item = item_factory.apply(new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);

        return item;
    }

    public static void registerItems() {
        PacosReworkedMinecraft.LOGGER.info("Registering Mod Items for" + PacosReworkedMinecraft.MOD_ID);
    }
}
