package com.thony3ds.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.thony3ds.item.Thony3dsModsItems;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class WithDraw {
    public static int executeCommand(CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(() -> Text.literal("Withdraw Command Executing..."), false);
        int amount = IntegerArgumentType.getInteger(context, "amount");
        ServerPlayerEntity player = context.getSource().getPlayer();
        if (player.getMaxHealth() - amount*2 >= 10){
            player.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(player.getMaxHealth() - amount*2);
            player.giveItemStack(new ItemStack(Thony3dsModsItems.HEART, amount));
        }else{
            player.sendMessage(Text.of("You need to be on minimum 5 hearts after this !"));
        }
        return 1;
    }
}
