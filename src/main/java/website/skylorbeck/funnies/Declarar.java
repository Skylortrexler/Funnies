package website.skylorbeck.funnies;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import website.skylorbeck.funnies.blocks.ArmsCrop;
import website.skylorbeck.funnies.blocks.BeanBlock;

public class Declarar {
    public static final Item CANOFBEANS = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(4).build()).group(ItemGroup.FOOD).rarity(Rarity.UNCOMMON).maxCount(16));
    public static final Block CANOFBEANSCROP = new BeanBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final Item CANOFBEANSSEED = new AliasedBlockItem(CANOFBEANSCROP,new FabricItemSettings().group(ItemGroup.MATERIALS));

    public static final Block GROWABLEARMSCROP = new ArmsCrop(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).dropsNothing());
    public static final Item GROWABLEARMSSEED = new AliasedBlockItem(GROWABLEARMSCROP,new FabricItemSettings().group(ItemGroup.MATERIALS));


    public static final String MODID = "funnies";

    public static Identifier getIdentifier(String string){
        return new Identifier(MODID,string);
    }
}
