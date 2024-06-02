package net.stars.Tab;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.stars.Items.ModItem;
import net.stars.StarsMod;

import static net.stars.Tab.ModCreativeTab.TABS;

public class ModBlockTab {
    public static final RegistrySupplier<CreativeModeTab> BLOCK_TAB = TABS.register("block_tab", () ->
            CreativeTabRegistry.create(Component.translatable("itemGroup." + StarsMod.MOD_ID + ".block_tab"),
                    () -> new ItemStack(ModItem.moon_sand.get())));
}
