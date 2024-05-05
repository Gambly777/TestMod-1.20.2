package net.zero.testmod.client.render;

import net.zero.testmod.entities.FireArrowEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class FireArrowEntityRenderer extends ProjectileEntityRenderer<FireArrowEntity> {
    public static final Identifier TEXTURE = new Identifier("testmod:textures/entity/fire_arrow.png");

    public FireArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(FireArrowEntity entity) {
        return TEXTURE;
    }
}
