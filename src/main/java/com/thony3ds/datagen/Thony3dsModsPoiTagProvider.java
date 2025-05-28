package com.thony3ds.datagen;

import com.thony3ds.Thony3dsMods;
import net.minecraft.data.DataOutput;
import net.minecraft.data.tag.TagProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PointOfInterestTypeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.concurrent.CompletableFuture;

public class Thony3dsModsPoiTagProvider extends TagProvider<PointOfInterestType> {
    public Thony3dsModsPoiTagProvider(DataOutput output,
                                         CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.POINT_OF_INTEREST_TYPE, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup){
        this.getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(Identifier.of(Thony3dsMods.MOD_ID, "frankpoi"));
    }
}
