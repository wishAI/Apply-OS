package wishai.applyos.entity.ui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class OSGuiHandler implements IGuiHandler {

    public static final int LAUNCHER = 1;
    public static final int FILE_MANAGER = 2;

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return getCommonGuiElement(ID, player, world, x, y, z);
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return getCommonGuiElement(ID, player, world, x, y, z);
    }

    private Object getCommonGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);

        switch (ID) {
            case LAUNCHER:
                return new LauncherGui();
            case FILE_MANAGER:
                return null;
        }

        return null;
    }

}
