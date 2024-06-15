package net.stars.Planet;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.stars.Planet.Moon.Moon;

/**
 * Gravity类用于模拟各种星球上的重力效果。
 */
public class Gravity {
    public static void ApplyGravity(Entity entity) {
        double gravMultiplier;

        ResourceKey<Level> planet = entity.level().dimension();
        if (planet.equals(Moon.moon)) {
            gravMultiplier = -0.8;
        }else{
            gravMultiplier = 0.0;
        }

        if (!(entity.getVehicle() == null)) {
            return;
        }

        Vec3 velocity = entity.getDeltaMovement();

        if (entity instanceof Player player){
            if (player.getAbilities().flying){
                return;
            }
        }

        if (entity instanceof LivingEntity) {
            gravMultiplier *= 0.0755;
        } else {
            gravMultiplier *= 0.04;
        }

        entity.setDeltaMovement(velocity.add(0, -gravMultiplier, 0));
    }
}
