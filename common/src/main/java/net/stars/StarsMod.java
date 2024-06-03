package net.stars;

import dev.architectury.event.events.common.TickEvent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.stars.Blocks.ModBlock;
import net.stars.Items.ModItem;
import net.stars.Listener.SpaceSuitCheck;
import net.stars.Planet.Moon.Gravity;
import net.stars.Planet.Moon.Moon;
import net.stars.Tab.ModCreativeTab;

import java.util.ArrayList;
import java.util.List;

public class StarsMod {
    public static final String MOD_ID = "starsmod";

    public static List<ResourceKey<Level>> NoOxyLevel = new ArrayList<>();
    public static List<ResourceKey<Level>> LowGravityLevel = new ArrayList<>();

    public static void init() {
        ModCreativeTab.register();
        ModBlock.register();
        ModItem.register();
        Moon.register();

        NoOxyLevel.add(Moon.moon);
        LowGravityLevel.add(Moon.moon);

        TickEvent.PLAYER_POST.register(SpaceSuitCheck::onPlayerTick);
        TickEvent.PLAYER_POST.register(Gravity::OnTick);

        System.out.println(StarsExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}