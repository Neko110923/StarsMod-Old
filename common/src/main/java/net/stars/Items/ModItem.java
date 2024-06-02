package net.stars.Items;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.stars.Armor.SpaceBoots;
import net.stars.Armor.SpaceChestplate;
import net.stars.Armor.SpaceHelmet;
import net.stars.Armor.SpaceLeggings;
import net.stars.Blocks.ModBlock;
import net.stars.StarsMod;
import net.stars.Tab.ModBlockTab;
import net.stars.Tab.ModCreativeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class ModItem {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(StarsMod.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> iron_plate = ITEM.register("iron_plate", () ->
            new Item(new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB)));
    public static final RegistrySupplier<Item> fan_blade = ITEM.register("fan_blade", () ->
            new Item(new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB)));
    public static final RegistrySupplier<Item> small_battery = ITEM.register("small_battery", () ->
            new Item(new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB)));
    public static final RegistrySupplier<Item> filter = ITEM.register("filter", () ->
            new Item(new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB)));
    public static final RegistrySupplier<Item> bearing = ITEM.register("bearing", () ->
            new Item(new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB)));
    public static final RegistrySupplier<Item> iron_ring = ITEM.register("iron_ring", () ->
            new Item(new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB)));
    public static final RegistrySupplier<Item> steel_ball = ITEM.register("steel_ball", () ->
            new Item(new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB)));
    public static final RegistrySupplier<Item> lunar_alloy = ITEM.register("lunar_alloy", () ->
            new Item(new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB)));
    public static final RegistrySupplier<Item> lunar_alloy_ingot = ITEM.register("lunar_alloy_ingot", () ->
            new Item(new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB)));

    public static final RegistrySupplier<Item> moon_stone = ITEM.register("moon_stone", () ->
            new BlockItem(ModBlock.moon_stone.get(), new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB).arch$tab(ModBlockTab.BLOCK_TAB)));
    public static final RegistrySupplier<Item> lunar_alloy_ore = ITEM.register("lunar_alloy_ore", () ->
            new BlockItem(ModBlock.lunar_alloy_ore.get(), new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB).arch$tab(ModBlockTab.BLOCK_TAB)));
    public static final RegistrySupplier<Item> moon_sand = ITEM.register("moon_sand", () ->
            new BlockItem(ModBlock.moon_sand.get(), new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB).arch$tab(ModBlockTab.BLOCK_TAB)));
    public static final RegistrySupplier<Item> rocket = ITEM.register("rocket", () ->
            new BlockItem(ModBlock.rocket.get(), new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB).arch$tab(ModBlockTab.BLOCK_TAB)));

    public static final RegistrySupplier<Item> space_helmet = ITEM.register("space_helmet", () ->
            new ArmorItem(SpaceHelmet.spacehelmet, ArmorItem.Type.HELMET, new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB)));
    public static final RegistrySupplier<Item> space_chestplate = ITEM.register("space_chestplate", () ->
            new ArmorItem(SpaceChestplate.spacechestplate, ArmorItem.Type.CHESTPLATE, new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB)));
    public static final RegistrySupplier<Item> space_leggings = ITEM.register("space_leggings", () ->
            new ArmorItem(SpaceLeggings.spaceleggings, ArmorItem.Type.LEGGINGS, new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB)));
    public static final RegistrySupplier<Item> space_boots = ITEM.register("space_boots", () ->
               new ArmorItem(SpaceBoots.spaceboots, ArmorItem.Type.BOOTS, new Item.Properties().arch$tab(ModCreativeTab.EXAMPLE_TAB)));

    public static void register(){
        ITEM.register();
    }
}
