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

public class LootBox1 extends Item {

    private final List<ItemStack> lootCommun = Arrays.asList(
            new ItemStack(Items.DIRT, 64),
            new ItemStack(Items.IRON_INGOT, 16),
            new ItemStack(Items.EMERALD, 16),
            new ItemStack(Items.GOLD_INGOT, 16),
            new ItemStack(Items.WOLF_SPAWN_EGG, 1),
            new ItemStack(Items.BOOK, 16),
            new ItemStack(Items.DIAMOND, 5),
            new ItemStack(Items.GOLDEN_APPLE, 5),
            new ItemStack(Items.COW_SPAWN_EGG, 1),
            new ItemStack(Items.SHEEP_SPAWN_EGG, 1),
            new ItemStack(Items.PIG_SPAWN_EGG, 1),
            new ItemStack(Items.CHICKEN_SPAWN_EGG, 1),
            new ItemStack(Items.ARMADILLO_SCUTE, 1),
            new ItemStack(Items.WOLF_ARMOR, 1),
            new ItemStack(Items.ANCIENT_DEBRIS, 1)
    );

    public LootBox1(Settings settings){
        super(settings);
    }
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand){
        if (world.isClient || player.getInventory().getMainHandStack().isEmpty()){
            return ActionResult.PASS;
        }

        player.getInventory().getMainHandStack().decrement(1);
        player.getInventory().insertStack(LootboxLogic.getRandomItem(lootCommun));
        return ActionResult.SUCCESS;
    }
}
