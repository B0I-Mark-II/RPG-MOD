package net.mcreator.rpgskill.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.rpgskill.potion.DP1CooldownPotionEffect;
import net.mcreator.rpgskill.RpgskillMod;

import java.util.Map;
import java.util.Collection;

public class DpNOTReadyProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RpgskillMod.LOGGER.warn("Failed to load dependency entity for procedure DpNOTReady!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == DP1CooldownPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) == true;
	}
}
