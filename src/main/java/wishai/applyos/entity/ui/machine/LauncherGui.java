package wishai.applyos.entity.ui.machine;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import wishai.applyos.entity.tileentity.OSTileEntity;
import wishai.applyos.entity.ui.OSGui;
import wishai.applyos.entity.ui.component.ButtonView;
import wishai.applyos.entity.ui.component.ItemView;
import wishai.applyos.entity.ui.component.LabelView;
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
        add(new SlotView(itemProvider, 0), 18, 35);
        add(new ButtonView("V", 50), 0, 0);
        add(new ItemView(Items.APPLE), 60, 0);
        add(new LabelView("label", 50), 0, 50);
    }

}
