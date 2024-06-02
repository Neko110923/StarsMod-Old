package net.stars;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import dev.architectury.event.events.common.TickEvent;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.registries.RegistrarManager;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.stars.Blocks.ModBlock;
import net.stars.Items.ModItem;
import net.stars.Listener.SpaceSuitCheck;
import net.stars.Planet.Moon.Moon;
import net.stars.Tab.ModCreativeTab;

import java.util.ArrayList;
import java.util.List;

public class StarsMod {
    public static final String MOD_ID = "starsmod";
    // We can use this if we don't want to use DeferredRegister
    public static final Supplier<RegistrarManager> REGISTRIES = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

    public static List<ResourceKey<Level>> nooxylevel = new ArrayList<>();

    public static void init() {
        ModCreativeTab.register();
        ModBlock.register();
        ModItem.register();
        Moon.register();
        nooxylevel.add(Moon.moon);
        TickEvent.PLAYER_POST.register(SpaceSuitCheck::onPlayerTick);
        System.out.println(StarsExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}