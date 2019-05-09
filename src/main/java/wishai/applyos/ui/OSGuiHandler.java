package wishai.applyos.ui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.network.FMLPlayMessages;


public class OSGuiHandler {

    // TODO: clear deprecated code
//    public static final int LAUNCHER = 1;
//    public static final int FILE_MANAGER = 2;


//    @Nullable
//    @Override
//    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
//        return getCommonGuiElement(ID, player, world, x, y, z);
//    }
//
//    @Nullable
//    @Override
//    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
//        return getCommonGuiElement(ID, player, world, x, y, z).getCanvas();
//    }
//
//    private OSGui getCommonGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
//        BlockPos pos = new BlockPos(x, y, z);
//        InventoryPlayer playerInv = player.inventory;
//        OSTileEntity tileEntity = (OSTileEntity) world.getTileEntity(pos);
//
//        switch (ID) {
//            case LAUNCHER:
//                return new LauncherGui(playerInv, tileEntity);
//            case FILE_MANAGER:
//                return new FilesGui(playerInv, tileEntity);
//        }
//
//        throw new RuntimeException("GUI with index not found.");
//    }

    public static GuiScreen openGui(FMLPlayMessages.OpenContainer container) {
        // TODO: try to get container by id
        System.out.println(container.getId().toString());
        return null;
    }

}
