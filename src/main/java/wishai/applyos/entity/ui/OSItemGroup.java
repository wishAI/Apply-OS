package wishai.applyos.entity.ui;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import wishai.applyos.entity.block.OSBlockFactory;
import wishai.applyos.entity.tileentity.machine.LauncherTileEntity;

public class OSItemGroup extends ItemGroup {

    private static OSItemGroup instance = null;

    private OSItemGroup(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(OSBlockFactory.getMachineBlock(LauncherTileEntity.class));
    }

    @Override
    public String getTabLabel() {
        return "Apply OS";
    }

    public static OSItemGroup getInstance() {
        if (instance == null)
            instance = new OSItemGroup("Apply OS");
        return instance;
    }

}
