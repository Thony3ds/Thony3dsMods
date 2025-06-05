package com.thony3ds.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

import java.util.Arrays;
import java.util.List;

public class LootboxLogic {

    private static final double[] chances = {
            23, 10,10,10,10,
            5,5,5,5,5,5,
            2.5,2.5,  1.955, 0.045
    };

    public static ItemStack getRandomItem(List<ItemStack> loot){
        if (loot.size() != chances.length){
            throw new IllegalArgumentException("La liste doit contenir "+ chances.length + " items");
        }

        double total = Arrays.stream(chances).sum();
        double rand = Math.random() * total;
        double cumul = 0;

        for (int i =0; i<loot.size(); i++){
            cumul += chances[i];
            if (rand<=cumul){
                return loot.get(i);
            }
        }

        return loot.getFirst().copy();
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
