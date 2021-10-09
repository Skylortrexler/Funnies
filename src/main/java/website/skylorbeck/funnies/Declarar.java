package website.skylorbeck.funnies;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class Declarar {
    public static final Item CANOFBEANS = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(4).build()).group(ItemGroup.FOOD).rarity(Rarity.UNCOMMON).maxCount(16));

    public static final String MODID = "funnies";

    public static Identifier getIdentifier(String string){
        return new Identifier(MODID,string);
    }
}
