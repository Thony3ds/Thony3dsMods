package com.thony3ds.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class XpEffect extends StatusEffect {
    protected XpEffect(){
        super(StatusEffectCategory.BENEFICIAL, 0x09ed8a);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        return true;
    }

    public static float getNewXp(float originalXp, int amplifier){
        float multiplier = switch(amplifier){
            case 0 -> 1.5f;
            case 1 -> 1.75f;
            case 2 -> 2f;
            default -> 1.0f;
        };
        return originalXp * multiplier;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier){

        return super.applyUpdateEffect(world, entity, amplifier);
    }
}
