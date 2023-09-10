package net.mcreator.rpgskill.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.rpgskill.potion.DP1CooldownPotionEffect;
import net.mcreator.rpgskill.potion.BleedingT13PotionEffect;
import net.mcreator.rpgskill.potion.BleedingT12PotionEffect;
import net.mcreator.rpgskill.potion.BleedingT11PotionEffect;
import net.mcreator.rpgskill.RpgskillModVariables;
import net.mcreator.rpgskill.RpgskillMod;

import java.util.Map;
import java.util.Collection;

public class DaggerpassiveonhitProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RpgskillMod.LOGGER.warn("Failed to load dependency entity for procedure Daggerpassiveonhit!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				RpgskillMod.LOGGER.warn("Failed to load dependency sourceentity for procedure Daggerpassiveonhit!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((sourceentity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new RpgskillModVariables.PlayerVariables())).DP1SEL == true) {
			if ((new Object() {
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
			}.check(sourceentity)) == false) {
				if ((new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == BleedingT13PotionEffect.potion)
									return true;
							}
						}
						return false;
					}
				}.check(entity)) == true) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.addPotionEffect(new EffectInstance(BleedingT13PotionEffect.potion, (int) 200, (int) 1, (false), (false)));
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(("3 Bleed Stacks ReApplied To" + entity)), (true));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.addPotionEffect(new EffectInstance(DP1CooldownPotionEffect.potion, (int) 100, (int) 1, (false), (false)));
				}
				if ((new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == BleedingT12PotionEffect.potion)
									return true;
							}
						}
						return false;
					}
				}.check(entity)) == true) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.addPotionEffect(new EffectInstance(BleedingT13PotionEffect.potion, (int) 200, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(BleedingT12PotionEffect.potion);
					}
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(("3 Bleed Stacks Applied To" + entity)), (true));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.addPotionEffect(new EffectInstance(DP1CooldownPotionEffect.potion, (int) 100, (int) 1, (false), (false)));
				}
				if ((new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == BleedingT11PotionEffect.potion)
									return true;
							}
						}
						return false;
					}
				}.check(entity)) == true) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.addPotionEffect(new EffectInstance(BleedingT12PotionEffect.potion, (int) 200, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(BleedingT11PotionEffect.potion);
					}
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(("2 Bleed Stacks Applied To" + entity)), (true));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.addPotionEffect(new EffectInstance(DP1CooldownPotionEffect.potion, (int) 100, (int) 1, (false), (false)));
				}
				if ((new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == BleedingT11PotionEffect.potion)
									return true;
							}
						}
						return false;
					}
				}.check(entity)) == false) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.addPotionEffect(new EffectInstance(BleedingT11PotionEffect.potion, (int) 200, (int) 1, (false), (false)));
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(("1 Bleed Stacks Applied To" + entity)), (true));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.addPotionEffect(new EffectInstance(DP1CooldownPotionEffect.potion, (int) 100, (int) 1, (false), (false)));
				}
			}
		}
	}
}
