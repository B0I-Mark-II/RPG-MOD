package net.mcreator.rpgskill.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.rpgskill.item.DaggerSwordItem;
import net.mcreator.rpgskill.RpgskillMod;

import java.util.Map;

public class IsHoldingdaggerProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RpgskillMod.LOGGER.warn("Failed to load dependency entity for procedure IsHoldingdagger!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == DaggerSwordItem.block
				|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == DaggerSwordItem.block;
	}
}
