package com.thony3ds.criterions;

import com.mojang.serialization.Codec;
import com.thony3ds.Thony3dsMods;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Thony3dsModsCategoryCompleteCriterion extends AbstractCriterion<Thony3dsModsCategoryCompleteCriterion.Conditions> {

    private static final Identifier ID = Identifier.of(Thony3dsMods.MOD_ID, "category_complete");

    @Override
    public Codec<Conditions> getConditionsCodec() {
        return Conditions.CODEC;
    }

    public static void trigger(ServerPlayerEntity player) {
        this.trigger(player, conditions -> conditions.matches(player));
    }

    public record Conditions(Optional<String> category)
            implements AbstractCriterion.Conditions {

        public static Codec<Conditions> CODEC = Codec.STRING.optionalFieldOf("category", "")
                .xmap(s -> new Conditions(Optional.of(s)), conditions -> conditions.category().orElse(""))
                .codec();

        private static final List<String> ma_liste = List.of("satan","xur_enchant");

        @Override
        public Optional<LootContextPredicate> player() {
            return Optional.empty();
        }

        boolean matches(ServerPlayerEntity player) {
            for (String advancement_name : ma_liste) {
                AdvancementEntry advancement = Objects.requireNonNull(player.getServer()).getAdvancementLoader().get(Identifier.of(Thony3dsMods.MOD_ID, advancement_name));
                AdvancementProgress progress = player.getAdvancementTracker().getProgress(advancement);
                if (!progress.isDone()) {
                    return false; // Un succès n'est pas terminé
                }
            }
            return true; // Tous les succès sont complétés
        }
    }
}

