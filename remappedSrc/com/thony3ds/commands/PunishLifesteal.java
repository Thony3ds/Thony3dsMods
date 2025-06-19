package com.thony3ds.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.thony3ds.item.Thony3dsModsItems;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class PunishLifesteal {
    public static int executeCommand(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
        player.sendMessage(Text.of("An administrator punished you !"));
        player.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(10);

        context.getSource().sendFeedback(() -> Text.literal("Player: "+player.getName()+" have been punished !"), true);
        return 1;
    }
}
