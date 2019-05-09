package wishai.applyos;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import wishai.applyos.proxy.ClientProxy;
import wishai.applyos.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;
import wishai.applyos.proxy.ServerProxy;


@Mod(ApplyOSMod.MOD_ID)
public class ApplyOSMod {

    public static final String MOD_ID = "applyos";
    public static final String MOD_NAME = "ApplyOS";
    public static final String MOD_VERSION= "0.0.2 alpha";

    public static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
    public static final Logger logger = LogManager.getLogger();


    public ApplyOSMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::preInit);

        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.GUIFACTORY, );
    }

    public void preInit(final FMLCommonSetupEvent event) {
        proxy.preInit(event);

//        NetworkRegistry.INSTANCE.registerGuiHandler(this, new OSGuiHandler());
    }
//
//    @Mod.EventHandler
//    public void init(FMLInitializationEvent e) {
//        proxy.init(e);
//    }
//
//    @Mod.EventHandler
//    public void postInit(FMLPostInitializationEvent e) {
//        proxy.postInit(e);
//    }

}
