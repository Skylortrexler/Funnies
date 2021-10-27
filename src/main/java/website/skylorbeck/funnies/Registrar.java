package website.skylorbeck.funnies;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import website.skylorbeck.funnies.entities.FairyEntity;

public class Registrar {
    public static void register(){
        regItem("can_of_beans",Declarar.CANOFBEANS);
        regBlock("can_of_beans_crop",Declarar.CANOFBEANSCROP);
        regItem("can_of_beans_seed",Declarar.CANOFBEANSSEED);
        regBlock("growable_arms_crop",Declarar.GROWABLEARMSCROP);
        regItem("growable_arms_seed",Declarar.GROWABLEARMSSEED);
        regBlock("fairy_jar_block",Declarar.FAIRYJARBLOCK);
        regItem("fairy_jar_item",Declarar.FAIRYJAR);

        FabricDefaultAttributeRegistry.register(Declarar.FAIRYENTITY, FairyEntity.createBeeAttributes());
        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.CREATURE, Declarar.FAIRYENTITY,10,1,2);

    }



    public static void regBlock(String blockID,Block block){
        Registry.register(Registry.BLOCK,Declarar.getIdentifier(blockID),block);
    }
    public static void regItem(String itemID, Item item){
        Registry.register(Registry.ITEM,Declarar.getIdentifier(itemID),item);
    }
}
