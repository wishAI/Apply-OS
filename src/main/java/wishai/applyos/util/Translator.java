package wishai.applyos.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;


public class Translator {

    public static String getTranslatedItemName(Item item) {
        ItemStack temp = new ItemStack(item);
        return temp.getDisplayName().getFormattedText();
    }

    public static String getTranslatedString(String key) {
        TextComponentTranslation text = new TextComponentTranslation(key);
        return text.getFormattedText();
    }

}
