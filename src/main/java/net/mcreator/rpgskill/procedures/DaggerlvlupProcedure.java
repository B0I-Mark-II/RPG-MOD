package net.mcreator.rpgskill.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.rpgskill.RpgskillModVariables;
import net.mcreator.rpgskill.RpgskillMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class DaggerlvlupProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RpgskillMod.LOGGER.warn("Failed to load dependency entity for procedure Daggerlvlup!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).experienceLevel
				: 0) >= (entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new RpgskillModVariables.PlayerVariables())).Total_lvl
				&& !((entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new RpgskillModVariables.PlayerVariables())).Dagger_lvl == 50)) {
			{
				double _setval = ((entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new RpgskillModVariables.PlayerVariables())).Dagger_lvl + 1);
				entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Dagger_lvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new RpgskillModVariables.PlayerVariables())).Total_lvl + 1);
				entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Total_lvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			SkillpointcalcProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		} else {
			if ((entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new RpgskillModVariables.PlayerVariables())).Dagger_lvl == 50) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A74 You Have Reached The Max LVL For This Weapon"),
							(true));
				}
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A74 You Do Not Meet The LVL Requirement To Lvl Up"), (true));
			}
		}
	}
}
