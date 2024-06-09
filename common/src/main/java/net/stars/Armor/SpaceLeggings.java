package net.stars.Armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;

/**
 * 定义了一个特殊的护甲材料——SpaceLeggings，用于游戏中的装备系统。
 * 它提供了特定的属性，如耐久度、防御值、附魔价值等。
 */
public enum SpaceLeggings implements ArmorMaterial {
    spaceleggings("starsmod:space_leggings", 33, new int[]{4, 3, 8, 3}, 10,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, Ingredient.of(Items.DIAMOND));

    // 定义了每种护甲类型（头、胸、腿、脚）的基础耐久度
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
     * SpaceLeggings的构造函数，初始化其属性。
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
    SpaceLeggings(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
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
     * 根据护甲类型计算耐久度。
     *
     * @param type 护甲类型（头、胸、腿、脚）。
     * @return 护甲类型的耐久度。
     */
    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return DURABILITY_PER_SLOT[type.getSlot().getIndex()] * this.durabilityMultiplier;
    }

    /**
     * 根据护甲类型返回防御值。
     *
     * @param type 护甲类型（头、胸、腿、脚）。
     * @return 护甲类型的防御值。
     */
    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.slotProtections[type.getSlot().getIndex()];
    }

    /**
     * 返回该护甲的附魔价值。
     *
     * @return 附魔价值。
     */
    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    /**
     * 返回装备此护甲时的声音事件。
     *
     * @return 声音事件。
     */
    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    /**
     * 返回用于修复此护甲的材料。
     *
     * @return 修复材料。
     */
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    /**
     * 返回此护甲材料的名称。
     *
     * @return 护甲材料名称。
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 返回护甲的韧性值。
     *
     * @return 韧性值。
     */
    @Override
    public float getToughness() {
        return this.toughness;
    }

    /**
     * 返回抗击退值。
     *
     * @return 抗击退值。
     */
    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
