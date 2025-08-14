package rabiosa_studios.pacos_reworked_minecraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public class  ModToolMaterials {
    public static final ToolMaterial COPPER = new ToolMaterial(
            BlockTags.INCORRECT_FOR_STONE_TOOL,
            190, 5.0F, 2.0F, 13,
            ItemTags.STONE_TOOL_MATERIALS
    );

    public static final ToolMaterial REINFORCED_GOLD = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            500, 15.0F, 2.0F, 25,
            ItemTags.GOLD_TOOL_MATERIALS
    );
}
