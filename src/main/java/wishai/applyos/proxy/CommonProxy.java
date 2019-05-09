package wishai.applyos.proxy;


import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ObjectHolder;
import wishai.applyos.ApplyOSMod;
import wishai.applyos.entity.block.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import wishai.applyos.entity.item.OSItemFactory;
import wishai.applyos.entity.tileentity.OSTileEntityTypeFactory;
import wishai.applyos.entity.tileentity.machine.FileTileEntity;
import wishai.applyos.entity.tileentity.machine.LauncherTileEntity;
import wishai.applyos.entity.tileentity.machine.OSMachineTileEntity;

import java.util.ArrayList;
import java.util.Collection;


@Mod.EventBusSubscriber(modid = ApplyOSMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(ApplyOSMod.MOD_ID)
public class CommonProxy {

    protected static Collection<Item> items = new ArrayList<>();
    private static Collection<Block> blocks = new ArrayList<>();
    private static Collection<Class<? extends TileEntity>> tileEntityTypes = new ArrayList<>();


    public void preInit(FMLCommonSetupEvent e) {
//        File dir = e.getModConfigurationDirectory();
//        Configuration config = new Configuration(new File(dir.getPath()), "applyos.cfg");
//        Config.initConfig(config);

        // register regular blocks
        registerRegularBlock(Material.IRON, MaterialColor.BLACK, "machine_base");

        // register machines
        registerMachine(FileTileEntity.class);
        registerMachine(LauncherTileEntity.class);
        registerOre("silicon", "dust", false, false);
    }

//    public void init(FMLInitializationEvent e) {
//    }
//
//    public void postInit(FMLPostInitializationEvent e) {
//    }

    private static void registerMachine(Class<? extends OSMachineTileEntity> tileEntityClass) {
        // register tile entity
        registerTileEntity(tileEntityClass);

        // register block
        Block block = OSBlockFactory.getMachineBlock(tileEntityClass);
        blocks.add(block);

        // register block item
        items.add(OSItemFactory.getMachineItem(tileEntityClass));

        // register machine app
        items.add(OSItemFactory.getMachineAppItem(tileEntityClass));
    }

    // TODO: add blocktag and fire
    private static void registerOre(String oreName, String productType, boolean hasCorn, boolean needFire) {
        // register ore block and blockItem
        Block block = registerRegularBlock(Material.ROCK, MaterialColor.STONE, "ore_" + oreName);
        String upperName = oreName.substring(0, 1).toUpperCase() + oreName.substring(1);
//        OreDictionary.registerOre("ore" + upperName, block);

        // register product of ore
        Item product = registerRegularItem(productType + "_" + oreName);
//        OreDictionary.registerOre(productType + upperName, product);
        if (hasCorn) {
            Item nugget = registerRegularItem("nugget_" + oreName);
//            OreDictionary.registerOre("nugget" + upperName, corn);
        }

        // register furnace recipe of ore
        if (needFire) {
        }
    }

    private static Block registerRegularBlock(Material material, MaterialColor mapColor, String name) {
        // register block
        Block block = OSBlockFactory.getRegularBlock(material, mapColor, name);
        blocks.add(block);

        // register block item
        items.add(OSItemFactory.getRegularBlockItem(block));

        return block;
    }

    private static Item registerRegularItem(String name) {
        // register item
        Item item = OSItemFactory.getRegularItem(name);
        items.add(item);

        return item;
    }

    private static void registerTileEntity(Class tileEntity) {
        tileEntityTypes.add(tileEntity);
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

    @SubscribeEvent
    public static void registerTileEntitiesEvent(RegistryEvent.Register<TileEntityType<?>> evt) {
        for (Class<? extends TileEntity> tileEntityClass : tileEntityTypes) {
            TileEntityType<?> type = OSTileEntityTypeFactory.getTileEntityType(tileEntityClass);
            type.setRegistryName(ApplyOSMod.MOD_ID, tileEntityClass.getName());
            evt.getRegistry().register(type);
        }
        tileEntityTypes.clear();
    }

}

