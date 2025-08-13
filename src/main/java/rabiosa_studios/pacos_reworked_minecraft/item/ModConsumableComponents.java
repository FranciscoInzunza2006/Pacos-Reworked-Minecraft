package rabiosa_studios.pacos_reworked_minecraft.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.sound.SoundEvents;

public class ModConsumableComponents {
//    private static final ConsumableComponent.Builder JAM_TEMPLATE = ConsumableComponents.drink()
//            .consumeSeconds(2.0F)
//            .sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK);

    public static final ConsumableComponent MELON_JAM = ConsumableComponents.drink()
            .consumeSeconds(2.0F)
            .sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK)
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 30 * 20)))
            .build();

    public static final ConsumableComponent SWEET_BERRIES = ConsumableComponents.drink()
            .consumeSeconds(2.0F)
            .sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK)
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 30 * 20)))
            .build();

    public static final ConsumableComponent GLOW_BERRIES = ConsumableComponents.drink()
            .consumeSeconds(2.0F)
            .sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK)
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 30 * 20)))
            .build();
}
