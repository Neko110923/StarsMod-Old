package net.stars.Planet.Moon;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * Gravity类用于模拟月球上的重力效果。
 * 重力方向通过up变量控制，时间通过time变量递增来实现重力变化的效果。
 */
public class Gravity {

    // 控制重力方向的静态变量
    static boolean up;
    // 用于计算时间的静态变量，以模拟重力周期性变化
    static int time;

    /**
     * 每帧更新玩家的重力效果。
     * @param player 当前的玩家实体。
     */
    public static void OnTick(Player player) {
        // 如果当前重力方向为向上，则时间递增
        if (up){
            time++;
        }
        // 获取玩家当前所在的维度
        ResourceKey<Level> dimension = player.level().dimension();
        // 判断玩家是否在月球上
        if (dimension.equals(Moon.moon)) {
            // 当时间达到一定值时，重置时间并改变重力方向
            if (time >= 8){
                time = 0;
                up = false;
                // 修改玩家的移动速度，模拟月球上的低重力环境
                player.setDeltaMovement(player.getDeltaMovement().x, -0.07, player.getDeltaMovement().z);
            }
            // 当玩家向下移动时，应用月球上的重力
            if (player.getDeltaMovement().y <= 0.0) {
                player.setDeltaMovement(player.getDeltaMovement().x, -0.07, player.getDeltaMovement().z);
            }
            // 当玩家向上移动时，如果当前重力方向不是向上，则增加玩家的移动速度，模拟跳跃效果
            if (player.getDeltaMovement().y > 0.0) {
                if (!up) {
                    player.setDeltaMovement(player.getDeltaMovement().x, 0.42 * 1.5, player.getDeltaMovement().z);
                    up = true;
                }
            }
        }
    }
}
