package com.thony3ds.datagen;

import com.thony3ds.Thony3dsModsWorldGenerator;
import com.thony3ds.TrialDimension;
import com.thony3ds.effects.Thony3dsModsEnchantmentEffects;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class Thony3dsModsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator){
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(Thony3dsModsWorldGenerator::new);
        pack.addProvider(Thony3dsModsPoiTagProvider::new);
        pack.addProvider(Thony3dsModsEnchantmentGenerator::new);
    }
    @Override
    public void buildRegistry(RegistryBuilder registryBuilder){
        registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, TrialDimension::bootstrapType);
        registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, Thony3dsModsEnchantmentEffects::bootstrap);
    }
}
