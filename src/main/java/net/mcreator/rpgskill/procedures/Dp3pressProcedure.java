package net.mcreator.rpgskill.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.rpgskill.RpgskillModVariables;
import net.mcreator.rpgskill.RpgskillMod;

import java.util.Map;

public class Dp3pressProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RpgskillMod.LOGGER.warn("Failed to load dependency entity for procedure Dp3press!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new RpgskillModVariables.PlayerVariables())).Dagger_lvl >= 30) {
			{
				boolean _setval = (false);
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
				boolean _setval = (true);
				entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DP3SEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A74 You Are Not High Enough Level To Use This Skill"), (true));
			}
		}
	}
}
