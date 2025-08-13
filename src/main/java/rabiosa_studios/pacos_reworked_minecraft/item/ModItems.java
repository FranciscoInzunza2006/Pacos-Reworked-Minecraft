package rabiosa_studios.pacos_reworked_minecraft.item;

import net.minecraft.item.*;

import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import rabiosa_studios.pacos_reworked_minecraft.PacosReworkedMinecraft;

import java.util.function.Function;

import static rabiosa_studios.pacos_reworked_minecraft.item.ModToolMaterials.COPPER_TOOL_MATERIAL;

public class ModItems {
    // Copper
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            settings -> new Item(settings.sword(COPPER_TOOL_MATERIAL, 4, -2.4F)));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            settings -> new Item(settings.pickaxe(COPPER_TOOL_MATERIAL, 1, -2.8F)));

    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            settings -> new ShovelItem(ToolMaterial.IRON, 1.5F, -3.0F, settings));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            settings -> new AxeItem(COPPER_TOOL_MATERIAL, 7, -3.1F, settings));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            settings -> new HoeItem(COPPER_TOOL_MATERIAL, 0, -1.0F, settings));

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

    // Foods
    public static final Item MELON_JAM = registerItem("melon_jam",
            settings -> new Item(
                    settings.food(ModFoodComponents.JAM_FOOD, ModConsumableComponents.MELON_JAM)
                            .recipeRemainder(Items.GLASS_BOTTLE)
                            .useRemainder(Items.GLASS_BOTTLE)
                            .maxCount(16)
            )
    );

    public static final Item SWEET_BERRIES_JAM = registerItem("sweet_berries_jam",
            settings -> new Item(
                    settings.food(ModFoodComponents.JAM_FOOD, ModConsumableComponents.SWEET_BERRIES)
                            .recipeRemainder(Items.GLASS_BOTTLE)
                            .useRemainder(Items.GLASS_BOTTLE)
                            .maxCount(16)
            )
    );

    public static final Item GLOW_BERRIES_JAM = registerItem("glow_berries_jam",
            settings -> new Item(
                    settings.food(ModFoodComponents.JAM_FOOD, ModConsumableComponents.GLOW_BERRIES)
                            .recipeRemainder(Items.GLASS_BOTTLE)
                            .useRemainder(Items.GLASS_BOTTLE)
                            .maxCount(16)
            )
    );

    // Miscellaneous
    public static final Item SUSPICIOUS_SUBSTANCE = registerItem("suspicious_substance", Item::new);

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
