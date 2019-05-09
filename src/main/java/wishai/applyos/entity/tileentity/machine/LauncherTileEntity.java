package wishai.applyos.entity.tileentity.machine;

import net.minecraftforge.common.util.LazyOptional;
import wishai.applyos.entity.tileentity.ItemProviderHandler;
import wishai.applyos.entity.tileentity.OSTileEntityTypeFactory;
import wishai.applyos.entity.ui.machine.LauncherGui;


@OSMachine(gui = LauncherGui.class)
public class LauncherTileEntity extends OSMachineTileEntity {

    public LauncherTileEntity() {
        super(OSTileEntityTypeFactory.getTileEntityType(LauncherTileEntity.class));
    }

    @Override
    public LazyOptional<ItemProviderHandler> createItemProvider() {
        return new LazyOptional<>(ItemProviderHandler::new);
    }

}
