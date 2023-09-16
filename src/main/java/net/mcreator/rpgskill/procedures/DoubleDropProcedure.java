package net.mcreator.rpgskill.procedures;

import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.rpgskill.enchantment.MiningProficencyEnchantment;
import net.mcreator.rpgskill.RpgskillModVariables;
import net.mcreator.rpgskill.RpgskillMod;

import java.util.Random;
import java.util.Map;

public class DoubleDropProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RpgskillMod.LOGGER.warn("Failed to load dependency entity for procedure DoubleDrop!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				RpgskillMod.LOGGER.warn("Failed to load dependency itemstack for procedure DoubleDrop!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (EnchantmentHelper.getEnchantmentLevel(MiningProficencyEnchantment.enchantment, itemstack) == 5) {
			{
				boolean _setval = (true);
				entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Double_Drops = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (EnchantmentHelper.getEnchantmentLevel(MiningProficencyEnchantment.enchantment, itemstack) == 4) {
			{
				double _setval = (MathHelper.nextInt(new Random(), 1, 5));
				entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Player_Random = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new RpgskillModVariables.PlayerVariables())).Player_Random > 1) {
				{
					boolean _setval = (true);
					entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Double_Drops = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (EnchantmentHelper.getEnchantmentLevel(MiningProficencyEnchantment.enchantment, itemstack) == 3) {
			{
				double _setval = (MathHelper.nextInt(new Random(), 1, 5));
				entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Player_Random = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new RpgskillModVariables.PlayerVariables())).Player_Random > 2) {
				{
					boolean _setval = (true);
					entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Double_Drops = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (EnchantmentHelper.getEnchantmentLevel(MiningProficencyEnchantment.enchantment, itemstack) == 2) {
			{
				double _setval = (MathHelper.nextInt(new Random(), 1, 5));
				entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Player_Random = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new RpgskillModVariables.PlayerVariables())).Player_Random > 3) {
				{
					boolean _setval = (true);
					entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Double_Drops = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (EnchantmentHelper.getEnchantmentLevel(MiningProficencyEnchantment.enchantment, itemstack) == 1) {
			{
				double _setval = (MathHelper.nextInt(new Random(), 1, 5));
				entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Player_Random = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new RpgskillModVariables.PlayerVariables())).Player_Random > 3) {
				{
					boolean _setval = (true);
					entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Double_Drops = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
