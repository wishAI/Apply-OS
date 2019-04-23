package wishai.applyos.entity.ui.machine;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import wishai.applyos.entity.tileentity.OSTileEntity;
import wishai.applyos.entity.ui.OSGui;
import wishai.applyos.entity.ui.component.SlotView;

public class LauncherGui extends OSGui {

    public LauncherGui(InventoryPlayer playerInv, OSTileEntity tileEntity) {
        super(playerInv, tileEntity);
    }

    @Override
    protected void addTileEntityViews() {
        super.addTileEntityViews();

        IItemHandler itemProvider = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);

        // add item provider views
        for (int i = 0; i < 9; i ++) {
            add(new SlotView(itemProvider, i), 18 * i, 35);
        }
    }

}
