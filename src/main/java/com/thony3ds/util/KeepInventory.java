package com.thony3ds.util;

import com.thony3ds.commands.ModFacile;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.collection.DefaultedList;

import java.util.HashMap;
import java.util.UUID;

public class KeepInventory {
    private static final HashMap<UUID, DefaultedList<ItemStack>> savedInventory= new HashMap<>();

    public static void onPlayerDeath(ServerPlayerEntity player, DamageSource source){
        if (source == player.getDamageSources().outOfWorld() || ModFacile.getEasy_players().contains(player.getUuid())){
            DefaultedList<ItemStack> invCopy = DefaultedList.ofSize(player.getInventory().size(), ItemStack.EMPTY);
            for (int i =0; i<player.getInventory().size(); i++){
                invCopy.set(i, player.getInventory().getStack(i).copy());
            }
            savedInventory.put(player.getUuid(), invCopy);
        }
    }

    public static void initializePlayerRespawn(){
        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
            UUID playerUUID = newPlayer.getUuid();
            if (savedInventory.containsKey(playerUUID)){
                DefaultedList<ItemStack> restoredInv = savedInventory.get(playerUUID);
                newPlayer.getInventory().clear();
                for (int i =0; i<restoredInv.size(); i++){
                    newPlayer.getInventory().setStack(i, restoredInv.get(i));
                }
                savedInventory.remove(playerUUID);
            }
        });
    }
}
