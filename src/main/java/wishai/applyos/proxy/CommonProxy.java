package wishai.applyos.proxy;


import wishai.applyos.entity.block.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        File dir = e.getModConfigurationDirectory();
//        Configuration config = new Configuration(new File(dir.getPath()), "applyos.cfg");
//        Config.initConfig(config);
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> evt) {
        List<Block> blocks = new ArrayList<>();
        blocks.add(OSBlockFactory.getBlock(LauncherBlock.class));
        blocks.add(OSBlockFactory.getBlock(FileBlock.class));

        for (Block block: blocks) {
            evt.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> evt) {
        List<Item> items = new ArrayList<>();
        items.add(OSItemFactory.getItem(LauncherBlock.class).setRegistryName(LauncherBlock.LAUNCHER_BLOCK));
        items.add(OSItemFactory.getItem(FileBlock.class).setRegistryName(FileBlock.FILE_BLOCK));

        for (Item item: items) {
            evt.getRegistry().register(item);
        }
    }

}

