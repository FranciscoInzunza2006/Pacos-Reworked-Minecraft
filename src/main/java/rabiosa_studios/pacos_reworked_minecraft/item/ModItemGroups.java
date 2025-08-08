package rabiosa_studios.pacos_reworked_minecraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import rabiosa_studios.pacos_reworked_minecraft.PacosReworkedMinecraft;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> MOD_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(PacosReworkedMinecraft.MOD_ID, "item_group"));
    public static final ItemGroup MOD_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.COPPER_SWORD))
            .displayName(Text.translatable("itemGroup.pacos_reworked_minecraft"))
            .build();

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, MOD_ITEM_GROUP_KEY, MOD_ITEM_GROUP);
    }
}
