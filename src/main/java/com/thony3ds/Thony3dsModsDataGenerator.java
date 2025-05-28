package com.thony3ds;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class Thony3dsModsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator){
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(Thony3dsModsWorldGenerator::new);
    }
    @Override
    public void buildRegistry(RegistryBuilder registryBuilder){
        registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, TrialDimension::bootstrapType);
    }
}
