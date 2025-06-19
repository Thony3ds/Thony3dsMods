package com.thony3ds.datagen;

import com.thony3ds.Thony3dsMods;
import com.thony3ds.criterions.Thony3dsModsCategoryCompleteCriterion;
import com.thony3ds.criterions.Thony3dsModsCriteria;
import com.thony3ds.criterions.Thony3dsModsOnJoinCriterion;
import com.thony3ds.item.Thony3dsModsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
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
                        Identifier.of(Thony3dsMods.MOD_ID, "textures/gui/team_pizza.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
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
                        Text.literal("Vous voulez savoir comment vendre votre voiture ?"), // The description
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
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
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
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
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("getChocobar", InventoryChangedCriterion.Conditions.items(Thony3dsModsItems.CHOCOBAR))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":get_chocobar");
        AdvancementEntry getPizza = Advancement.Builder.create()
                .parent(speakFrank) //Depends de getDirt
                .display(
                        Thony3dsModsItems.PIZZA, // The display icon
                        Text.literal("Pizza !"), // The title
                        Text.literal("Pizza !"), // The description
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("getPizza", InventoryChangedCriterion.Conditions.items(Thony3dsModsItems.PIZZA))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":get_pizza");
        AdvancementEntry getCar = Advancement.Builder.create()
                .parent(speakFrank) //Depends de getDirt
                .display(
                        Thony3dsModsItems.VOITURE, // The display icon
                        Text.literal("Vendez votre voiture.fr !"), // The title
                        Text.literal("On paye bien... pour votre voiture !!"), // The description
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.CHALLENGE, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("getCar", InventoryChangedCriterion.Conditions.items(Thony3dsModsItems.VOITURE))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":get_car");
        AdvancementEntry iEatIt = Advancement.Builder.create()
                .parent(speakFrank) //Depends de getDirt
                .display(
                        Items.CAKE, // The display icon
                        Text.literal("Pourquoi la petite fille tombe t'elle de la balançoire ?"), // The title
                        Text.literal("Je l'ai mangé !!!!!!!!"), // The description
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
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
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.CHALLENGE, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("getDoor", InventoryChangedCriterion.Conditions.items(Items.IRON_DOOR))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":get_door");

        AdvancementEntry binaire = Advancement.Builder.create()
                .parent(speakFrank) //Depends de getDirt
                .display(
                        Items.LEVER, // The display icon
                        Text.literal("01000010 01101001 01101110 01100001 01110010 01111001"), // The title
                        Text.literal("01000010 01100101 01110011 01110100 00100000 01010000 01110010 01101111 01100110 00100001"), // The description
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("getLever", InventoryChangedCriterion.Conditions.items(Items.LEVER))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":binaire");

        AdvancementEntry codage = Advancement.Builder.create()
                .parent(binaire) //Depends de getDirt
                .display(
                        Items.REDSTONE, // The display icon
                        Text.literal("Mais c'est du codage !!"), // The title
                        Text.literal("(Prof de con...)"), // The description
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.CHALLENGE, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("getRedstone", InventoryChangedCriterion.Conditions.items(Items.REDSTONE))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":codage");

        AdvancementEntry lootBox2 = Advancement.Builder.create()
                .parent(speakFrank) //Depends de getDirt
                .display(
                        Thony3dsModsItems.LOOTBOX2, // The display icon
                        Text.literal("Le début!"), // The title
                        Text.literal("Les récompenses ne font que commencer"), // The description
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("getLootbox", InventoryChangedCriterion.Conditions.items(Thony3dsModsItems.LOOTBOX2))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":lootbox2");

        AdvancementEntry lootBox3 = Advancement.Builder.create()
                .parent(lootBox2) //Depends de getDirt
                .display(
                        Thony3dsModsItems.LOOTBOX3, // The display icon
                        Text.literal("On ce met bien !"), // The title
                        Text.literal("En même temps la flemme du Nether !"), // The description
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("getLootbox", InventoryChangedCriterion.Conditions.items(Thony3dsModsItems.LOOTBOX3))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":lootbox3");

        AdvancementEntry lootBox4 = Advancement.Builder.create()
                .parent(lootBox3) //Depends de getDirt
                .display(
                        Thony3dsModsItems.LOOTBOX4, // The display icon
                        Text.literal("Les loots ultimes !"), // The title
                        Text.literal("Tu savais que c'était les plus rares du jeu ?!"), // The description
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.CHALLENGE, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("getLootbox", InventoryChangedCriterion.Conditions.items(Thony3dsModsItems.LOOTBOX4))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":lootbox4");

        AdvancementEntry boots71 = Advancement.Builder.create()
                .parent(speakFrank) //Depends de getDirt
                .display(
                        Items.IRON_BOOTS,
                        Text.literal("71 Bottes !!"), // The title
                        Text.literal("Alors que juste des lingots c'était suffisant !"), // The description
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("getCheckNuggets", InventoryChangedCriterion.Conditions.items(Items.IRON_NUGGET))
                .criterion("getCheckBoots", InventoryChangedCriterion.Conditions.items(Items.IRON_BOOTS))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":boots71");

        AdvancementEntry randomMaster = Advancement.Builder.create()
                .parent(teamPizza) //Depends de getDirt
                .display(
                        Thony3dsModsItems.RANDOM_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Text.literal("Random Master"), // The title
                        Text.literal("Le summum de la randomitude !"), // The description
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.GOAL, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("getRandomMaster", Thony3dsModsCriteria.CATEGORY_COMPLETE.create(new Thony3dsModsCategoryCompleteCriterion.Conditions(Optional.empty())))
                // Give the advancement an id
                .build(consumer, Thony3dsMods.MOD_ID + ":random_master");
    }
}
