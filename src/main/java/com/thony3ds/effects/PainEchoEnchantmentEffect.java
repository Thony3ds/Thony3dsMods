package com.thony3ds.effects;

import com.mojang.serialization.MapCodec;
import com.thony3ds.Thony3dsMods;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public record PainEchoEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<PainEchoEnchantmentEffect> CODEC = MapCodec.unit(PainEchoEnchantmentEffect::new);
    public static final RegistryKey<DamageType> PAIN_ECHO_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Thony3dsMods.MOD_ID, "pain_echo_damage"));

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        if (context.owner() != null && context.owner() instanceof PlayerEntity player) {
            float dmg = (float) Math.floor((player.getMaxHealth() - player.getHealth()) / 2.0f);
            if (dmg >= 20){
                dmg = 18;
            }
            if (target instanceof LivingEntity victim){
                victim.damage(world, new DamageSource(
                        world.getRegistryManager()
                                .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                                .getEntry(PAIN_ECHO_DAMAGE.getValue()).orElseThrow()
                ), dmg);

                ItemStack mainHandItem = player.getMainHandStack();

                if (EnchantmentHelper.getLevel(world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT), mainHandItem) > 0){
                    // Obtenir le composant d'enchantements
                    ItemEnchantmentsComponent.Builder enchantmentBuilder = new ItemEnchantmentsComponent.Builder(mainHandItem.getEnchantments());
                    enchantmentBuilder.remove(entry -> entry.value().equals(world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT).get(Identifier.ofVanilla("fire_aspect"))));
                    EnchantmentHelper.set(mainHandItem, enchantmentBuilder.build());
                    victim.setOnFire(false);
                }

            if (level == 2){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 30, 0, false, false));
            }else if (level == 3){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 1, false, false));
                if (mainHandItem.isDamageable()) { // Vérifie si l'item a une durabilité
                    mainHandItem.damage(1, player); // Ajoute des points d'usure
                }
            }
        }
    }
}

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
