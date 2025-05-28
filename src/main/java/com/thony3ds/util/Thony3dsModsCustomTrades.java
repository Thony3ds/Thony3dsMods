package com.thony3ds.util;

import com.thony3ds.villager.Thony3dsModsVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;

public class Thony3dsModsCustomTrades {
    public static void registerCustomTrades(){
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.FRANK_MASTER, 1,
                factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 32),
                    new ItemStack(Items.MACE),
                    999, 1, 0.0f));
                });
    }
}
