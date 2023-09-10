package net.mcreator.rpgskill.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.rpgskill.RpgskillModVariables;
import net.mcreator.rpgskill.RpgskillMod;

import java.util.Map;

public class Dp1pressProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RpgskillMod.LOGGER.warn("Failed to load dependency entity for procedure Dp1press!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (true);
			entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.DP1SEL = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = (false);
			entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.DP2SEL = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = (false);
			entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.DP3SEL = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
