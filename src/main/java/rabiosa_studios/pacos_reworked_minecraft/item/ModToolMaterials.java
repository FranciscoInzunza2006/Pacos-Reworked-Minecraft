package rabiosa_studios.pacos_reworked_minecraft.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public class ModToolMaterials {
    public static final ToolMaterial COPPER_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_STONE_TOOL,
            190, 5.0F, 2.0F, 13,
            ItemTags.STONE_TOOL_MATERIALS
    );
}
