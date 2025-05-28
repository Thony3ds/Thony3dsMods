package com.thony3ds;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class TrialDimension {

    private static final RegistryKey<DimensionOptions> TRIAL_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            Identifier.of(Thony3dsMods.MOD_ID, "eternity_trials"));
    private static final RegistryKey<World> TRIAL_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(Thony3dsMods.MOD_ID, "eternity_trials"));
    private static final RegistryKey<DimensionType> TRIAL_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(Thony3dsMods.MOD_ID, "eternity_trials_type"));

    public static void bootstrapType(Registerable<DimensionType> context){
        context.register(TRIAL_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), //fixedTime
                true, //has Skylight
                false, //has ceiling
                false, // has ultrawarm
                true, // natural
                1.0, // coordinateScale
                true, //Bed work
                true, //Anchor Respawn Work
                0, // Min Y
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, //effect location
                1.0f, //ambient light
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));

    }
}
