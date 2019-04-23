package wishai.applyos.proxy;


import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wishai.applyos.ApplyOSMod;
import wishai.applyos.entity.block.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wishai.applyos.entity.block.machine.FileBlock;
import wishai.applyos.entity.block.machine.LauncherBlock;
import wishai.applyos.entity.tileentity.machine.FileTileEntity;
import wishai.applyos.entity.tileentity.machine.LauncherTileEntity;

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

        registerTileEntities();
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

    private static void registerTileEntities() {
        // register tile entities
        GameRegistry.registerTileEntity(LauncherTileEntity.class, new ResourceLocation(ApplyOSMod.MOD_ID + ":launchertileentity"));
        GameRegistry.registerTileEntity(FileTileEntity.class, new ResourceLocation(ApplyOSMod.MOD_ID + ":filetileentity"));
    }

}

