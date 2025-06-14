package com.thony3ds.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.thony3ds.util.LootboxLogic;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.command.argument.ItemStackArgumentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.*;

public class TpSpawn {
    public static int executeCommand(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerCommandSource source = context.getSource();
        ServerPlayerEntity player = source.getPlayer();

        if (player != null) {
            UUID uuid = player.getUuid();

            if (!CooldownManager.canUse(uuid)) {
                long timeLeft = CooldownManager.COOLDOWN_TIME - (System.currentTimeMillis() - CooldownManager.lastUseMap.get(uuid));
                long seconds = timeLeft / 1000;
                source.sendError(Text.literal("Veuillez patienter " + seconds + " secondes avant de réutiliser la commande."));
                return 0;
            }

            MinecraftServer server = player.getServer();
            ServerWorld overworld = server.getWorld(World.OVERWORLD);

            if (overworld != null) {

                player.teleport(overworld,  0.0, 92.0, 0.0,
                        EnumSet.of(
                                PositionFlag.X, PositionFlag.Y, PositionFlag.Z,
                                PositionFlag.Y_ROT, PositionFlag.X_ROT
                        ),
                        0.0f, 0.0f, false);
                CooldownManager.recordUse(uuid);
                player.sendMessage(Text.of("Téléporté au spawn !"), false);
                return 1;
            }
        }

        source.sendError(Text.literal("Impossible de téléporter le joueur."));
        return 0;
    }
    // Classe de cooldown directement ici
    public static class CooldownManager {
        private static final long COOLDOWN_TIME = 5 * 60 * 1000;
        private static final HashMap<UUID, Long> lastUseMap = new HashMap<>();

        public static boolean canUse(UUID playerUUID) {
            long now = System.currentTimeMillis();
            return !lastUseMap.containsKey(playerUUID) || now - lastUseMap.get(playerUUID) >= COOLDOWN_TIME;
        }

        public static void recordUse(UUID playerUUID) {
            lastUseMap.put(playerUUID, System.currentTimeMillis());
        }
    }

}
