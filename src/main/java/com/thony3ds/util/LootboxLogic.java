package com.thony3ds.util;

import com.thony3ds.Thony3dsMods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

import java.util.List;
import java.util.Random;
import java.math.BigDecimal;

public class LootboxLogic {

    private static final BigDecimal[] chances = {
            new BigDecimal("23"),
            new BigDecimal("10"), new BigDecimal("10"), new BigDecimal("10"), new BigDecimal("10"),
            new BigDecimal("5"), new BigDecimal("5"), new BigDecimal("5"), new BigDecimal("5"), new BigDecimal("5"), new BigDecimal("5"),
            new BigDecimal("2.5"), new BigDecimal("2.5"),
            new BigDecimal("1.955"), new BigDecimal("0.045")
    };


    public static ItemStack getRandomItem(List<ItemStack> loot){
        if (loot == null || loot.size() != chances.length) {
            throw new IllegalArgumentException("La liste doit contenir exactement " + chances.length + " éléments.");
        }

        // Calcul du poids total avec BigDecimal
        BigDecimal totalWeight = BigDecimal.ZERO;
        for (BigDecimal chance : chances) {
            totalWeight = totalWeight.add(chance);
        }

        // Génération d'une valeur aléatoire sur la plage du totalWeight
        Random random = new Random();
        BigDecimal randomValue = BigDecimal.valueOf(random.nextDouble()).multiply(totalWeight);

        BigDecimal cumulativeWeight = BigDecimal.ZERO;
        ItemStack selectedItem = loot.get(0); // Valeur par défaut

        // Sélection de l'objet basé sur les probabilités corrigées
        for (int i = 0; i < chances.length; i++) {
            cumulativeWeight = cumulativeWeight.add(chances[i]);
            if (randomValue.compareTo(cumulativeWeight) <= 0) {
                selectedItem = loot.get(i);
                break;
            }
        }

        if (selectedItem.isEmpty() || selectedItem.isOf(Items.AIR) || selectedItem.equals(new ItemStack(Items.AIR))){
            selectedItem = loot.get(4);
        }

        return selectedItem;
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
