package wishai.applyos.entity.item;

import net.minecraft.item.Item;
import wishai.applyos.ApplyOSMod;
import wishai.applyos.entity.ui.OSItemGroup;


public class OSItem extends Item {

    public OSItem(String name, Item.Properties properties) {
        super(properties.group(OSItemGroup.getInstance()));
//        setUnlocalizedName(ApplyOSMod.MOD_ID + "." + name);
        if (name.lastIndexOf(".") >= 0)
            name = name.substring(name.lastIndexOf(".") + 1);
        setRegistryName(name);
    }

    public OSItem(String name) {
        this(name, new Item.Properties());
    }

}

