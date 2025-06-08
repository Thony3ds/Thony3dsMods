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
import java.util.Collections;
import java.util.List;

public class LootBox1 extends Item {

    public LootBox1(Settings settings){
        super(settings);
    }
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand){
        if (world.isClient || player.getInventory().getMainHandStack().isEmpty()){
            return ActionResult.PASS;
        }

        player.getItemCooldownManager().set(new ItemStack(this), 20);

        player.getInventory().getMainHandStack().decrement(1);
        player.giveItemStack(LootboxLogic.getRandomItem(1 ));
        return ActionResult.SUCCESS;
    }
}
