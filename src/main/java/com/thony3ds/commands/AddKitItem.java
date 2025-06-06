package com.thony3ds.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.thony3ds.item.BuildKit;
import com.thony3ds.item.RedstoneKit;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.command.argument.ItemStackArgumentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.util.Objects;

public class AddKitItem {
    public static int executeCommand(CommandContext<ServerCommandSource> context) {

        String type = StringArgumentType.getString(context, "kit_type");
        ItemStackArgument itemArg = ItemStackArgumentType.getItemStackArgument(context, "item");
        Item item = itemArg.getItem();

        if (Objects.equals(type, "redstone") && !RedstoneKit.redstoneItems.contains(item)){
            RedstoneKit.redstoneItems.add(item);
            context.getSource().sendFeedback(() -> Text.literal("New Item: "+ item.getName() + " has been added in the Redstone Kit !"), true);
        }else if (Objects.equals(type, "build") && !BuildKit.decorationItems.contains(item)){
            BuildKit.decorationItems.add(new ItemStack(item).getItem());
            context.getSource().sendFeedback(() -> Text.literal("New Item: "+ item.getName() + " has been added in the Build Kit !"), true);
        }else{
            if (Objects.equals(type, "redstone")) {
                context.getSource().sendFeedback(() -> Text.literal("This item already exists in the Redstone Kit!"), false);
            } else if (Objects.equals(type, "build")) {
                context.getSource().sendFeedback(() -> Text.literal("This item already exists in the Build Kit!"), false);
            } else {
                context.getSource().sendFeedback(() -> Text.literal("Invalid Kit Type!"), false);
            }
        }

        return 1;
    }
}
