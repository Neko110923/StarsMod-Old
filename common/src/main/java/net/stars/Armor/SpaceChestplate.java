package net.stars.Armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;

/**
 * 定义了一个特殊的护甲材料，用于创建太空胸甲。
 * 这个护甲材料具有独特的属性，如耐久度、防御值和修理材料。
 */
public enum SpaceChestplate implements ArmorMaterial {
    spacechestplate("starsmod:space_chestplate", 33, new int[]{4, 6, 4, 3}, 15,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, Ingredient.of(Items.DIAMOND));

    // 定义了每种护甲类型（头、胸、腿、脚）的基础耐久度。
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
     * 初始化太空胸甲的属性，包括名称、耐久度倍数、各部位防御值、附魔价值、装备声效、坚韧度、抗击退和修理材料。
     *
     * @param name                  护甲的名称，用于注册。
     * @param durabilityMultiplier  耐久度的倍数，用于计算每种类型的耐久度。
     * @param slotProtections       一个数组，包含每种护甲类型（头、胸、腿、脚）的防御值。
     * @param enchantmentValue      该护甲材料可接受的附魔值。
     * @param sound                 当装备该护甲时播放的声效。
     * @param toughness             护甲的坚韧度，影响抗击打能力。
     * @param knockbackResistance   护甲的抗击退能力。
     * @param repairIngredient      用于修理该护甲的材料。
     */
    SpaceChestplate(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
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
     * 返回该护甲材料的附魔价值。
     *
     * @return 附魔价值。
     */
    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    /**
     * 返回装备该护甲时播放的声效。
     *
     * @return 声效事件。
     */
    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    /**
     * 返回用于修理该护甲的材料。
     *
     * @return 修理材料。
     */
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    /**
     * 返回该护甲材料的名称。
     *
     * @return 护甲材料名称。
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 返回护甲的坚韧度。
     *
     * @return 坚韧度。
     */
    @Override
    public float getToughness() {
        return this.toughness;
    }

    /**
     * 返回护甲的抗击退能力。
     *
     * @return 抗击退能力。
     */
    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
