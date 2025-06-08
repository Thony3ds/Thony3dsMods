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

public class LootBox4 extends Item {

    private final List<ItemStack> lootLegendaire = Arrays.asList(
            new ItemStack(Items.SHULKER_BOX, 5),
            new ItemStack(Items.WITHER_ROSE, 3),
            new ItemStack(Items.GHAST_TEAR, 3),
            new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1),
            new ItemStack(Items.DIAMOND_HORSE_ARMOR),
            new ItemStack(Items.TOTEM_OF_UNDYING),
            new ItemStack(Items.NETHERITE_INGOT, 3),
            new ItemStack(Items.DRAGON_HEAD, 1),
            new ItemStack(Items.DIAMOND_BLOCK, 32),
            new ItemStack(Items.TRIAL_KEY),
            new ItemStack(Items.OMINOUS_TRIAL_KEY),
            new ItemStack(Items.WITHER_SKELETON_SKULL, 3),
            new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 3),
            new ItemStack(Items.HEAVY_CORE),
            new ItemStack(Thony3dsModsItems.POLISH_COW_MUSIC_DISK)
    );


    public LootBox4(Settings settings){
        super(settings);
    }
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand){
        if (world.isClient || player.getInventory().getMainHandStack().isEmpty()){
            return ActionResult.PASS;
        }

        player.getInventory().getMainHandStack().decrement(1);
        player.giveItemStack(LootboxLogic.getRandomItem(4));
        return ActionResult.SUCCESS;
    }
}
