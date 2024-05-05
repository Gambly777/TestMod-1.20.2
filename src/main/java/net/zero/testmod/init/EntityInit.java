package net.zero.testmod.init;

import net.zero.testmod.entities.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

import static net.zero.testmod.TestMod.MOD_ID;

public class EntityInit {

    public static EntityType<FireArrowEntity> FIRE_ARROW;
    public static EntityType<UndeadArrowEntity> UNDEAD_ARROW;

    private static <T extends Entity> EntityType<T> register(String s, EntityType<T> entityType) {
        return Registry.register(Registries.ENTITY_TYPE, MOD_ID + ":" + s, entityType);
    }

    private static <T extends Entity> EntityType<T> createArrowEntityType(EntityType.EntityFactory<T> factory) {
        return FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).trackRangeBlocks(4).trackedUpdateRate(20).build();
    }

    public static void init() {
        FIRE_ARROW = register("fire_arrow", createArrowEntityType(FireArrowEntity::new));
        UNDEAD_ARROW = register("undead_arrow", createArrowEntityType(UndeadArrowEntity::new));
    }

}
