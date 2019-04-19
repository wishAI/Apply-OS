package wishai.applyos.entity.block;


import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class LauncherBlock extends OSMachineBlock {

    public static final String LAUNCHER_BLOCK = "launcher";


    public LauncherBlock() {
        super(LAUNCHER_BLOCK);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }

}
