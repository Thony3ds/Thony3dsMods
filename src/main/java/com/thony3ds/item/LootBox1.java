package com.thony3ds.item;

import com.thony3ds.Thony3dsMods;
import com.thony3ds.util.LootboxLogic;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class LootBox1 extends Item {

    public LootBox1(Settings settings){
        super(settings);
    }
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand){
        if (!world.isClient && !player.getStackInHand(hand).isEmpty()) {

            player.getItemCooldownManager().set(player.getStackInHand(hand), 20);
            player.getStackInHand(hand).decrement(1);

            ItemStack itemStack = LootboxLogic.getRandomItem(1);

            player.giveItemStack(itemStack);

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
}
