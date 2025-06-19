package com.thony3ds.villager;

import com.google.common.collect.ImmutableSet;
import com.thony3ds.Thony3dsMods;
import com.thony3ds.block.Thony3dsModsBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class Thony3dsModsVillagers {

    public static final RegistryKey<PointOfInterestType> FRANK_POI_KEY = poiKey("frankpoi");
    public static final PointOfInterestType FRANK_POI = registerPoi("frankpoi", Thony3dsModsBlocks.FRANK_WORKBENCH);

    public static final VillagerProfession FRANK_MASTER = registerProfession("frank_master", FRANK_POI_KEY);

    public static final RegistryKey<PointOfInterestType> XUR_POI_KEY = poiKey("xurpoi");
    public static final PointOfInterestType XUR_POI = registerPoi("xurpoi", Thony3dsModsBlocks.XUR_WORKBENCH);

    public static final VillagerProfession XUR_MASTER = registerProfession("xur_master", XUR_POI_KEY);


    private  static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type){
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(Thony3dsMods.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type),
                        entry -> entry.matchesKey(type), ImmutableSet.of(),
                        ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_CARTOGRAPHER));
    }

    private static PointOfInterestType registerPoi(String name, Block block){
        return PointOfInterestHelper.register(Identifier.of(Thony3dsMods.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(Thony3dsMods.MOD_ID, name));
    }

    public static void registerVillagers(){
        Thony3dsMods.LOGGER.info("Registering Villagers "+ Thony3dsMods.MOD_ID);

    }
}
