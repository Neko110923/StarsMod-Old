package net.stars.Listener;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import java.util.*;
import static net.stars.StarsMod.NoOxyLevel;

/**
 * SpaceSuitCheck 类用于检查玩家是否穿戴了完整的太空服。
 * 当玩家不穿戴完整的太空服时，会开始计时，如果计时达到40，且玩家不在创造模式或观战模式，
 * 则会对玩家造成伤害，模拟氧气不足的效果。
 */
public class SpaceSuitCheck {
    // 存储玩家UUID与是否穿戴完整太空服的布尔值映射。
    public static Map<UUID, Boolean> stackMap = new HashMap<>();
    // 存储玩家UUID与计时器的整数值映射。
    public static Map<UUID, Integer> timerMap = new HashMap<>();

    /**
     * 每个玩家游戏周期内的处理函数。
     * @param player 当前周期检查的玩家。
     */
    public static void onPlayerTick(Player player) {
        UUID playerUUID = player.getUUID();

        // 初始化玩家的太空服状态和计时器。
        if (!stackMap.containsKey(playerUUID)) {
            stackMap.put(playerUUID, false);
            timerMap.put(playerUUID, 0);
        }

        // 检查玩家是否穿戴了完整的太空服。
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem().toString().contains("space_helmet") &&
                player.getItemBySlot(EquipmentSlot.CHEST).getItem().toString().contains("space_chestplate") &&
                player.getItemBySlot(EquipmentSlot.LEGS).getItem().toString().contains("space_leggings") &&
                player.getItemBySlot(EquipmentSlot.FEET).getItem().toString().contains("space_boots")) {
            stackMap.replace(playerUUID, false);
        } else {
            stackMap.replace(playerUUID, true);
        }

        int timer = timerMap.get(playerUUID);

        // 如果玩家没有穿戴完整的太空服，且计时器达到40，则对玩家造成伤害。
        if (stackMap.get(playerUUID) && timer >= 40) {
            timer = 0;
            if (!player.isCreative() || !player.isSpectator()) {
                NoOxyLevel.forEach(levelResourceKey -> {
                    if (player.level().dimension().equals(levelResourceKey)) {
                        player.hurt(player.damageSources().generic(), 7.0F);
                    }
                });
            }
        } else {
            timer++;
        }

        // 更新计时器。
        timerMap.put(playerUUID, timer);
    }
}
