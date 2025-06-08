package com.thony3ds.item;

import com.thony3ds.util.LootboxLogic;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Heart extends Item {

    public Heart(Item.Settings settings){
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand){
        if (world.isClient || player.getInventory().getMainHandStack().isEmpty()){
            return ActionResult.PASS;
        }

        if (!(player.getMaxHealth() >= 39)) {
            player.getInventory().getMainHandStack().decrement(1);
            player.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(player.getMaxHealth() + 2);
        }else{
            player.sendMessage(Text.of("You can't have more HP !"), false);
        }
        return ActionResult.SUCCESS;
    }
}
