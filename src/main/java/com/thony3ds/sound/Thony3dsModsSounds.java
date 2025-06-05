package com.thony3ds.sound;

import com.thony3ds.Thony3dsMods;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class Thony3dsModsSounds {

    public static final SoundEvent APPELLE_SUR_MON_TELEPHONE = registerSoundEvent("appelle_sur_mon_telephone");
    public static final RegistryKey<JukeboxSong> APPELLE_SUR_MON_TELEPHONE_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Thony3dsMods.MOD_ID, "appelle_sur_mon_telephone"));

    public static final SoundEvent POLISH_COW = registerSoundEvent("polish_cow");
    public static final RegistryKey<JukeboxSong> POLISH_COW_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Thony3dsMods.MOD_ID, "polish_cow"));
    public static final SoundEvent DONT_STOP_THE_FASCHISM = registerSoundEvent("dont_stop_the_fascism");
    public static final RegistryKey<JukeboxSong> DONT_STOP_THE_FASCHISM_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Thony3dsMods.MOD_ID, "dont_stop_the_fascism"));

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(Thony3dsMods.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        Thony3dsMods.LOGGER.info("Registering Sounds for "+ Thony3dsMods.MOD_ID);
    }
}
