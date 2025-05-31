package com.thony3ds.datagen;

import com.thony3ds.Thony3dsMods;
import com.thony3ds.criterions.Thony3dsModsCriteria;
import com.thony3ds.criterions.Thony3dsModsOnJoinCriterion;
import com.thony3ds.item.Thony3dsModsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.ChangedDimensionCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class Thony3dsModsAdvancementProvider extends FabricAdvancementProvider {
    protected Thony3dsModsAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup){
        super(output, registryLookup);
    }
    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {

        AdvancementEntry teamPizza = Advancement.Builder.create()
                .display(
                        Thony3dsModsItems.CHOCOBAR, // The display icon
                        Text.literal("Team Pizza"), // The title
                        Text.literal("Bienvenue jeune tryharder !"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("joinTeamPizza", Thony3dsModsCriteria.JOIN_GAME.create(new Thony3dsModsOnJoinCriterion.Conditions(Optional.empty())))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":team_pizza");

        AdvancementEntry speakFrank = Advancement.Builder.create()
                .parent(teamPizza) //Depends de getDirt
                .display(
                        Thony3dsModsItems.COIN, // The display icon
                        Text.literal("Salut c'est Frank Leboeuf !"), // The title
                        Text.literal("Vous voulez savoir comme vendre votre voiture ?"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("speakFrank", InventoryChangedCriterion.Conditions.items(Thony3dsModsItems.LOOTBOX1))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":speak_frank");

        AdvancementEntry winXur = Advancement.Builder.create()
                .parent(speakFrank) //Depends de getDirt
                .display(
                        Thony3dsModsItems.STRANGE_COIN, // The display icon
                        Text.literal("A bientôt dans les Défis d'Eternitée !"), // The title
                        Text.literal("Xur et le mythique Cheval Stélaire attendrons votre retour avec impatience !"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("winXur", InventoryChangedCriterion.Conditions.items(Thony3dsModsItems.STRANGE_COIN))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":win_xur");

        AdvancementEntry getChocobar = Advancement.Builder.create()
                .parent(speakFrank) //Depends de getDirt
                .display(
                        Thony3dsModsItems.CHOCOBAR, // The display icon
                        Text.literal("Je suis CHOCOBAR !!"), // The title
                        Text.literal(":O"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("getChocobar", InventoryChangedCriterion.Conditions.items(Thony3dsModsItems.CHOCOBAR))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":get_chocobar");
        AdvancementEntry iEatIt = Advancement.Builder.create()
                .parent(speakFrank) //Depends de getDirt
                .display(
                        Items.CAKE, // The display icon
                        Text.literal("Pourquoi la petite fille tombe t'elle de la balançoire ?"), // The title
                        Text.literal("Je l'ai mangé !!!!!!!!"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("iEatIt", ConsumeItemCriterion.Conditions.any())
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":i_eat_it");
        AdvancementEntry iAmTheDoor = Advancement.Builder.create()
                .parent(speakFrank) //Depends de getDirt
                .display(
                        Items.IRON_DOOR, // The display icon
                        Text.literal("JE SUIS LA PORTE !!"), // The title
                        Text.literal("Mais non Walter tu es toi même !"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.CHALLENGE, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("getDoor", InventoryChangedCriterion.Conditions.items(Items.IRON_DOOR))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":get_door");
    }
}
