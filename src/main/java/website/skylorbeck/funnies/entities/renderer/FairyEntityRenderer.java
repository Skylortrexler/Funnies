package website.skylorbeck.funnies.entities.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import website.skylorbeck.funnies.Declarar;
import website.skylorbeck.funnies.entities.FairyEntity;
import website.skylorbeck.funnies.entities.models.FairyEntityModel;

public class FairyEntityRenderer extends MobEntityRenderer<FairyEntity, FairyEntityModel<FairyEntity>> {
    public FairyEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new FairyEntityModel<>(context.getPart(EntityModelLayers.BEE)), 0.5f);
    }

    @Override
    public Identifier getTexture(FairyEntity entity) {
        if (entity.hasAngerTime()) {
            return Declarar.getIdentifier("textures/entity/fairy/fairy_mad.png");//red when angry
        } else {
            return Declarar.getIdentifier("textures/entity/fairy/fairy.png");
        }
    }
}
