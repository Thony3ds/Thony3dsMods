package com.thony3ds.block;

import com.thony3ds.Thony3dsMods;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Thony3dsModsBlocks {

    public static final Block FRANK_WORKBENCH = register(
            "frank_workbench.json",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.ANVIL),
            true
    );
    public static final Block ETERNITY_TRIALS_PORTAL_BLOCK = register(
            "eternity_trial_portal_block",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.TRIAL_SPAWNER),
            true
    );

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem){
        RegistryKey<Block> blockKey = keyOfBlock(name);

        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem){
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name){
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Thony3dsMods.MOD_ID, name));
    }
    private static RegistryKey<Item> keyOfItem(String name){
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Thony3dsMods.MOD_ID, name));
    }

    public static void initialize(){}
}
