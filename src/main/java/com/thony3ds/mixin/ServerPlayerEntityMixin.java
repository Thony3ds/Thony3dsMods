package com.thony3ds.mixin;

import com.thony3ds.criterions.Thony3dsModsCategoryCompleteCriterion;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {

    @Inject(method = "getAdvancementTracker", at = @At("RETURN"))
    private void onAdvancementTrackerReturn(CallbackInfoReturnable<PlayerAdvancementTracker> cir) {
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

       Thony3dsModsCategoryCompleteCriterion.trigger(player);
    }
}

