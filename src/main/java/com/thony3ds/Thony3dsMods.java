package com.thony3ds;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.thony3ds.block.Thony3dsModsBlocks;
import com.thony3ds.commands.AddKitItem;
import com.thony3ds.commands.KitTypeSuggestionProvider;
import com.thony3ds.commands.PunishLifesteal;
import com.thony3ds.commands.WithDraw;
import com.thony3ds.criterions.Thony3dsModsCriteria;
import com.thony3ds.datagen.Thony3dsModsItemGroup;
import com.thony3ds.effects.Thony3dsModsEffects;
import com.thony3ds.item.Thony3dsModsItems;
import com.thony3ds.item.Thony3dsModsPotions;
import com.thony3ds.sound.Thony3dsModsSounds;
import com.thony3ds.util.Thony3dsModsCustomTrades;
import com.thony3ds.villager.Thony3dsModsVillagers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.ItemStackArgumentType;
import net.minecraft.item.Items;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
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

		Thony3dsModsSounds.registerSounds();
		Thony3dsModsItems.initialize();
		Thony3dsModsBlocks.initialize();
		Thony3dsModsCriteria.initialize();
		ServerPlayConnectionEvents.JOIN.register((player, truc, world) -> {
			Thony3dsModsCriteria.JOIN_GAME.trigger(player.getPlayer());
		});

		Thony3dsModsEffects.registerModEnchantmentEffects();
		Thony3dsModsPotions.initialize();
		Thony3dsModsVillagers.registerVillagers();
		Thony3dsModsCustomTrades.registerCustomTrades();
		Thony3dsModsItemGroup.initialize();

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(CommandManager.literal("withdraw")
					.requires(ServerCommandSource::isExecutedByPlayer)
					.then(CommandManager.argument("amount", IntegerArgumentType.integer())
						.executes(WithDraw::executeCommand)));
		});
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(CommandManager.literal("punish_lifesteal")
					.requires(source -> source.hasPermissionLevel(4))
					.then(CommandManager.argument("player", EntityArgumentType.player())
						.executes(PunishLifesteal::executeCommand)));
		});
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			SuggestionProvider<ServerCommandSource> KitTypeSuggestionProvider = new KitTypeSuggestionProvider();
			dispatcher.register(CommandManager.literal("add_kit_item")
					.requires(source -> source.hasPermissionLevel(4))
					.then(CommandManager.argument("kit_type", StringArgumentType.string()).suggests(KitTypeSuggestionProvider)
							.then(CommandManager.argument("item", ItemStackArgumentType.itemStack(registryAccess))
								.executes(AddKitItem::executeCommand))));
		});
		LOGGER.info("Thony3dsMods Loaded !");
	}
}