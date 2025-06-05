package com.thony3ds.item;

import com.thony3ds.Thony3dsMods;
import com.thony3ds.util.LootboxLogic;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

public class LootBox3 extends Item {

    private final List<ItemStack> lootEpique = Arrays.asList(
            new ItemStack(Items.BLAZE_ROD, 16),
            new ItemStack(Items.NETHER_WART, 16),
            new ItemStack(Items.BONE_BLOCK, 32),
            new ItemStack(Items.ECHO_SHARD, 2),
            new ItemStack(Items.SOUL_SAND, 32),
            new ItemStack(Items.SHULKER_SHELL, 6),
            new ItemStack(Items.EVOKER_SPAWN_EGG),
            new ItemStack(Items.GOLDEN_APPLE, 32),
            new ItemStack(Items.SHULKER_BOX, 2),
            new ItemStack(Items.EXPERIENCE_BOTTLE, 32),
            new ItemStack(Items.OMINOUS_BOTTLE, 1),
            new ItemStack(Items.NETHERITE_SCRAP, 3),
            new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1),
            new ItemStack(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, 1),
            new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 1)
    );


    public LootBox3(Settings settings){
        super(settings);
    }
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand){
        if (world.isClient || player.getInventory().getMainHandStack().isEmpty()){
            return ActionResult.PASS;
        }

        player.getInventory().getMainHandStack().decrement(1);
        player.giveItemStack(LootboxLogic.getRandomItem(lootEpique));
        return ActionResult.SUCCESS;
    }
}
