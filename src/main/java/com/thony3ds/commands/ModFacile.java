package com.thony3ds.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ModFacile {
    public static List<UUID> easy_players = new ArrayList<UUID>();

    public static boolean addPlayer(PlayerEntity player){
        easy_players.add(player.getUuid());
        return true;
    }
    public static boolean removePlayer(PlayerEntity player){
        if (easy_players.contains(player.getUuid())){
            easy_players.remove(player.getUuid());
            return true;
        }
        return false;
    }
    public static int executeCommand(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        String type = StringArgumentType.getString(context, "action");
        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
        switch (type){
            case "add":
                addPlayer(player);
                context.getSource().sendFeedback(() -> Text.literal("Player: "+player.getName()+" is now on Easy Mod !"), true);
                break;
            case "remove":
                removePlayer(player);
                context.getSource().sendFeedback(() -> Text.literal("Player: "+player.getName()+" not have Easy Mod now !"), true);
                break;
        }
        return 1;
    }
    public static int executeRemoveCommand(CommandContext<ServerCommandSource> context){
        PlayerEntity player = context.getSource().getPlayer();
        if (easy_players.contains(player.getUuid())){
            easy_players.remove(player.getUuid());
            player.sendMessage(Text.of("Easy Mod Disable"), false);
            return 1;
        }
        player.sendMessage(Text.of("You are not on Easy Mod !"), false);
        return 0;
    }

    public static List<UUID> getEasy_players(){return easy_players;}
}
