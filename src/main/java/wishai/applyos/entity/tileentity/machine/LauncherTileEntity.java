package wishai.applyos.entity.tileentity.machine;

import net.minecraftforge.items.ItemStackHandler;
import wishai.applyos.entity.tileentity.ItemProviderHandler;

public class LauncherTileEntity extends OSMachineTileEntity {

    public LauncherTileEntity() {
    }

    @Override
    public ItemStackHandler createItemProvider() {
        return new ItemProviderHandler(9);
    }

}
