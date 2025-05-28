package com.thony3ds;

import com.thony3ds.item.Thony3dsModsItems;
import com.thony3ds.util.Thony3dsModsCustomTrades;
import com.thony3ds.villager.Thony3dsModsVillagers;
import net.fabricmc.api.ModInitializer;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Thony3dsMods implements ModInitializer {
	public static final String MOD_ID = "thony3dsmods";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.NETHERITE_BLOCK)
				.destDimID(Identifier.of("thony3dsmods", "eternity_trials"))
				.tintColor(20, 242, 168)
				.lightWithItem(Items.NETHERITE_INGOT)
				//.lightWithFluid(Fluids.WATER)
				.registerPortal();

		Thony3dsModsVillagers.registerVillagers();
		Thony3dsModsCustomTrades.registerCustomTrades();
		Thony3dsModsItems.initialize();

		LOGGER.info("Thony3dsMods Loaded !");
	}
}