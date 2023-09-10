package net.mcreator.rpgskill.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.rpgskill.RpgskillModVariables;
import net.mcreator.rpgskill.RpgskillMod;

import java.util.Map;
import java.util.HashMap;

public class SkillpointcalcProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPickupXP(PlayerXpEvent.PickupXp event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RpgskillMod.LOGGER.warn("Failed to load dependency entity for procedure Skillpointcalc!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0)
					- (entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new RpgskillModVariables.PlayerVariables())).Total_lvl);
			entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Skill_points = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
