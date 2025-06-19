package com.thony3ds.mixin;

import com.thony3ds.commands.ModFacile;
import com.thony3ds.criterions.Thony3dsModsCategoryCompleteCriterion;
import com.thony3ds.criterions.Thony3dsModsCriteria;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;


@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {

    @Inject(method = "getAdvancementTracker", at = @At("RETURN"))
    private void onAdvancementTrackerReturn(CallbackInfoReturnable<PlayerAdvancementTracker> cir) {
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

       Thony3dsModsCriteria.CATEGORY_COMPLETE.trigger(player);
    }
    @Inject(method="onStatusEffectsRemoved", at=@At("TAIL"))
    private void refreshEasyPlayers(Collection<StatusEffectInstance> effects, CallbackInfo ci){
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
        if (ModFacile.getEasy_players().contains(player.getUuid())){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 320, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 320));
        }
    }
}

