package com.thony3ds.mixin;

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
    @Inject(method="onDeath", at= @At("HEAD"))
    public void onPlayerDeath(DamageSource source, CallbackInfo ci){
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
        if (player.getAttributeInstance(EntityAttributes.MAX_HEALTH).getBaseValue() > 10 && !player.getWorld().getRegistryKey().toString().equals("eternity_trials")) {
            int amount;
            if ((int) player.getAttributeInstance(EntityAttributes.MAX_HEALTH).getBaseValue() == 11) {
                amount = 1;
            } else {
                amount = 2;
            }
            if (source.getAttacker() instanceof PlayerEntity attacker) {
                player.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(player.getMaxHealth() - amount);
                attacker.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(player.getMaxHealth() + amount);
                if (attacker.getAttributeInstance(EntityAttributes.MAX_HEALTH).getBaseValue() > 40){
                    attacker.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(40);
                }
            } else {
                player.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(player.getMaxHealth() - amount);
            }
        }
    }
}
