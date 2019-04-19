package wishai.applyos.entity.block;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public class OSItemFactory {

    private static final Map<String, Item> foodItems = new HashMap<>();


    public static Item getItem(Class<?> itemClass) {
        boolean isItemBlock = false;
        if (!Item.class.isAssignableFrom(itemClass)) {
            if (OSBlock.class.isAssignableFrom(itemClass)) {
                isItemBlock = true;
            } else {
                throw new RuntimeException("The class is not a food block");
            }
        }

        String className = itemClass.getName();
        Item item = null;

        if (!foodItems.containsKey(className)) {
            if (!isItemBlock) {
                try {
                    item = (Item) itemClass.getConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException("Item class not load! ");
                }
            } else {
                item = new ItemBlock(OSBlockFactory.getBlock(itemClass));
            }
            foodItems.put(className, item);
            return item;
        }

        item = foodItems.get(className);
        if(item == null) {
            throw new NullPointerException();
        }
        return item;
    }

    public static Item getItem(OSBlock block) {
        return getItem(block.getClass());
    }

}
