package com.thony3ds.item;

import com.thony3ds.util.LootboxLogic;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

public class LootBox2 extends Item {

    private final List<ItemStack> lootRare = Arrays.asList(
            new ItemStack(Items.IRON_INGOT, 32),
            new ItemStack(Items.EMERALD, 32),
            new ItemStack(Items.GOLD_INGOT, 32),
            new ItemStack(Items.CARROT, 32),
            new ItemStack(Items.VILLAGER_SPAWN_EGG, 1),
            new ItemStack(Items.APPLE, 32),
            new ItemStack(Items.NAME_TAG, 1),
            new ItemStack(Items.SADDLE, 1),
            new ItemStack(Items.HONEY_BOTTLE, 6),
            new ItemStack(Items.VILLAGER_SPAWN_EGG, 3),
            new ItemStack(Items.DIAMOND_BLOCK, 2),
            new ItemStack(Items.ENDER_PEARL, 8),
            new ItemStack(Items.TOTEM_OF_UNDYING, 1),
            new ItemStack(Items.NETHERITE_SCRAP, 1),
            new ItemStack(Items.NETHERITE_INGOT, 1)
    );

    public LootBox2(Settings settings){
        super(settings);
    }
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand){
        if (world.isClient || player.getInventory().getMainHandStack().isEmpty()){
            return ActionResult.PASS;
        }

        player.getInventory().getMainHandStack().decrement(1);
        player.giveItemStack(LootboxLogic.getRandomItem(lootRare));
        return ActionResult.SUCCESS;
    }
}
