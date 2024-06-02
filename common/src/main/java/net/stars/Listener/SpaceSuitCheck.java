package net.stars.Listener;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;

import java.util.*;

import static net.stars.StarsMod.nooxylevel;

public class SpaceSuitCheck {
    public static Map<UUID, Boolean> stackMap = new HashMap<>();
    public static Map<UUID, Integer> timerMap = new HashMap<>();
    public static void onPlayerTick(Player player) {
        UUID playerUUID = player.getUUID();
        if (!stackMap.containsKey(playerUUID)) {
            stackMap.put(playerUUID, false);
            timerMap.put(playerUUID, 0);
        }

        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem().toString().contains("space_helmet") && player.getItemBySlot(EquipmentSlot.CHEST).getItem().toString().contains("space_chestplate") && player.getItemBySlot(EquipmentSlot.LEGS).getItem().toString().contains("space_leggings") && player.getItemBySlot(EquipmentSlot.FEET).getItem().toString().contains("space_boots")) {
            stackMap.replace(playerUUID, false);
        } else {
            stackMap.replace(playerUUID, true);
        }

        int timer = timerMap.get(playerUUID);
        if (stackMap.get(playerUUID) && timer >= 40) {
            timer = 0;
            if (!player.isCreative() || !player.isSpectator()) {
                nooxylevel.forEach( levelResourceKey -> {
                    if (player.level().dimension().equals(levelResourceKey)) {
                        player.hurt(player.damageSources().generic(),7.0F);
                    }
                });
            }
        } else {
            timer++;
        }
        timerMap.put(playerUUID, timer);
    }
}
