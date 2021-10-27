package website.skylorbeck.funnies.entities.models;

import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.util.math.MathHelper;
import website.skylorbeck.funnies.entities.FairyEntity;


@Environment(EnvType.CLIENT)
public class FairyEntityModel<T extends FairyEntity> extends AnimalModel<T> {
	private static final float BONE_BASE_Y_PIVOT = 19.0F;
	private static final String BONE = "bone";
	private static final String FRONT_LEGS = "front_legs";
	private static final String MIDDLE_LEGS = "middle_legs";
	private static final String BACK_LEGS = "back_legs";
	private final ModelPart bone;
	private final ModelPart rightWing;
	private final ModelPart leftWing;
	private final ModelPart frontLegs;
	private final ModelPart middleLegs;
	private final ModelPart backLegs;
	private float bodyPitch;

	public FairyEntityModel(ModelPart modelPart) {
		super(false, 24.0F, 0.0F);
		this.bone = modelPart.getChild(BONE);
		ModelPart modelPart2 = this.bone.getChild(EntityModelPartNames.BODY);
		this.rightWing = this.bone.getChild(EntityModelPartNames.RIGHT_WING);
		this.leftWing = this.bone.getChild(EntityModelPartNames.LEFT_WING);
		this.frontLegs = this.bone.getChild(FRONT_LEGS);
		this.middleLegs = this.bone.getChild(MIDDLE_LEGS);
		this.backLegs = this.bone.getChild(BACK_LEGS);
	}

	public static TexturedModelData getTexturedModelData() {
		float f = BONE_BASE_Y_PIVOT;
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData modelPartData2 = modelPartData.addChild(BONE, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, f, 0.0F));
		Dilation dilation = new Dilation(0.001F);
		modelPartData2.addChild(EntityModelPartNames.RIGHT_WING, ModelPartBuilder.create().uv(0, 18).cuboid(-9.0F, 0.0F, 0.0F, 9.0F, 0.0F, 6.0F, dilation), ModelTransform.of(-1.5F, -4.0F, -3.0F, 0.0F, -0.2618F, 0.0F));
		modelPartData2.addChild(EntityModelPartNames.LEFT_WING, ModelPartBuilder.create().uv(0, 18).mirrored().cuboid(0.0F, 0.0F, 0.0F, 9.0F, 0.0F, 6.0F, dilation), ModelTransform.of(1.5F, -4.0F, -3.0F, 0.0F, 0.2618F, 0.0F));
		modelPartData2.addChild(FRONT_LEGS, ModelPartBuilder.create().cuboid(FRONT_LEGS, -5.0F, 0.0F, 0.0F, 7, 2, 0, 26, 1), ModelTransform.pivot(1.5F, 3.0F, -2.0F));
		modelPartData2.addChild(MIDDLE_LEGS, ModelPartBuilder.create().cuboid(MIDDLE_LEGS, -5.0F, 0.0F, 0.0F, 7, 2, 0, 26, 3), ModelTransform.pivot(1.5F, 3.0F, 0.0F));
		modelPartData2.addChild(BACK_LEGS, ModelPartBuilder.create().cuboid(BACK_LEGS, -5.0F, 0.0F, 0.0F, 7, 2, 0, 26, 5), ModelTransform.pivot(1.5F, 3.0F, 2.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	public void animateModel(T fairyEntity, float f, float g, float h) {
		super.animateModel(fairyEntity, f, g, h);
		this.bodyPitch = fairyEntity.getBodyPitch(h);
	}

	public void setAngles(T fairyEntity, float f, float g, float h, float i, float j) {
		this.rightWing.pitch = 0.0F;
		this.bone.pitch = 0.0F;
		boolean bl = fairyEntity.isOnGround() && fairyEntity.getVelocity().lengthSquared() < 1.0E-7D;
		float l;
		if (bl) {
			this.rightWing.yaw = -0.2618F;
			this.rightWing.roll = 0.0F;
			this.leftWing.pitch = 0.0F;
			this.leftWing.yaw = 0.2618F;
			this.leftWing.roll = 0.0F;
			this.frontLegs.pitch = 0.0F;
			this.middleLegs.pitch = 0.0F;
			this.backLegs.pitch = 0.0F;
		} else {
			l = h * 120.32113F * 0.017453292F;
			this.rightWing.yaw = 0.0F;
			this.rightWing.roll = MathHelper.cos(l) * 3.1415927F * 0.15F;
			this.leftWing.pitch = this.rightWing.pitch;
			this.leftWing.yaw = this.rightWing.yaw;
			this.leftWing.roll = -this.rightWing.roll;
			this.frontLegs.pitch = 0.7853982F;
			this.middleLegs.pitch = 0.7853982F;
			this.backLegs.pitch = 0.7853982F;
			this.bone.pitch = 0.0F;
			this.bone.yaw = 0.0F;
			this.bone.roll = 0.0F;
		}

		if (!fairyEntity.hasAngerTime()) {
			this.bone.pitch = 0.0F;
			this.bone.yaw = 0.0F;
			this.bone.roll = 0.0F;
			if (!bl) {
				l = MathHelper.cos(h * 0.18F);
				this.bone.pitch = 0.1F + l * 3.1415927F * 0.025F;
				this.frontLegs.pitch = -l * 3.1415927F * 0.1F + 0.3926991F;
				this.backLegs.pitch = -l * 3.1415927F * 0.05F + 0.7853982F;
				this.bone.pivotY = 19.0F - MathHelper.cos(h * 0.18F) * 0.9F;
			}
		}

		if (this.bodyPitch > 0.0F) {
			this.bone.pitch = ModelUtil.interpolateAngle(this.bone.pitch, 3.0915928F, this.bodyPitch);
		}

	}

	protected Iterable<ModelPart> getHeadParts() {
		return ImmutableList.of();
	}

	protected Iterable<ModelPart> getBodyParts() {
		return ImmutableList.of(this.bone);
	}
}
