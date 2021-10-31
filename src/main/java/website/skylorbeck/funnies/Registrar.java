package website.skylorbeck.funnies;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.impl.biome.modification.BiomeModificationImpl;
import net.minecraft.block.Block;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
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
        regItem("fairy_dust_item",Declarar.FAIRYDUST);
        regBlock("fairy_dust_block",Declarar.FAIRYDUSTBLOCK);
        regItem("fairy_dust_block_item",Declarar.FAIRYDUSTBLOCKITEM);

        FabricDefaultAttributeRegistry.register(Declarar.FAIRYENTITY, FairyEntity.createBeeAttributes());
        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.CREATURE, Declarar.FAIRYENTITY,10,1,2);
        RegistryKey<ConfiguredFeature<?, ?>> fairy_dust_ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                Declarar.getIdentifier("fairy_dust_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, fairy_dust_ore.getValue(), Declarar.FAIRYDUSTFEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, fairy_dust_ore);
    }



    public static void regBlock(String blockID,Block block){
        Registry.register(Registry.BLOCK,Declarar.getIdentifier(blockID),block);
    }
    public static void regItem(String itemID, Item item){
        Registry.register(Registry.ITEM,Declarar.getIdentifier(itemID),item);
    }
}
