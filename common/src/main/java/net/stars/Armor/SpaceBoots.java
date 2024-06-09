package net.stars.Armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;

/**
 * 定义了一个特殊的ArmorMaterial枚举，用于创建太空靴。
 * 这个枚举项提供了太空靴的特定属性，如耐久度、防御值、附魔价值等。
 */
public enum SpaceBoots implements ArmorMaterial {
    spaceboots("starsmod:space_boots", 33, new int[]{2, 6, 8, 3}, 8,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, Ingredient.of(Items.DIAMOND));

    // 定义了每种防具类型（头、胸、腿、脚）的基础耐久度倍数。
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
     * SpaceBoots的构造函数，初始化太空靴的属性。
     *
     * @param name                  防具的名称，用于注册和标识。
     * @param durabilityMultiplier  耐久度倍数，用于计算每种防具类型的耐久度。
     * @param slotProtections       每个防具槽位的防御值数组，对应头、胸、腿、脚。
     * @param enchantmentValue      该防具可接受的附魔价值。
     * @param sound                 装备该防具时播放的声音事件。
     * @param toughness             防具的韧性值，影响抗击打能力。
     * @param knockbackResistance   防具的抗击退值，影响抗击退能力。
     * @param repairIngredient      用于修复该防具的材料。
     */
    SpaceBoots(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
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
     * 根据防具类型计算耐久度。
     *
     * @param type 防具类型（头、胸、腿、脚）。
     * @return 计算后的耐久度。
     */
    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return DURABILITY_PER_SLOT[type.getSlot().getIndex()] * this.durabilityMultiplier;
    }

    /**
     * 根据防具类型返回防御值。
     *
     * @param type 防具类型（头、胸、腿、脚）。
     * @return 防御值。
     */
    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.slotProtections[type.getSlot().getIndex()];
    }

    /**
     * 返回该防具的附魔价值。
     *
     * @return 附魔价值。
     */
    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    /**
     * 返回装备该防具时播放的声音事件。
     *
     * @return 声音事件。
     */
    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    /**
     * 返回用于修复该防具的材料。
     *
     * @return 修复材料。
     */
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    /**
     * 返回防具的名称。
     *
     * @return 防具名称。
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 返回防具的韧性值。
     *
     * @return 韧性值。
     */
    @Override
    public float getToughness() {
        return this.toughness;
    }

    /**
     * 返回防具的抗击退值。
     *
     * @return 抗击退值。
     */
    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
