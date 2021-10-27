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
import website.skylorbeck.funnies.Declarar;

import java.util.EnumSet;

public class FairyEntity extends BeeEntity implements Angerable {

    public FairyEntity(EntityType<? extends BeeEntity> entityType, World world) {
        super(entityType, world);
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
        return false;
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

}
