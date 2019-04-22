package wishai.applyos.entity.block.machine;


import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import wishai.applyos.entity.tileentity.machine.LauncherTileEntity;
import wishai.applyos.entity.ui.OSGuiHandler;

import javax.annotation.Nullable;

public class LauncherBlock extends OSMachineBlock {

    public static final String LAUNCHER_BLOCK = "launcher";


    public LauncherBlock() {
        super(LAUNCHER_BLOCK);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new LauncherTileEntity();
    }

    @Override
    protected int createGui() {
        return OSGuiHandler.LAUNCHER;
    }
}
