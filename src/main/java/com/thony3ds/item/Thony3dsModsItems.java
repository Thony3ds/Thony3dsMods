package com.thony3ds.item;

import com.thony3ds.Thony3dsMods;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Thony3dsModsItems {


    public static final Item COIN = register("coin", Item::new, new Item.Settings());
    public static final Item LOOTBOX1 = register("lb1", LootBox1::new, new Item.Settings());
    public static final Item LOOTBOX2 = register("lb2", LootBox2::new, new Item.Settings());
    public static final Item LOOTBOX3 = register("lb3", LootBox3::new, new Item.Settings());
    public static final Item LOOTBOX4 = register("lb4", LootBox4::new, new Item.Settings());
    public static final Item STRANGE_COIN = register("strange_coin", Item::new, new Item.Settings());
    public static final Item REDSTONE_KIT = register("redstone_kit", RedstoneKit::new, new Item.Settings());
    public static final Item BUILD_KIT = register("build_kit", BuildKit::new, new Item.Settings());

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Thony3dsMods.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(LOOTBOX4))
            .displayName(Text.translatable("itemGroup.thony3dsmods"))
            .build();

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings){
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Thony3dsMods.MOD_ID, name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(COIN);
            itemGroup.add(LOOTBOX1);
            itemGroup.add(LOOTBOX2);
            itemGroup.add(LOOTBOX3);
            itemGroup.add(LOOTBOX4);
            itemGroup.add(STRANGE_COIN);
            itemGroup.add(BUILD_KIT);
            itemGroup.add(REDSTONE_KIT);
        });
    }
}
