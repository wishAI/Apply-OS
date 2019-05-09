package wishai.applyos.entity.tileentity.machine;


import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.util.LazyOptional;
import wishai.applyos.entity.tileentity.ItemProviderHandler;
import wishai.applyos.entity.tileentity.OSTileEntityTypeFactory;
import wishai.applyos.entity.ui.machine.FilesGui;


@OSMachine(gui = FilesGui.class)
public class FileTileEntity extends OSMachineTileEntity {

    public FileTileEntity() {
        super(OSTileEntityTypeFactory.getTileEntityType(FileTileEntity.class));
    }

    @Override
    public LazyOptional<ItemProviderHandler> createItemProvider() {
        return new LazyOptional<>(ItemProviderHandler::new);
    }

}
