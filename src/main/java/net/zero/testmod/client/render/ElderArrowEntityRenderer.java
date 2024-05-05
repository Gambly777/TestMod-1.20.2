package net.zero.testmod.client.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import net.zero.testmod.entities.ElderArrowEntity;

@Environment(EnvType.CLIENT)
public class ElderArrowEntityRenderer extends ProjectileEntityRenderer<ElderArrowEntity> {
    public static final Identifier TEXTURE = new Identifier("testmod:textures/entity/elder_arrow.png");

    public ElderArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(ElderArrowEntity entity) {
        return TEXTURE;
    }
}
