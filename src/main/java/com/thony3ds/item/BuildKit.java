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

    public BuildKit(Settings settings){
        super(settings);
    }
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand){
        if (world.isClient || player.getInventory().getMainHandStack().isEmpty()){
            return ActionResult.PASS;
        }

        boolean yes = LootboxLogic.thematicBox(player, 2);
        if(yes){
            player.getInventory().getMainHandStack().decrement(1);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
