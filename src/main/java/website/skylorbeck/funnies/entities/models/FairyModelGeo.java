package website.skylorbeck.funnies.entities.models;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import website.skylorbeck.funnies.Declarar;
import website.skylorbeck.funnies.entities.FairyEntity;

public class FairyModelGeo extends AnimatedGeoModel<FairyEntity> {
    @Override
    public Identifier getModelLocation(FairyEntity object) {
        return Declarar.getIdentifier("geo/fairymodel.geo.json");

    }

    @Override
    public Identifier getTextureLocation(FairyEntity object) {
        return Declarar.getIdentifier("textures/entity/fairy/fairy.png");
    }

    @Override
    public Identifier getAnimationFileLocation(FairyEntity animatable) {
        return Declarar.getIdentifier("animations/fairy.animation.json");
    }
}