package net.zero.testmod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.zero.testmod.init.EntityInit;
import net.zero.testmod.client.render.FireArrowEntityRenderer;

public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(EntityInit.FIRE_ARROW, FireArrowEntityRenderer::new);
    }
}