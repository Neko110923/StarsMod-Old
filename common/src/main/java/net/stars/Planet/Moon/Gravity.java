package net.stars.Planet.Moon;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Gravity {

    static boolean up;
    static int time;

    public static void OnTick(Player player) {
        if (up){
            time++;
        }
        ResourceKey<Level> dimension = player.level().dimension();
        if (dimension.equals(Moon.moon)) {
            if (time >= 8){
                time = 0;
                up = false;
                player.setDeltaMovement(player.getDeltaMovement().x, -0.07, player.getDeltaMovement().z);
            }
            if (player.getDeltaMovement().y <= 0.0) {
                player.setDeltaMovement(player.getDeltaMovement().x, -0.07, player.getDeltaMovement().z);
            }
            if (player.getDeltaMovement().y > 0.0) {
                if (!up) {
                    player.setDeltaMovement(player.getDeltaMovement().x, 0.42 * 1.5, player.getDeltaMovement().z);
                    up = true;
                }
            }
        }
    }
}
