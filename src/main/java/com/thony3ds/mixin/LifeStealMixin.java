package com.thony3ds.mixin;

import com.thony3ds.Thony3dsMods;
import com.thony3ds.util.KeepInventory;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class LifeStealMixin {
    @Inject(method="onDeath", at= @At("TAIL"))
    public void onPlayerDeath(DamageSource source, CallbackInfo ci){
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
        if (!(player.getWorld().getRegistryKey().toString().contains("thony3dsmods:eternity_trials")) && player.getAttributeInstance(EntityAttributes.MAX_HEALTH).getBaseValue() > 10) {
            if (source.getAttacker() instanceof PlayerEntity attacker) {
                System.out.println("Player: "+player.getAttributeInstance(EntityAttributes.MAX_HEALTH).getBaseValue() + "\nAttacker: "+ attacker.getAttributeInstance(EntityAttributes.MAX_HEALTH).getBaseValue());
                player.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(player.getMaxHealth() - 2);
                attacker.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(attacker.getMaxHealth() + 2);
                if (attacker.getAttributeInstance(EntityAttributes.MAX_HEALTH).getBaseValue() > 40) {
                    attacker.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(40);
                }
                System.out.println("Player: "+player.getAttributeInstance(EntityAttributes.MAX_HEALTH).getBaseValue() + "\nAttacker: "+ attacker.getAttributeInstance(EntityAttributes.MAX_HEALTH).getBaseValue());
            } else {
                player.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(player.getMaxHealth() - 1);
            }
            if (player.getAttributeInstance(EntityAttributes.MAX_HEALTH).getBaseValue() < 10){
                player.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(10);
            }
        }
    }

    @Inject(method="onDeath", at=@At("HEAD"))
    public void keepInventoryOnVoidDeath(DamageSource source, CallbackInfo ci){
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
        KeepInventory.onPlayerDeath(player, source);
    }
}
