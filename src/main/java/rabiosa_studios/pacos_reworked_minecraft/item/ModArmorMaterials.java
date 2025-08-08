package rabiosa_studios.pacos_reworked_minecraft.item;

import net.minecraft.item.equipment.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import rabiosa_studios.pacos_reworked_minecraft.PacosReworkedMinecraft;

import java.util.Map;

public class ModArmorMaterials {
    public static final int BASE_DURABILITY = 15;
    public static final RegistryKey<EquipmentAsset> COPPER_ARMOR_MATERIAL_KEY =
            RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(PacosReworkedMinecraft.MOD_ID, "copper"));

    //public static final TagKey<Item> REPAIRS_COPPER_ARMOR = TagKey.of(RegistryKeys.ITEM, Identifier.of(PacosReworkedMinecraft.MOD_ID, "repairs_copper_armor"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            ItemTags.REPAIRS_IRON_ARMOR,
            COPPER_ARMOR_MATERIAL_KEY
    );

}
