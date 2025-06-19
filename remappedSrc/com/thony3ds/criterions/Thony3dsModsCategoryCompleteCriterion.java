package com.thony3ds.criterions;

import com.mojang.serialization.Codec;
import com.thony3ds.Thony3dsMods;
import com.thony3ds.item.Thony3dsModsItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.*;

public class Thony3dsModsCategoryCompleteCriterion extends AbstractCriterion<Thony3dsModsCategoryCompleteCriterion.Conditions> {

    private static final Identifier ID = Identifier.of(Thony3dsMods.MOD_ID, "category_complete");
    // Liste statique pour stocker les joueurs déjà vérifiés
    private static final Set<UUID> checkedPlayers = new HashSet<>();


    @Override
    public Codec<com.thony3ds.criterions.Thony3dsModsCategoryCompleteCriterion.Conditions> getConditionsCodec() {
        return com.thony3ds.criterions.Thony3dsModsCategoryCompleteCriterion.Conditions.CODEC;
    }

    public void trigger(ServerPlayerEntity player) {
        UUID playerId = player.getUuid();

        // Empêcher les vérifications récursives
        if (checkedPlayers.contains(playerId)) {
            return;
        }

        checkedPlayers.add(playerId); // Ajout du joueur à la liste des vérifiés

        this.trigger(player, conditions -> conditions.matches(player));

        // Nettoyage après l'exécution
        checkedPlayers.remove(playerId);
    }

    public record Conditions(Optional<String> category)
            implements AbstractCriterion.Conditions {

        public static Codec<com.thony3ds.criterions.Thony3dsModsCategoryCompleteCriterion.Conditions> CODEC = Codec.STRING.optionalFieldOf("category", "")
                .xmap(s -> new com.thony3ds.criterions.Thony3dsModsCategoryCompleteCriterion.Conditions(Optional.of(s)), conditions -> conditions.category().orElse(""))
                .codec();

        private static final List<String> ma_liste = List.of("binaire","boots71","codage", "get_car", "get_chocobar", "get_door", "get_pizza",
                "i_eat_it", "lootbox2", "lootbox3", "lootbox4", "speak_frank", "win_xur", "alzheimer", "bottomtale", "chien_de_con", "kill_e", "samba", "satan", "spammeur", "tobyfox", "xur_enchant");

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
            player.getInventory().insertStack(new ItemStack(Thony3dsModsItems.RANDOM_ARMOR_TRIM_SMITHING_TEMPLATE));
            return true; // Tous les succès sont complétés
        }
    }
}

