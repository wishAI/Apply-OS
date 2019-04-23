package wishai.applyos.entity.ui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import wishai.applyos.entity.tileentity.OSTileEntity;
import wishai.applyos.entity.ui.machine.FileManagerGui;
import wishai.applyos.entity.ui.machine.LauncherGui;

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
        return getCommonGuiElement(ID, player, world, x, y, z).getCanvas();
    }

    private OSGui getCommonGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        InventoryPlayer playerInv = player.inventory;
        OSTileEntity tileEntity = (OSTileEntity) world.getTileEntity(pos);

        switch (ID) {
            case LAUNCHER:
                return new LauncherGui(playerInv, tileEntity);
            case FILE_MANAGER:
                return new FileManagerGui(playerInv, tileEntity);
        }

        throw new RuntimeException("GUI with index not found.");
    }

}
