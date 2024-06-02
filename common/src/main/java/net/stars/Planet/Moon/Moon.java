package net.stars.Planet.Moon;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.stars.StarsMod;

public class Moon {
    public static final ResourceKey<Level> moon = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(StarsMod.MOD_ID, "moon"));
    public static final ResourceKey<DimensionType> moon_type = ResourceKey.create(Registries.DIMENSION_TYPE, moon.registry());


    public static void register () {
        System.out.println("正在注册月球……");
    }
}
