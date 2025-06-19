package com.thony3ds;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class Thony3dsModsWorldGenerator extends FabricDynamicRegistryProvider {
    public Thony3dsModsWorldGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture){
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries){
        entries.addAll(registries.getOrThrow(RegistryKeys.DIMENSION_TYPE));
    }

    @Override
    public String getName(){return "World Gen";}
}
