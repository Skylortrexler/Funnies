package website.skylorbeck.funnies.funnies;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Registrar {
    public void regBlock(String blockID,Block block){
        Registry.register(Registry.BLOCK,Declarar.getIdentifier(blockID),block);
    }
    public void regItem(String itemID, Item item){
        Registry.register(Registry.ITEM,Declarar.getIdentifier(itemID),item);
    }
}
