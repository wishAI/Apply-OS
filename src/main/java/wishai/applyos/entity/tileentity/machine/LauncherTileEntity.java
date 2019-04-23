package wishai.applyos.entity.tileentity.machine;

import wishai.applyos.entity.tileentity.ItemProviderHandler;


public class LauncherTileEntity extends OSMachineTileEntity {

    public LauncherTileEntity() {
    }

    @Override
    public ItemProviderHandler createItemProvider() {
        return new ItemProviderHandler(9);
    }

}
