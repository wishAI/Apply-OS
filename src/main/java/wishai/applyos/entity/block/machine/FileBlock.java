package wishai.applyos.entity.block.machine;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import wishai.applyos.entity.tileentity.machine.FileTileEntity;
import wishai.applyos.entity.ui.OSGuiHandler;

import javax.annotation.Nullable;

public class FileBlock extends OSMachineBlock {

    public static final String FILE_BLOCK = "file";


    public FileBlock() {
        super(FILE_BLOCK);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new FileTileEntity();
    }

    @Override
    protected int createGui() {
        return OSGuiHandler.FILE_MANAGER;
    }
}
