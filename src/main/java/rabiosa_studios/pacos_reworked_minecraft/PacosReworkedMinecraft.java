package rabiosa_studios.pacos_reworked_minecraft;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rabiosa_studios.pacos_reworked_minecraft.item.ModItems;
import rabiosa_studios.pacos_reworked_minecraft.item.ModItemGroups;

public class PacosReworkedMinecraft implements ModInitializer {
	public static final String MOD_ID = "pacos-reworked-minecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModItemGroups.registerItemGroups();
	}
}