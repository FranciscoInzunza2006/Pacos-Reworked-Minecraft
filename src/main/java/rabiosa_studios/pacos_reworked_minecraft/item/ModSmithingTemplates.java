package rabiosa_studios.pacos_reworked_minecraft.item;

import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

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

    public static List<Identifier> getAmethystUpgradeEmptyBaseSlotTextures() {
        return List.of(
                EMPTY_ARMOR_SLOT_HELMET_TEXTURE,
                EMPTY_SLOT_SWORD_TEXTURE,
                EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
                EMPTY_SLOT_PICKAXE_TEXTURE,
                EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE,
                EMPTY_SLOT_AXE_TEXTURE,
                EMPTY_ARMOR_SLOT_BOOTS_TEXTURE,
                EMPTY_SLOT_HOE_TEXTURE,
                EMPTY_SLOT_SHOVEL_TEXTURE
        );
    }

    public static List<Identifier> getAmethystUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_AMETHYST_SHARD_TEXTURE);
    }

}
