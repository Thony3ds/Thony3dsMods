package com.thony3ds.util;

import com.google.common.collect.ImmutableMap;
import com.thony3ds.Thony3dsMods;
import com.thony3ds.datagen.Thony3dsModsEnchantmentGenerator;
import com.thony3ds.effects.PainEchoEnchantmentEffect;
import com.thony3ds.effects.Thony3dsModsEnchantmentEffects;
import com.thony3ds.item.Thony3dsModsItems;
import com.thony3ds.villager.Thony3dsModsVillagers;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Thony3dsModsCustomTrades {
    public static void registerCustomTrades(){
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.FRANK_MASTER, 1,
                factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.IRON_INGOT, 16),
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
                            Optional.of(new TradedItem(Thony3dsModsItems.CHOCOBAR, 1)),
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
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.XUR_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Thony3dsModsItems.STRANGE_COIN, 1),
                            new ItemStack(Thony3dsModsItems.BUILD_KIT, 4),
                            9999, 3, 0.0f));
                });
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.XUR_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Thony3dsModsItems.STRANGE_COIN, 1),
                            new ItemStack(Thony3dsModsItems.REDSTONE_KIT, 4),
                            9999, 3, 0.0f));
                });
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.XUR_MASTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Thony3dsModsItems.STRANGE_COIN, 1),
                            new ItemStack(Thony3dsModsItems.BUILD_KIT, 8),
                            9999, 3, 0.0f));
                });
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.XUR_MASTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Thony3dsModsItems.STRANGE_COIN, 1),
                            new ItemStack(Thony3dsModsItems.REDSTONE_KIT, 8),
                            9999, 3, 0.0f));
                });
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.XUR_MASTER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Thony3dsModsItems.STRANGE_COIN, 1),
                            new ItemStack(Thony3dsModsItems.BUILD_KIT, 16),
                            9999, 3, 0.0f));
                });
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.XUR_MASTER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Thony3dsModsItems.STRANGE_COIN, 1),
                            new ItemStack(Thony3dsModsItems.REDSTONE_KIT, 16),
                            9999, 3, 0.0f));
                });
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.XUR_MASTER, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Thony3dsModsItems.STRANGE_COIN, 1),
                            new ItemStack(Thony3dsModsItems.BUILD_KIT, 32),
                            9999, 3, 0.0f));
                });
        TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.XUR_MASTER, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Thony3dsModsItems.STRANGE_COIN, 1),
                            new ItemStack(Thony3dsModsItems.REDSTONE_KIT, 32),
                            9999, 3, 0.0f));
                });
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            RegistryEntry<Enchantment> enchantmentEntry =
                    RegistryEntry.of(server.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT).get(Identifier.of(Thony3dsMods.MOD_ID, "pain_echo")));
            ItemStack painEcho = new ItemStack(Items.ENCHANTED_BOOK);
            painEcho.addEnchantment(enchantmentEntry, 1);

            TradeOfferHelper.registerVillagerOffers(Thony3dsModsVillagers.XUR_MASTER, 5,
                    factories -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Thony3dsModsItems.STRANGE_COIN, 5),
                                painEcho,
                                9999, 3, 0.0f));
                    });
        });
        //TODO Trade Voiture Succes
    }
}
