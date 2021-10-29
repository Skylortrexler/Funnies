package website.skylorbeck.funnies.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import website.skylorbeck.funnies.Declarar;
import website.skylorbeck.funnies.entities.FairyEntity;
import website.skylorbeck.funnies.entities.renderer.FairyEntityRenderer;
import website.skylorbeck.funnies.entities.renderer.FairyJarEntityRenderer;

@Environment(EnvType.CLIENT)
public class FunniesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMapImpl.INSTANCE.putBlock(Declarar.CANOFBEANSCROP, RenderLayer.getCutout());
        BlockRenderLayerMapImpl.INSTANCE.putBlock(Declarar.GROWABLEARMSCROP, RenderLayer.getCutout());
        BlockRenderLayerMapImpl.INSTANCE.putBlock(Declarar.FAIRYJARBLOCK,RenderLayer.getCutout());

        EntityRendererRegistry.INSTANCE.register(Declarar.FAIRYENTITY,FairyEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(Declarar.FAIRY_JAR_ENTITY,(BlockEntityRendererFactory.Context rendererDispatcherIn) -> new FairyJarEntityRenderer());

    }
}
