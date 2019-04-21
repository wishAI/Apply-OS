package wishai.applyos.entity.ui.component;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import wishai.applyos.entity.tileentity.OSTileEntity;
import wishai.applyos.entity.ui.OSGui;

public class PlayerInventoryView extends OSView {


    public PlayerInventoryView(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(OSGui gui) {
    }

    private class ContainerPedestal extends Container {
        public ContainerPedestal(InventoryPlayer playerInv, final OSTileEntity pedestal) {
            IItemHandler inventory = pedestal.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
            addSlotToContainer(new SlotItemHandler(inventory, 0, 80, 35) {
                @Override
                public void onSlotChanged() {
                    pedestal.markDirty();
                }
            });

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 9; j ++) {
                    addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
                }
            }

            for (int k = 0; k < 9; k ++) {
                addSlotToContainer(new Slot(playerInv, k, 8 + k * 18, 142));
            }
        }

        @Override
        public boolean canInteractWith(EntityPlayer playerIn) {
            return true;
        }
    }
}
