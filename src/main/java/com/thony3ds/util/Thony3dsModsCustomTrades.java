package com.thony3ds.util;

import com.thony3ds.item.Thony3dsModsItems;
import com.thony3ds.villager.Thony3dsModsVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;

import java.util.Optional;

public class Thony3dsModsCustomTrades {
    public static void registerCustomTrades(){
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.FRANK_MASTER, 1,
                factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.IRON_INGOT, 15),
                    new ItemStack(Thony3dsModsItems.LOOTBOX1),
                    9999, 1, 0.0f));
                });
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.FRANK_MASTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.QUARTZ, 5),
                            Optional.of(new TradedItem(Items.DIAMOND, 1)),
                            new ItemStack(Thony3dsModsItems.COIN),
                            9999, 1, 0.0f));
                });
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.FRANK_MASTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Thony3dsModsItems.COIN, 2),
                            new ItemStack(Thony3dsModsItems.LOOTBOX2),
                            9999, 2, 0.0f));
                });
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.FRANK_MASTER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.ENDER_PEARL, 2),
                            Optional.of(new TradedItem(Items.AMETHYST_SHARD, 5)),
                            new ItemStack(Thony3dsModsItems.COIN, 3),
                            9999, 2, 0.0f));
                });
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.FRANK_MASTER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Thony3dsModsItems.COIN, 10),
                            new ItemStack(Thony3dsModsItems.LOOTBOX3),
                            9999, 3, 0.0f));
                });
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.FRANK_MASTER, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.OBSIDIAN, 10),
                            Optional.of(new TradedItem(Items.CAKE, 1)), //TODO Chocobar
                            new ItemStack(Thony3dsModsItems.COIN, 5),
                            9999, 2, 0.0f));
                });
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.FRANK_MASTER, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Thony3dsModsItems.COIN, 32),
                            new ItemStack(Thony3dsModsItems.LOOTBOX4),
                            9999, 3, 0.0f));
                });
        //TODO Trade Voiture Succes
    }
}
