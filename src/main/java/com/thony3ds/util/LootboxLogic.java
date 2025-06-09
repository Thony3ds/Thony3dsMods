package com.thony3ds.util;

import com.thony3ds.item.Thony3dsModsItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

import java.util.ArrayList;
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

    public static List<Item> redstoneItems = new ArrayList<>(List.of(
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
    ));
    public static List<Item> decorationItems = new ArrayList<>(List.of(
            new ItemStack(Items.STONE).getItem(),
            new ItemStack(Items.GRANITE).getItem(),
            new ItemStack(Items.DIORITE).getItem(),
            new ItemStack(Items.ANDESITE).getItem(),
            new ItemStack(Items.COBBLESTONE).getItem(),
            new ItemStack(Items.BRICKS).getItem(),
            new ItemStack(Items.STONE_BRICKS).getItem(),
            new ItemStack(Items.MOSSY_STONE_BRICKS).getItem(),
            new ItemStack(Items.SMOOTH_STONE).getItem(),
            new ItemStack(Items.SMOOTH_SANDSTONE).getItem(),
            new ItemStack(Items.SMOOTH_QUARTZ).getItem(),
            new ItemStack(Items.POLISHED_GRANITE).getItem(),
            new ItemStack(Items.POLISHED_DIORITE).getItem(),
            new ItemStack(Items.POLISHED_ANDESITE).getItem(),
            new ItemStack(Items.WHITE_TERRACOTTA).getItem(),
            new ItemStack(Items.ORANGE_TERRACOTTA).getItem(),
            new ItemStack(Items.MAGENTA_TERRACOTTA).getItem(),
            new ItemStack(Items.LIGHT_BLUE_TERRACOTTA).getItem(),
            new ItemStack(Items.YELLOW_TERRACOTTA).getItem(),
            new ItemStack(Items.LIME_TERRACOTTA).getItem(),
            new ItemStack(Items.PINK_TERRACOTTA).getItem(),
            new ItemStack(Items.GRAY_TERRACOTTA).getItem(),
            new ItemStack(Items.LIGHT_GRAY_TERRACOTTA).getItem(),
            new ItemStack(Items.CYAN_TERRACOTTA).getItem(),
            new ItemStack(Items.PURPLE_TERRACOTTA).getItem(),
            new ItemStack(Items.BLUE_TERRACOTTA).getItem(),
            new ItemStack(Items.BROWN_TERRACOTTA).getItem(),
            new ItemStack(Items.GREEN_TERRACOTTA).getItem(),
            new ItemStack(Items.RED_TERRACOTTA).getItem(),
            new ItemStack(Items.BLACK_TERRACOTTA).getItem(),
            new ItemStack(Items.GLOWSTONE).getItem(),
            new ItemStack(Items.SEA_LANTERN).getItem(),
            new ItemStack(Items.LANTERN).getItem(),
            new ItemStack(Items.SOUL_LANTERN).getItem(),
            new ItemStack(Items.PAINTING).getItem(),
            new ItemStack(Items.FLOWER_POT).getItem(),
            new ItemStack(Items.BOOKSHELF).getItem(),
            new ItemStack(Items.CHISELED_BOOKSHELF).getItem(),
            new ItemStack(Items.TORCH).getItem(),
            new ItemStack(Items.SOUL_TORCH).getItem(),
            new ItemStack(Items.CANDLE).getItem(),
            new ItemStack(Items.WHITE_CANDLE).getItem(),
            new ItemStack(Items.YELLOW_CANDLE).getItem(),
            new ItemStack(Items.BLUE_CANDLE).getItem(),
            new ItemStack(Items.PURPLE_CANDLE).getItem(),
            new ItemStack(Items.RED_CANDLE).getItem(),
            new ItemStack(Items.GREEN_CANDLE).getItem(),
            new ItemStack(Items.BLACK_CANDLE).getItem(),
            new ItemStack(Items.LECTERN).getItem(),
            new ItemStack(Items.BELL).getItem(),
            new ItemStack(Items.BARREL).getItem(),
            new ItemStack(Items.CHEST).getItem(),
            new ItemStack(Items.CAMPFIRE).getItem(),
            new ItemStack(Items.SOUL_CAMPFIRE).getItem(),
            new ItemStack(Items.STONECUTTER).getItem(),
            new ItemStack(Items.ANVIL).getItem(),
            new ItemStack(Items.FLOWER_POT).getItem(),
            new ItemStack(Items.WHITE_BANNER).getItem(),
            new ItemStack(Items.END_ROD).getItem(),
            new ItemStack(Items.IRON_BARS).getItem(),
            new ItemStack(Items.LADDER).getItem()
    ));

    public static ItemStack getRandomItem(int type){
        List<ItemStack> loot = switch (type){
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
    public static boolean thematicBox(PlayerEntity player, int type){
        List<Item> liste = switch (type){
            case 1 -> redstoneItems;
            case 2 -> decorationItems;
            default -> List.of(Items.CAKE);
        };

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
