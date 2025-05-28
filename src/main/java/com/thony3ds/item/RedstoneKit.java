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

public class RedstoneKit extends Item {

    List<Item> redstoneItems = List.of(
            new ItemStack(Items.REDSTONE).getItem(),
            new ItemStack(Items.REDSTONE_BLOCK).getItem(),
            new ItemStack(Items.REDSTONE_TORCH).getItem(),
            new ItemStack(Items.REDSTONE_LAMP).getItem(),
            new ItemStack(Items.REPEATER).getItem(),
            new ItemStack(Items.COMPARATOR).getItem(),
            new ItemStack(Items.OBSERVER).getItem(),
            new ItemStack(Items.PISTON).getItem(),
            new ItemStack(Items.STICKY_PISTON).getItem(),
            new ItemStack(Items.SLIME_BLOCK).getItem(),
            new ItemStack(Items.HONEY_BLOCK).getItem(),
            new ItemStack(Items.TARGET).getItem(),
            new ItemStack(Items.DISPENSER).getItem(),
            new ItemStack(Items.DROPPER).getItem(),
            new ItemStack(Items.HOPPER).getItem(),
            new ItemStack(Items.HOPPER_MINECART).getItem(),
            new ItemStack(Items.CHEST_MINECART).getItem(),
            new ItemStack(Items.FURNACE_MINECART).getItem(),
            new ItemStack(Items.ACTIVATOR_RAIL).getItem(),
            new ItemStack(Items.DETECTOR_RAIL).getItem(),
            new ItemStack(Items.POWERED_RAIL).getItem(),
            new ItemStack(Items.RAIL).getItem(),
            new ItemStack(Items.LEVER).getItem(),
            new ItemStack(Items.STONE_BUTTON).getItem(),
            new ItemStack(Items.OAK_BUTTON).getItem(),
            new ItemStack(Items.STONE_PRESSURE_PLATE).getItem(),
            new ItemStack(Items.HEAVY_WEIGHTED_PRESSURE_PLATE).getItem(),
            new ItemStack(Items.LIGHT_WEIGHTED_PRESSURE_PLATE).getItem(),
            new ItemStack(Items.TRIPWIRE_HOOK).getItem(),
            new ItemStack(Items.NOTE_BLOCK).getItem(),
            new ItemStack(Items.COMMAND_BLOCK).getItem(),
            new ItemStack(Items.REPEATING_COMMAND_BLOCK).getItem(),
            new ItemStack(Items.CHAIN_COMMAND_BLOCK).getItem(),
            new ItemStack(Items.STRUCTURE_BLOCK).getItem(),
            new ItemStack(Items.SPAWNER).getItem(),
            new ItemStack(Items.SCULK_SENSOR).getItem(),
            new ItemStack(Items.SCULK_SHRIEKER).getItem(),
            new ItemStack(Items.DAYLIGHT_DETECTOR).getItem(),
            new ItemStack(Items.LIGHT).getItem(),
            new ItemStack(Items.BELL).getItem(),
            new ItemStack(Items.SCULK_CATALYST).getItem()
    );

    public RedstoneKit(Settings settings){
        super(settings);
    }
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand){
        if (world.isClient || player.getInventory().getMainHandStack().isEmpty()){
            return ActionResult.PASS;
        }

        boolean yes = LootboxLogic.thematicBox(player, redstoneItems);

        if(yes){
            player.getInventory().getMainHandStack().decrement(1);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
