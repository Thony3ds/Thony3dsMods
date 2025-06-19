package com.thony3ds.effects;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record ShulkerEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<ShulkerEnchantmentEffect> CODEC = MapCodec.unit(ShulkerEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        if (target instanceof LivingEntity victim) {
            if (context.owner() != null && context.owner() instanceof PlayerEntity player) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 60, 1));
                victim.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 60, 1));

            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
