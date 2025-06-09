package com.thony3ds.mixin;

import com.thony3ds.effects.Thony3dsModsEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class XpBoostMixin {

    private static final ThreadLocal<Boolean> isModifyingXp = ThreadLocal.withInitial(() -> false);

    @Inject(method = "addExperience", at = @At("HEAD"), cancellable = true)
    private void modifyXpGain(int experience, CallbackInfo ci) {
        if (isModifyingXp.get()) return;  // Prevent recursion

        isModifyingXp.set(true);  // Mark start of modification

        PlayerEntity player = (PlayerEntity) (Object) this;
        StatusEffectInstance effect = player.getStatusEffect(Thony3dsModsEffects.XP_POTION);

        if (effect != null) {
            int amplifier = effect.getAmplifier();
            float multiplier = switch (amplifier) {
                case 0 -> 1.5f;
                case 1 -> 1.75f;
                case 2 -> 2.0f;
                default -> 1.0f;
            };

            int modifiedXp = (int) (experience * multiplier);
            player.addExperience(modifiedXp); // Only modify once

            ci.cancel();
        }

        isModifyingXp.set(false);  // Reset flag
    }
}