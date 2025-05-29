package com.thony3ds.effects;

import com.mojang.serialization.MapCodec;
import com.thony3ds.Thony3dsMods;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public record PainEcho() implements EnchantmentEntityEffect {
    public static final RegistryKey<DamageType> PAIN_ECHO_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Thony3dsMods.MOD_ID, "pain_echo"));
    public static final MapCodec<PainEcho> CODEC = MapCodec.unit(PainEcho::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        if (context.owner() != null && context.owner() instanceof PlayerEntity player) {
            float dmg;
            if (level == 1) {
                dmg = player.getMaxHealth() - player.getHealth() / 2.0f;
            }else{
                dmg = 0.0f;
            }

            if (target instanceof LivingEntity victim) {
                if (context.owner() != null && context.owner() instanceof PlayerEntity player) {
                    victim.damage(world, new DamageSource(
                            world.getRegistryManager()
                                    .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                                    .getEntry(PAIN_ECHO_DAMAGE.getValue()).get()
                    ), dmg);
                }
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
