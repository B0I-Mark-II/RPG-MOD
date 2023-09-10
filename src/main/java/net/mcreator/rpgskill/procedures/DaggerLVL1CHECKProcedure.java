package net.mcreator.rpgskill.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.rpgskill.RpgskillModVariables;
import net.mcreator.rpgskill.RpgskillMod;

import java.util.Map;

public class DaggerLVL1CHECKProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RpgskillMod.LOGGER.warn("Failed to load dependency entity for procedure DaggerLVL1CHECK!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new RpgskillModVariables.PlayerVariables())).Dagger_lvl == 1;
	}
}
