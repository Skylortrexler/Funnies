package website.skylorbeck.funnies.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.AboveGroundTargeting;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import website.skylorbeck.funnies.Declarar;

import java.util.EnumSet;
import java.util.UUID;

public class FairyEntity extends BeeEntity implements Angerable, IAnimatable {
    private static final TrackedData<Integer> ANGER = DataTracker.registerData(FairyEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);

    private UUID targetUuid;

    public FairyEntity(EntityType<? extends BeeEntity> entityType, World world) {
        super(entityType, world);
    }
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ANGER, 0);
    }

        @Override
    protected void mobTick() {
        if (!this.world.isClient) {
            this.tickAngerLogic((ServerWorld) this.world, false);
        }

    }


    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (player.getStackInHand(hand).isOf(Items.GLASS_BOTTLE)) {
            this.discard();
            ItemStack itemStack = new ItemStack(Declarar.FAIRYJAR);
            itemStack.setCount(1);
            player.getStackInHand(hand).decrement(1);
            player.giveItemStack(itemStack);
        }
        return super.interactMob(player, hand);
    }

    @Override
    public boolean hasHive() {
        return false;
    }

    @Nullable
    @Override
    public BlockPos getHivePos() {
        return super.getHivePos();
    }

    @Override
    public boolean hasNectar() {
        return false;
    }

    @Override
    public boolean hasStung() {
        return false;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Declarar.FAIRYDUST);
    }
    public FairyEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return Declarar.FAIRYENTITY.create(serverWorld);
    }


    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        super.playStepSound(pos, state);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return super.getHurtSound(source);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return super.getDeathSound();
    }

    public int getAngerTime() {
        return (Integer)this.dataTracker.get(ANGER);
    }

    public void setAngerTime(int ticks) {
        this.dataTracker.set(ANGER, ticks);
    }

    public UUID getAngryAt() {
        return this.targetUuid;
    }

    public void setAngryAt(@Nullable UUID uuid) {
        this.targetUuid = uuid;
    }

    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }


//geckolib stuff

    private AnimationFactory factory = new AnimationFactory(this);
    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "main", 5, this::mainpred));
        animationData.addAnimationController(new AnimationController(this, "seconday", 5, this::secondarypred));
        animationData.addAnimationController(new AnimationController(this, "wings", 0,this::wingpred));
    }

    private <E extends IAnimatable> PlayState mainpred(AnimationEvent<E> event) {
        if (event.isMoving())
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.fairy.flya", true));
        else
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.fairy.idle", true));

        return PlayState.CONTINUE;
    }
    private <E extends IAnimatable> PlayState secondarypred(AnimationEvent<E> event) {
        if (event.isMoving())
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.fairy.flyb", true));
        return PlayState.CONTINUE;
    }
    private <E extends IAnimatable> PlayState wingpred(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.fairy.wings", true));
        return PlayState.CONTINUE;
    }


    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
