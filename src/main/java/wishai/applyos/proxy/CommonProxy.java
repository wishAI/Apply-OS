package wishai.applyos.proxy;


import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
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
import wishai.applyos.entity.item.OSItemFactory;
import wishai.applyos.entity.tileentity.machine.FileTileEntity;
import wishai.applyos.entity.tileentity.machine.LauncherTileEntity;
import wishai.applyos.entity.tileentity.machine.OSMachineTileEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;


@Mod.EventBusSubscriber
public class CommonProxy {

    protected static Collection<Item> items = new ArrayList<>();
    private static Collection<Block> blocks = new ArrayList<>();

    public void preInit(FMLPreInitializationEvent e) {
        File dir = e.getModConfigurationDirectory();
//        Configuration config = new Configuration(new File(dir.getPath()), "applyos.cfg");
//        Config.initConfig(config);

        // register regular blocks
        registerRegularBlock(Material.IRON, MapColor.BLACK, "machine_base");

        // register machines
        registerMachine(FileTileEntity.class);
        registerMachine(LauncherTileEntity.class);
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    private static void registerMachine(Class<? extends OSMachineTileEntity> tileEntityClass) {
        // register tile entity
        registerTileEntity(tileEntityClass);

        // register block
        OSBlock block = OSBlockFactory.getMachineBlock(tileEntityClass);
        blocks.add(block);

        // register block item
        items.add(OSItemFactory.getMachineItem(tileEntityClass));

        // register machine app
        items.add(OSItemFactory.getMachineAppItem(tileEntityClass));
    }

    private static void registerRegularBlock(Material material, MapColor mapColor, String name) {
        // register block
        OSBlock block = OSBlockFactory.getRegularBlock(material, mapColor, name);
        blocks.add(block);

        // register block item
        items.add(OSItemFactory.getRegularBlockItem(block));
    }

    private static void registerTileEntity(Class tileEntity) {
        GameRegistry.registerTileEntity(tileEntity, new ResourceLocation(ApplyOSMod.MOD_ID + ":" + tileEntity.getName().toLowerCase()));
    }

    @SubscribeEvent
    public static void registerBlocksEvent(RegistryEvent.Register<Block> evt) {
        for (Block block : blocks) {
            evt.getRegistry().register(block);
        }
        blocks.clear();
    }

    @SubscribeEvent
    public static void registerItemsEvent(RegistryEvent.Register<Item> evt) {
        for (Item item : items) {
            evt.getRegistry().register(item);
        }
        items.clear();
    }

}

