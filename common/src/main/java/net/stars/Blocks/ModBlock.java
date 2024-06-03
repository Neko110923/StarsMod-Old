package net.stars.Blocks;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.stars.StarsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(StarsMod.MOD_ID, Registries.BLOCK);
    //Blocks
    public static final RegistrySupplier<Block> moon_stone = BLOCKS.register("moon_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistrySupplier<Block> moon_sand = BLOCKS.register("moon_sand", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));
    public static final RegistrySupplier<Block> rocket = BLOCKS.register("rocket", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));
    //Ores
    public static final RegistrySupplier<Block> lunar_alloy_ore = BLOCKS.register("lunar_alloy_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)
            .requiresCorrectToolForDrops()));

    public static void register() {
        BLOCKS.register();
    }
}
