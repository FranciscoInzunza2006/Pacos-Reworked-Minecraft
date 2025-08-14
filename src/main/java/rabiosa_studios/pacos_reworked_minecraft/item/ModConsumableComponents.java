package rabiosa_studios.pacos_reworked_minecraft.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;

public class ModConsumableComponents {
    private static ConsumableComponent jamConsumableComponent (RegistryEntry<StatusEffect> effect) {
        return ConsumableComponents.drink()
                .consumeSeconds(2.0F)
                .sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK)
                .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(effect, 30 * 20)))
                .build();
    }

    public static final ConsumableComponent MELON_JAM = jamConsumableComponent(StatusEffects.REGENERATION);
    public static final ConsumableComponent SWEET_BERRIES = jamConsumableComponent(StatusEffects.SPEED);
    public static final ConsumableComponent GLOW_BERRIES = jamConsumableComponent(StatusEffects.NIGHT_VISION);
}
