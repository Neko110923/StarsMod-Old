package net.stars.fabric;

import net.stars.StarsExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class StarsExpectPlatformImpl {
    /**
     * This is our actual method to {@link StarsExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
