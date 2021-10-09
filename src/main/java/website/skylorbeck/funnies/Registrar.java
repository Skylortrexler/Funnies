package website.skylorbeck.funnies;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class Registrar {
    public static void register(){
        regItem("can_of_beans",Declarar.CANOFBEANS);
    }



    public static void regBlock(String blockID,Block block){
        Registry.register(Registry.BLOCK,Declarar.getIdentifier(blockID),block);
    }
    public static void regItem(String itemID, Item item){
        Registry.register(Registry.ITEM,Declarar.getIdentifier(itemID),item);
    }
}
