package net.stars.Armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;

/**
 * 定义了一个太空头盔的ArmorMaterial枚举实现。
 * 这个枚举项特别为游戏中的太空头盔提供独特的属性，如耐久度、防御值和修理材料。
 */
public enum SpaceHelmet implements ArmorMaterial {
    spacehelmet("starsmod:space_helmet", 33, new int[]{3, 6, 8, 3}, 12,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, Ingredient.of(Items.DIAMOND));

    // 定义了每个护甲位置（头、胸、腿、脚）的基耐久度。
    private static final int[] DURABILITY_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Ingredient repairIngredient;

    /**
     * SpaceHelmet的构造函数。
     * 初始化太空头盔的属性，如名称、耐久度倍数、每个部位的防御值、附魔价值、装备声事件、坚韧度、抗击退以及修理材料。
     *
     * @param name                  头盔的名称，用于注册。
     * @param durabilityMultiplier  耐久度的乘数，用于计算头盔的实际耐久度。
     * @param slotProtections       一个整型数组，包含每个护甲槽位（头、胸、腿、脚）的防御值。
     * @param enchantmentValue      该护甲可以接受的附魔值。
     * @param sound                 头盔装备时发出的声音事件。
     * @param toughness             头盔的坚韧度，影响其抵抗损坏的能力。
     * @param knockbackResistance   头盔的抗击退值，影响角色被击退的距离。
     * @param repairIngredient      用于修理头盔的材料。
     */
    SpaceHelmet(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
                SoundEvent sound, float toughness, float knockbackResistance, Ingredient repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    /**
     * 根据护甲类型返回耐久度。
     * 这个方法计算每个护甲部位（头、胸、腿、脚）的耐久度，基于预定义的耐久度基数和耐久度乘数。
     *
     * @param type 护甲的类型，指示是头盔、胸甲、腿甲还是脚套。
     * @return 护甲部位的耐久度。
     */
    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return DURABILITY_PER_SLOT[type.getSlot().getIndex()] * this.durabilityMultiplier;
    }

    /**
     * 根据护甲类型返回防御值。
     * 这个方法返回指定护甲类型（头、胸、腿、脚）的防御值，基于一个包含所有部位防御值的数组。
     *
     * @param type 护甲的类型，指示是头盔、胸甲、腿甲还是脚套。
     * @return 护甲部位的防御值。
     */
    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.slotProtections[type.getSlot().getIndex()];
    }

    /**
     * 返回该护甲的附魔价值。
     * 该值决定了该护甲能否接受特定类型的附魔以及附魔的强度。
     *
     * @return 该护甲的附魔价值。
     */
    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    /**
     * 返回装备该护甲时的声音事件。
     * 当玩家装备或卸下护甲时，游戏会播放这个声音。
     *
     * @return 装备声音事件。
     */
    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    /**
     * 返回用于修理该护甲的材料。
     * 这可以是一个物品或一组物品，用于在游戏中修复护甲。
     *
     * @return 修理材料。
     */
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    /**
     * 返回该护甲材料的名称。
     * 这个名称用于游戏内部和用户界面中显示护甲的名称。
     *
     * @return 护甲材料的名称。
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 返回该护甲的坚韧度。
     * 坚韧度影响护甲抵抗损坏的能力，值越高，护甲越耐用。
     *
     * @return 护甲的坚韧度。
     */
    @Override
    public float getToughness() {
        return this.toughness;
    }

    /**
     * 返回该护甲的抗击退值。
     * 抗击退值影响角色被击退的距离，值越高，角色被击退的距离越短。
     *
     * @return 护甲的抗击退值。
     */
    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
