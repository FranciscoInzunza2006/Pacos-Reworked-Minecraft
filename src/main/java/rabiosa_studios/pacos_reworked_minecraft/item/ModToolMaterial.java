package rabiosa_studios.pacos_reworked_minecraft.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public class ModToolMaterial {
    public static final ToolMaterial COPPER_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            445,
            5.0f,
            1.5f,
            22,
            ItemTags.DIAMOND_TOOL_MATERIALS
    );


}
