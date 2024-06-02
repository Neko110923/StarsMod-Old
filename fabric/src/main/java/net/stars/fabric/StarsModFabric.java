package net.stars.fabric;

import net.stars.StarsMod;
import net.fabricmc.api.ModInitializer;

public class StarsModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        StarsMod.init();
    }
}
