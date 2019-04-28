package wishai.applyos;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import wishai.applyos.entity.ui.OSGuiHandler;
import wishai.applyos.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


@Mod(modid = ApplyOSMod.MOD_ID, name = ApplyOSMod.MOD_NAME, version = ApplyOSMod.MOD_VERSION, useMetadata = true)
public class ApplyOSMod {

    public static final String MOD_ID = "applyos";
    public static final String MOD_NAME = "ApplyOS";
    public static final String MOD_VERSION= "0.0.2 alpha";


    @SidedProxy(clientSide = "wishai.applyos.proxy.ClientProxy", serverSide = "wishai.applyos.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance public static ApplyOSMod instance;

    public static Logger logger;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new OSGuiHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

}
