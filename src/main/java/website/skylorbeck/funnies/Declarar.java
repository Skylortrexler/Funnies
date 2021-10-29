package website.skylorbeck.funnies;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import website.skylorbeck.funnies.blocks.ArmsCrop;
import website.skylorbeck.funnies.blocks.BeanBlock;
import website.skylorbeck.funnies.blocks.FairyJarBlock;
import website.skylorbeck.funnies.entities.FairyEntity;
import website.skylorbeck.funnies.entities.FairyJarEntity;
import website.skylorbeck.funnies.items.FairyJar;

public class Declarar {
    public static final Item CANOFBEANS = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(4).build()).group(ItemGroup.FOOD).rarity(Rarity.UNCOMMON).maxCount(16));
    public static final Block CANOFBEANSCROP = new BeanBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final Item CANOFBEANSSEED = new AliasedBlockItem(CANOFBEANSCROP,new FabricItemSettings().group(ItemGroup.MATERIALS));

    public static final Block GROWABLEARMSCROP = new ArmsCrop(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final Item GROWABLEARMSSEED = new AliasedBlockItem(GROWABLEARMSCROP,new FabricItemSettings().group(ItemGroup.MATERIALS));

    public static final Block FAIRYJARBLOCK = new FairyJarBlock(FabricBlockSettings.copyOf(Blocks.TORCH));
    public static final Item FAIRYJAR = new FairyJar(FAIRYJARBLOCK,new FabricItemSettings().group(ItemGroup.MISC));

    public static final BlockEntityType<FairyJarEntity> FAIRY_JAR_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,Declarar.getIdentifier("fairyjar"), FabricBlockEntityTypeBuilder.create(FairyJarEntity::new,FAIRYJARBLOCK).build(null));
    public static final EntityType<FairyEntity> FAIRYENTITY = Registry.register(Registry.ENTITY_TYPE,Declarar.getIdentifier("fairy"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,FairyEntity::new).dimensions(EntityDimensions.fixed(0.7F, 0.6F)).trackRangeBlocks(8).build());

    public static final String MODID = "funnies";

    public static Identifier getIdentifier(String string){
        return new Identifier(MODID,string);
    }
}
