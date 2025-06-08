package com.thony3ds.util;

import com.thony3ds.item.Thony3dsModsItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.math.BigDecimal;

public class LootboxLogic {

    private static final List<BigDecimal> chances = List.of(
            new BigDecimal("23"),
            new BigDecimal("10"), new BigDecimal("10"), new BigDecimal("10"), new BigDecimal("10"),
            new BigDecimal("5"), new BigDecimal("5"), new BigDecimal("5"), new BigDecimal("5"), new BigDecimal("5"), new BigDecimal("5"),
            new BigDecimal("2.5"), new BigDecimal("2.5"),
            new BigDecimal("1.955"), new BigDecimal("0.045")
    );

    private static final List<ItemStack> lootCommun = Collections.unmodifiableList(Arrays.asList(
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
            new ItemStack(Items.FIREWORK_ROCKET, 64),
            new ItemStack(Items.WOLF_ARMOR, 1),
            new ItemStack(Items.ANCIENT_DEBRIS, 1)
    ));

    private static final List<ItemStack> lootRare = Collections.unmodifiableList(Arrays.asList(
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
    ));

    private static final List<ItemStack> lootEpique = Collections.unmodifiableList(Arrays.asList(
            new ItemStack(Items.BLAZE_ROD, 16),
            new ItemStack(Items.NETHER_WART, 16),
            new ItemStack(Items.BONE_BLOCK, 32),
            new ItemStack(Items.ECHO_SHARD, 2),
            new ItemStack(Items.SOUL_SAND, 32),
            new ItemStack(Items.SHULKER_SHELL, 4),
            new ItemStack(Items.EVOKER_SPAWN_EGG),
            new ItemStack(Items.GOLDEN_APPLE, 32),
            new ItemStack(Items.SHULKER_BOX, 1),
            new ItemStack(Items.EXPERIENCE_BOTTLE, 32),
            new ItemStack(Items.OMINOUS_BOTTLE, 1),
            new ItemStack(Items.NETHERITE_SCRAP, 3),
            new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1),
            new ItemStack(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, 1),
            new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 1)
    ));

    private static final List<ItemStack> lootLegendaire = Collections.unmodifiableList(Arrays.asList(
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
    ));

    public static ItemStack getRandomItem(int type){
        List<ItemStack> loot = switch (type){
            case 1 -> lootCommun;
            case 2 -> lootRare;
            case 3 -> lootEpique;
            case 4 -> lootLegendaire;
            default -> lootCommun;
        };

        if (!(loot.size() == chances.size())){
            throw new IllegalArgumentException("loot.size doit être égal a chances.size !!");
        }
        BigDecimal rand = BigDecimal.valueOf(Math.random()).multiply(new BigDecimal("100"));
        BigDecimal cumulative = BigDecimal.ZERO;

        for (int i = 0;i < loot.size(); i++){
            cumulative = cumulative.add(chances.get(i));
            if (rand.compareTo(cumulative) <= 0){
                return loot.get(i).copy();
            }
        }
        return loot.get(1).copy();
    }
    public static boolean thematicBox(PlayerEntity player, List<Item> liste){
        ItemStack offHand = player.getOffHandStack();
        if (offHand == null || offHand.equals(new ItemStack(Items.AIR))){
            player.sendMessage(Text.of("Tu dois avoir un bloc décoratif dans ta deuxième main !"), false);
            return false;
        }

        if (!liste.contains(offHand.getItem())){
            player.sendMessage(Text.of("Tu dois avoir un bloc décoratif/redstone dans ta deuxième main !"), false);
            return false;
        }

        ItemStack stack = new ItemStack(offHand.getItem(), 64);

        player.giveItemStack(stack);
        return true;
    }
}
