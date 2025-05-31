package com.thony3ds;

import com.thony3ds.block.Thony3dsModsBlocks;
import com.thony3ds.criterions.Thony3dsModsCriteria;
import com.thony3ds.datagen.Thony3dsModsItemGroup;
import com.thony3ds.effects.Thony3dsModsEnchantmentEffects;
import com.thony3ds.item.Thony3dsModsItems;
import com.thony3ds.util.Thony3dsModsCustomTrades;
import com.thony3ds.villager.Thony3dsModsVillagers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Thony3dsMods implements ModInitializer {
	public static final String MOD_ID = "thony3dsmods";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		CustomPortalBuilder.beginPortal()
				.frameBlock(Thony3dsModsBlocks.ETERNITY_TRIALS_PORTAL_BLOCK)
				.destDimID(Identifier.of("thony3dsmods", "eternity_trials"))
				.tintColor(20, 242, 168)
				.lightWithItem(Items.DIAMOND)
				//.lightWithFluid(Fluids.WATER)
				.registerPortal();

		Thony3dsModsItems.initialize();
		Thony3dsModsBlocks.initialize();
		Thony3dsModsCriteria.initialize();
		ServerPlayConnectionEvents.JOIN.register((player, truc, world) -> {
			Thony3dsModsCriteria.JOIN_GAME.trigger(player.getPlayer());
		});

		Thony3dsModsEnchantmentEffects.registerModEnchantmentEffects();
		Thony3dsModsVillagers.registerVillagers();
		Thony3dsModsCustomTrades.registerCustomTrades();
		Thony3dsModsItemGroup.initialize();

		LOGGER.info("Thony3dsMods Loaded !");
	}
}