package net.mcreator.rpgskill.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.rpgskill.potion.BleedingT11PotionEffect;
import net.mcreator.rpgskill.RpgskillMod;

import java.util.Map;
import java.util.Collection;

public class BleedingT11OnEffectActiveTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RpgskillMod.LOGGER.warn("Failed to load dependency entity for procedure BleedingT11OnEffectActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\u00A74 [1x Stacks] Bleeding For " + (new Object() {
				int check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == BleedingT11PotionEffect.potion)
								return effect.getDuration();
						}
					}
					return 0;
				}
			}.check(entity)))), (true));
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).attackEntityFrom(new DamageSource("Bleeding").setDamageBypassesArmor(),
					(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) / 200));
		}
		if (new Object() {
			int check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == BleedingT11PotionEffect.potion)
							return effect.getDuration();
					}
				}
				return 0;
			}
		}.check(entity) < 1) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("1x Bleed Stacks Expired "), (true));
			}
		}
	}
}
