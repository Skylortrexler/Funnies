package website.skylorbeck.funnies.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.render.RenderLayer;
import website.skylorbeck.funnies.Declarar;

@Environment(EnvType.CLIENT)
public class FunniesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMapImpl.INSTANCE.putBlock(Declarar.CANOFBEANSCROP, RenderLayer.getCutout());
    }
}
