package com.thony3ds.criterions;

import com.mojang.serialization.Codec;
import com.thony3ds.Thony3dsMods;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class Thony3dsModsOnJoinCriterion extends AbstractCriterion<Thony3dsModsOnJoinCriterion.Conditions> {

    private static final Identifier ID = Identifier.of(Thony3dsMods.MOD_ID, "player_join");

    @Override
    public Codec<com.thony3ds.criterions.Thony3dsModsOnJoinCriterion.Conditions> getConditionsCodec() {
        return com.thony3ds.criterions.Thony3dsModsOnJoinCriterion.Conditions.CODEC;
    }

    public void trigger(ServerPlayerEntity player) {
        this.trigger(player, conditions -> true);
    }

    public record Conditions(Optional<LootContextPredicate> playerPredicate) implements AbstractCriterion.Conditions {
        public static Codec<com.thony3ds.criterions.Thony3dsModsOnJoinCriterion.Conditions> CODEC = LootContextPredicate.CODEC.optionalFieldOf("player")
                .xmap(com.thony3ds.criterions.Thony3dsModsOnJoinCriterion.Conditions::new, com.thony3ds.criterions.Thony3dsModsOnJoinCriterion.Conditions::player).codec();

        @Override
        public Optional<LootContextPredicate> player() {
            return playerPredicate;
        }
    }
}
