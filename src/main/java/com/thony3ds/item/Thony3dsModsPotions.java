package com.thony3ds.item;

import com.thony3ds.Thony3dsMods;
import com.thony3ds.effects.Thony3dsModsEffects;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Thony3dsModsPotions {

    public static final Potion XP_POTION =
            Registry.register(
                    Registries.POTION,
                    Identifier.of(Thony3dsMods.MOD_ID, "xp_potion"),
                    new Potion("xp_potion",
                            new StatusEffectInstance(
                                    Thony3dsModsEffects.XP_POTION,
                                    9600,
                                    0
                            ))
            );

    public static void initialize(){
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.STRONG_TURTLE_MASTER,
                    Thony3dsModsItems.PIZZA,
                    Registries.POTION.getEntry(XP_POTION)
            );
        });
    }
}
