package website.skylorbeck.funnies;

import net.fabricmc.api.ModInitializer;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

public class Funnies implements ModInitializer {
    @Override
    public void onInitialize() {
        GeckoLibMod.DISABLE_IN_DEV = true;
        GeckoLib.initialize();
        Registrar.register();
    }
}
