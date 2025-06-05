package com.thony3ds.datagen;

import com.thony3ds.Thony3dsMods;
import com.thony3ds.block.Thony3dsModsBlocks;
import com.thony3ds.item.Thony3dsModsItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Thony3dsModsItemGroup {
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Thony3dsMods.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Thony3dsModsItems.LOOTBOX4))
            .displayName(Text.translatable("itemGroup.thony3dsmods"))
            .build();

    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(Thony3dsModsItems.COIN);
            itemGroup.add(Thony3dsModsItems.LOOTBOX1);
            itemGroup.add(Thony3dsModsItems.LOOTBOX2);
            itemGroup.add(Thony3dsModsItems.LOOTBOX3);
            itemGroup.add(Thony3dsModsItems.LOOTBOX4);
            itemGroup.add(Thony3dsModsItems.STRANGE_COIN);
            itemGroup.add(Thony3dsModsItems.BUILD_KIT);
            itemGroup.add(Thony3dsModsItems.REDSTONE_KIT);
            itemGroup.add(Thony3dsModsBlocks.FRANK_WORKBENCH);
            itemGroup.add(Thony3dsModsBlocks.ETERNITY_TRIALS_PORTAL_BLOCK);
            itemGroup.add(Thony3dsModsBlocks.XUR_WORKBENCH);
            itemGroup.add(Thony3dsModsBlocks.VILLAGER_SHOP_BLOCK);
            itemGroup.add(Thony3dsModsItems.CHOCOBAR);
            itemGroup.add(Thony3dsModsItems.PIZZA);
            itemGroup.add(Thony3dsModsItems.CEREALE_BAR);
            itemGroup.add(Thony3dsModsItems.VOITURE);
            itemGroup.add(Thony3dsModsItems.RANDOM_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemGroup.add(Thony3dsModsItems.APPELLE_SUR_MON_TELEPHONE_MUSIC_DISK);
            itemGroup.add(Thony3dsModsItems.POLISH_COW_MUSIC_DISK);
            itemGroup.add(Thony3dsModsItems.DONT_STOP_THE_FASCISM_MUSIC_DISK);
        });
    }
}
