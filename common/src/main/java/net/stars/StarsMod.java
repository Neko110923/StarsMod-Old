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

/**
 * "StarsMod"模块的主类。
 * 该类负责初始化模块的所有方面，包括方块、物品、创意标签和事件监听器。
 */
public class StarsMod {
    // 模块唯一标识符
    public static final String MOD_ID = "starsmod";

    // 无氧维度列表，用于存储不需要氧气的维度键
    public static List<ResourceKey<Level>> NoOxyLevel = new ArrayList<>();

    /**
     * 初始化函数，用于在模块启动时执行必要的注册和配置。
     */
    public static void init() {
        // 注册创意标签、方块和物品
        ModCreativeTab.register();
        ModBlock.register();
        ModItem.register();
        Moon.register();

        // 将月球添加到无氧维度列表中
        NoOxyLevel.add(Moon.moon);

        // 注册玩家Tick事件的监听器，用于检查太空服和重力效果
        TickEvent.PLAYER_POST.register(SpaceSuitCheck::onPlayerTick);
        TickEvent.PLAYER_POST.register(Gravity::OnTick);

        // 打印配置文件目录的路径，用于调试和配置文件定位
        System.out.println(StarsExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
