package com.thony3ds.item;

import com.thony3ds.Thony3dsMods;
import com.thony3ds.effects.Thony3dsModsEffects;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
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
    public static final Potion XP_POTION2 =
            Registry.register(
                    Registries.POTION,
                    Identifier.of(Thony3dsMods.MOD_ID, "xp_potion2"),
                    new Potion("xp_potion2",
                            new StatusEffectInstance(
                                    Thony3dsModsEffects.XP_POTION,
                                    9600,
                                    1
                            ))
            );
    public static final Potion XP_POTION3 =
            Registry.register(
                    Registries.POTION,
                    Identifier.of(Thony3dsMods.MOD_ID, "xp_potion3"),
                    new Potion("xp_potion3",
                            new StatusEffectInstance(
                                    Thony3dsModsEffects.XP_POTION,
                                    9600,
                                    2
                            ))
            );

    public static ItemStack getXpPotionItemStack(int amplifier){
        Potion MY_POTION = switch (amplifier){
            case 1 -> XP_POTION2;
            case 2 -> XP_POTION3;
            default -> XP_POTION;
        };
        ItemStack stack = new ItemStack(PotionItem.byRawId(Registries.POTION.getRawId(MY_POTION)));
        return stack;
    }

    public static void initialize(){
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.STRONG_TURTLE_MASTER,
                    Thony3dsModsItems.PIZZA,
                    Registries.POTION.getEntry(XP_POTION)
            );
        });
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Registries.POTION.getEntry(XP_POTION),
                    Thony3dsModsItems.COIN,
                    Registries.POTION.getEntry(XP_POTION2)
            );
        });
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Registries.POTION.getEntry(XP_POTION2),
                    Thony3dsModsItems.VOITURE,
                    Registries.POTION.getEntry(XP_POTION3)
            );
        });

    }
}
