package wishai.applyos.entity.tileentity.machine;


import net.minecraftforge.items.ItemStackHandler;
import wishai.applyos.entity.tileentity.ItemProviderHandler;


public class FileTileEntity extends OSMachineTileEntity {

    @Override
    public ItemProviderHandler createItemProvider() {
        return new ItemProviderHandler(9);
    }

}
