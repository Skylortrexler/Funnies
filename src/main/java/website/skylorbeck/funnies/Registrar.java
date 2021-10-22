package website.skylorbeck.funnies;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class Registrar {
    public static void register(){
        regItem("can_of_beans",Declarar.CANOFBEANS);
        regBlock("can_of_beans_crop",Declarar.CANOFBEANSCROP);
        regItem("can_of_beans_seed",Declarar.CANOFBEANSSEED);
        regBlock("growable_arms_crop",Declarar.GROWABLEARMSCROP);
        regItem("growable_arms_seed",Declarar.GROWABLEARMSSEED);
    }



    public static void regBlock(String blockID,Block block){
        Registry.register(Registry.BLOCK,Declarar.getIdentifier(blockID),block);
    }
    public static void regItem(String itemID, Item item){
        Registry.register(Registry.ITEM,Declarar.getIdentifier(itemID),item);
    }
}
