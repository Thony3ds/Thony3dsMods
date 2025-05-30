package com.thony3ds.effects;

import com.mojang.serialization.MapCodec;
import com.thony3ds.Thony3dsMods;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class Thony3dsModsEnchantmentEffects {
    public static final RegistryKey<Enchantment> CURSE_SHULKER = of("curse_of_shulker");
    public static MapCodec<ShulkerEnchantmentEffect> CURSE_SHULKER_EFFECT = register("curse_of_shulker", ShulkerEnchantmentEffect.CODEC);

    public static final RegistryKey<Enchantment> PAIN_ECHO = of("pain_echo");
    public static MapCodec<PainEchoEnchantmentEffect> PAIN_ECHO_EFFECT = register("pain_echo", PainEchoEnchantmentEffect.CODEC);

    private static RegistryKey<Enchantment> of(String path) {
        Identifier id = Identifier.of(Thony3dsMods.MOD_ID, path);
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, id);
    }

    private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String id, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Thony3dsMods.MOD_ID, id), codec);
    }
    public static void bootstrap(Registerable<Enchantment> registerable){
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);
    }

    public static void registerModEnchantmentEffects() {
        Thony3dsMods.LOGGER.info("Registering EnchantmentEffects for" + Thony3dsMods.MOD_ID);
    }
}
