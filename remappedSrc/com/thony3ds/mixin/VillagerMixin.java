package com.thony3ds.mixin;

import com.thony3ds.villager.Thony3dsModsVillagers;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.village.VillagerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VillagerEntity.class)
public abstract class VillagerMixin {
    @Inject(method = "setVillagerData", at = @At("HEAD"))
    private void onProfessionChange(VillagerData villagerData, CallbackInfo ci) {
        VillagerEntity villager = (VillagerEntity) (Object) this;

        if (villagerData.getProfession() == Thony3dsModsVillagers.FRANK_MASTER || villagerData.getProfession() == Thony3dsModsVillagers.XUR_MASTER) {
            villager.setInvulnerable(true); // Rend invincible
        }
    }
}
