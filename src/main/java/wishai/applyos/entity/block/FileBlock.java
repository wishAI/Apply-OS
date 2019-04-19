package wishai.applyos.entity.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class FileBlock extends OSMachineBlock {

    public static final String FILE_BLOCK = "file";


    public FileBlock() {
        super(FILE_BLOCK);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }

}
