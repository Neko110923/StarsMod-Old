package net.stars.forge;

import net.stars.StarsExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class StarsExpectPlatformImpl {
    /**
     * This is our actual method to {@link StarsExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
