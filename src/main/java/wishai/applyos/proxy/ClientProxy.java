package wishai.applyos.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.Collection;


@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    private static Collection<Item> renderers = new ArrayList<>();

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        renderers.addAll(items);
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
    }

    @SubscribeEvent
    public static void registerRendersEvent(ModelRegistryEvent evt) {
        for (Item renderer : renderers) {
            registerRender(renderer);
        }
    }

}
