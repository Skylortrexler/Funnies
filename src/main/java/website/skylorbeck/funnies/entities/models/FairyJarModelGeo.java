package website.skylorbeck.funnies.entities.models;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import website.skylorbeck.funnies.Declarar;
import website.skylorbeck.funnies.entities.FairyEntity;
import website.skylorbeck.funnies.entities.FairyJarEntity;

public class FairyJarModelGeo extends AnimatedGeoModel<FairyJarEntity> {
    @Override
    public Identifier getModelLocation(FairyJarEntity object) {
        return Declarar.getIdentifier("geo/fairyjar.geo.json");

    }

    @Override
    public Identifier getTextureLocation(FairyJarEntity object) {
        return Declarar.getIdentifier("textures/block/fairyjar.png");
    }

    @Override
    public Identifier getAnimationFileLocation(FairyJarEntity animatable) {
        return Declarar.getIdentifier("animations/fairyjar.animation.json");
    }
}