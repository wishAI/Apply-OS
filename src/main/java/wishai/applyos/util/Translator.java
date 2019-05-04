package wishai.applyos.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class Translator {

    public static String getTranslatedItemName(Item item) {
        ItemStack temp = new ItemStack(item);
        return temp.getDisplayName();
    }

}
