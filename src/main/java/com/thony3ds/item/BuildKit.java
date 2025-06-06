package com.thony3ds.item;

import com.thony3ds.util.LootboxLogic;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class BuildKit extends Item {

    public static List<Item> decorationItems = new ArrayList<>(List.of(
            new ItemStack(Items.STONE).getItem(),
            new ItemStack(Items.GRANITE).getItem(),
            new ItemStack(Items.DIORITE).getItem(),
            new ItemStack(Items.ANDESITE).getItem(),
            new ItemStack(Items.COBBLESTONE).getItem(),
            new ItemStack(Items.BRICKS).getItem(),
            new ItemStack(Items.STONE_BRICKS).getItem(),
            new ItemStack(Items.MOSSY_STONE_BRICKS).getItem(),
            new ItemStack(Items.SMOOTH_STONE).getItem(),
            new ItemStack(Items.SMOOTH_SANDSTONE).getItem(),
            new ItemStack(Items.SMOOTH_QUARTZ).getItem(),
            new ItemStack(Items.POLISHED_GRANITE).getItem(),
            new ItemStack(Items.POLISHED_DIORITE).getItem(),
            new ItemStack(Items.POLISHED_ANDESITE).getItem(),
            new ItemStack(Items.WHITE_TERRACOTTA).getItem(),
            new ItemStack(Items.ORANGE_TERRACOTTA).getItem(),
            new ItemStack(Items.MAGENTA_TERRACOTTA).getItem(),
            new ItemStack(Items.LIGHT_BLUE_TERRACOTTA).getItem(),
            new ItemStack(Items.YELLOW_TERRACOTTA).getItem(),
            new ItemStack(Items.LIME_TERRACOTTA).getItem(),
            new ItemStack(Items.PINK_TERRACOTTA).getItem(),
            new ItemStack(Items.GRAY_TERRACOTTA).getItem(),
            new ItemStack(Items.LIGHT_GRAY_TERRACOTTA).getItem(),
            new ItemStack(Items.CYAN_TERRACOTTA).getItem(),
            new ItemStack(Items.PURPLE_TERRACOTTA).getItem(),
            new ItemStack(Items.BLUE_TERRACOTTA).getItem(),
            new ItemStack(Items.BROWN_TERRACOTTA).getItem(),
            new ItemStack(Items.GREEN_TERRACOTTA).getItem(),
            new ItemStack(Items.RED_TERRACOTTA).getItem(),
            new ItemStack(Items.BLACK_TERRACOTTA).getItem(),
            new ItemStack(Items.GLOWSTONE).getItem(),
            new ItemStack(Items.SEA_LANTERN).getItem(),
            new ItemStack(Items.LANTERN).getItem(),
            new ItemStack(Items.SOUL_LANTERN).getItem(),
            new ItemStack(Items.PAINTING).getItem(),
            new ItemStack(Items.FLOWER_POT).getItem(),
            new ItemStack(Items.BOOKSHELF).getItem(),
            new ItemStack(Items.CHISELED_BOOKSHELF).getItem(),
            new ItemStack(Items.TORCH).getItem(),
            new ItemStack(Items.SOUL_TORCH).getItem(),
            new ItemStack(Items.CANDLE).getItem(),
            new ItemStack(Items.WHITE_CANDLE).getItem(),
            new ItemStack(Items.YELLOW_CANDLE).getItem(),
            new ItemStack(Items.BLUE_CANDLE).getItem(),
            new ItemStack(Items.PURPLE_CANDLE).getItem(),
            new ItemStack(Items.RED_CANDLE).getItem(),
            new ItemStack(Items.GREEN_CANDLE).getItem(),
            new ItemStack(Items.BLACK_CANDLE).getItem(),
            new ItemStack(Items.LECTERN).getItem(),
            new ItemStack(Items.BELL).getItem(),
            new ItemStack(Items.BARREL).getItem(),
            new ItemStack(Items.CHEST).getItem(),
            new ItemStack(Items.CAMPFIRE).getItem(),
            new ItemStack(Items.SOUL_CAMPFIRE).getItem(),
            new ItemStack(Items.STONECUTTER).getItem(),
            new ItemStack(Items.ANVIL).getItem(),
            new ItemStack(Items.FLOWER_POT).getItem(),
            new ItemStack(Items.WHITE_BANNER).getItem(),
            new ItemStack(Items.END_ROD).getItem(),
            new ItemStack(Items.IRON_BARS).getItem(),
            new ItemStack(Items.LADDER).getItem()
    ));


    public BuildKit(Settings settings){
        super(settings);
    }
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand){
        if (world.isClient || player.getInventory().getMainHandStack().isEmpty()){
            return ActionResult.PASS;
        }

        boolean yes = LootboxLogic.thematicBox(player, decorationItems);
        if(yes){
            player.getInventory().getMainHandStack().decrement(1);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
