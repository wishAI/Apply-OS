package wishai.applyos.entity.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import wishai.applyos.entity.block.OSBlock;
import wishai.applyos.entity.block.OSBlockFactory;
import wishai.applyos.entity.tileentity.machine.OSMachineTileEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public class OSItemFactory {

    private static final Map<String, Item> items = new HashMap<>();


    public static Item getItem(Class<?> itemClass) {
        if (!OSItem.class.isAssignableFrom(itemClass))
            throw new RuntimeException("This is not an os item. ");

        String className = itemClass.getName();
        if (items.containsKey(items))
            return items.get(className);

        Item item = null;
        try {
            item = (Item) itemClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Item class not load! ");
        }

        items.put(className, item);
        return item;
    }

    public static Item getRegularBlockItem(OSBlock block) {
        Class blockClass = block.getClass();

        String className = blockClass.getName() + "." + getRegistryName(block);
        if (items.containsKey(className))
            return items.get(className);

        Item item = new ItemBlock(block).setRegistryName(getRegistryName(block));

        items.put(className, item);
        return item;
    }

    public static Item getMachineItem(Class<? extends OSMachineTileEntity> tileEntityClass) {
        if (!OSMachineTileEntity.class.isAssignableFrom(tileEntityClass))
            throw new RuntimeException("This is not an os machine tile entity. ");

        String className = tileEntityClass.getName();
        if (items.containsKey(className))
            return items.get(className);

        Block block = OSBlockFactory.getMachineBlock(tileEntityClass);
        if (block == null)
            throw new RuntimeException("Can not get machine block for item. ");
        Item item = new ItemBlock(block).setRegistryName(getRegistryName(block));

        items.put(className, item);
        return item;
    }

    public static Item getMachineAppItem() {
        return null;
    }

    private static String getRegistryName(Block block) {
        String str = block.getRegistryName().toString();
        return str.substring(str.indexOf(":") + 1);
    }

}
