
package net.mcreator.rpgskill.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.rpgskill.RpgskillModElements;

@RpgskillModElements.ModElement.Tag
public class MiningProficencyEnchantment extends RpgskillModElements.ModElement {
	@ObjectHolder("rpgskill:mining_proficency")
	public static final Enchantment enchantment = null;

	public MiningProficencyEnchantment(RpgskillModElements instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("mining_proficency"));
	}

	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.UNCOMMON, EnchantmentType.BREAKABLE, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 5;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == Enchantments.FORTUNE)
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}

		@Override
		public boolean canGenerateInLoot() {
			return false;
		}

		@Override
		public boolean canVillagerTrade() {
			return false;
		}
	}
}
