package website.skylorbeck.funnies.funnies;

import net.minecraft.util.Identifier;

public class Declarar {
    public static final String MODID = "funnies";

    public static Identifier getIdentifier(String string){
        return new Identifier(MODID+string);
    }
}
