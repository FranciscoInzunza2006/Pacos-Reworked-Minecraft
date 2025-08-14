package rabiosa_studios.pacos_reworked_minecraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class ModSmithingTemplates {
    public static final Formatting TITLE_FORMATTING = Formatting.GRAY;
    public static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;

    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.ofVanilla("container/slot/helmet");
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.ofVanilla("container/slot/chestplate");
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.ofVanilla("container/slot/leggings");
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.ofVanilla("container/slot/boots");
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE = Identifier.ofVanilla("container/slot/hoe");
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE = Identifier.ofVanilla("container/slot/axe");
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = Identifier.ofVanilla("container/slot/sword");
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.ofVanilla("container/slot/shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.ofVanilla("container/slot/pickaxe");

    //private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = Identifier.ofVanilla("container/slot/ingot");
    private static final Identifier EMPTY_SLOT_AMETHYST_SHARD_TEXTURE = Identifier.ofVanilla("container/slot/amethyst_shard");

    private static List<Identifier> getAmethystUpgradeEmptyBaseSlotTextures() {
        return List.of(
                //EMPTY_ARMOR_SLOT_HELMET_TEXTURE,
                EMPTY_SLOT_SWORD_TEXTURE,
                //EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
                EMPTY_SLOT_PICKAXE_TEXTURE,
                //EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE,
                EMPTY_SLOT_AXE_TEXTURE,
                //EMPTY_ARMOR_SLOT_BOOTS_TEXTURE,
                EMPTY_SLOT_HOE_TEXTURE,
                EMPTY_SLOT_SHOVEL_TEXTURE
        );
    }

    private static List<Identifier> getAmethystUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_AMETHYST_SHARD_TEXTURE);
    }

    public static SmithingTemplateItem createAmethystUpgrade(Item.Settings settings) {
        return new SmithingTemplateItem(
                Text.translatable("item.pacos-reworked-minecraft.smithing_template.amethyst_upgrade.applies_to").formatted(ModSmithingTemplates.DESCRIPTION_FORMATTING),
                Text.translatable("item.pacos-reworked-minecraft.smithing_template.amethyst_upgrade.ingredients").formatted(ModSmithingTemplates.DESCRIPTION_FORMATTING),
                Text.translatable("item.pacos-reworked-minecraft.smithing_template.amethyst_upgrade.base_slot_description"),
                Text.translatable("item.pacos-reworked-minecraft.smithing_template.amethyst_upgrade.additions_slot_description"),
                ModSmithingTemplates.getAmethystUpgradeEmptyBaseSlotTextures(),
                ModSmithingTemplates.getAmethystUpgradeEmptyAdditionsSlotTextures(),
                settings.rarity(Rarity.UNCOMMON)
        );
    }

}
