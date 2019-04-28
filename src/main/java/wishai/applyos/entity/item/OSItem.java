package wishai.applyos.entity.item;

import net.minecraft.item.Item;
import wishai.applyos.ApplyOSMod;
import wishai.applyos.entity.ui.OSTab;


public class OSItem extends Item {

    public OSItem(String name) {
        setUnlocalizedName(ApplyOSMod.MOD_ID + "." + name);
        if (name.lastIndexOf(".") >= 0)
            name = name.substring(name.lastIndexOf(".") + 1);
        setRegistryName(name);
        setCreativeTab(OSTab.getInstance());
    }

}

