package wishai.applyos.entity.ui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import wishai.applyos.entity.block.LauncherBlock;
import wishai.applyos.entity.block.OSBlockFactory;
import wishai.applyos.entity.block.OSItemFactory;

public class OSTab extends CreativeTabs {

    private static OSTab OSTab = null;

    private OSTab(String label) {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(OSBlockFactory.getBlock(LauncherBlock.class));
    }

    @Override
    public String getTranslatedTabLabel() {
        return "Apply OS";
    }

    public static OSTab getInstance() {
        if (OSTab == null)
            OSTab = new OSTab("Apply OS");
        return OSTab;
    }
}
