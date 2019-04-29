package wishai.applyos.entity.tileentity.machine;


import wishai.applyos.entity.tileentity.ItemProviderHandler;
import wishai.applyos.entity.ui.OSGuiHandler;


@OSMachine(gui = OSGuiHandler.FILE_MANAGER)
public class FileTileEntity extends OSMachineTileEntity {

    @Override
    public ItemProviderHandler createItemProvider() {
        return new ItemProviderHandler();
    }

}
