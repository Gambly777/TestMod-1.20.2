package net.zero.testmod.client.render;

import net.zero.testmod.entities.UndeadArrowEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class UndeadArrowEntityRenderer extends ProjectileEntityRenderer<UndeadArrowEntity> {
    public static final Identifier TEXTURE = new Identifier("testmod:textures/entity/undead_arrow.png");

    public UndeadArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(UndeadArrowEntity entity) {
        return TEXTURE;
    }
}