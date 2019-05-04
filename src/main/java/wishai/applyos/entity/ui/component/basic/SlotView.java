package wishai.applyos.entity.ui.component.basic;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import wishai.applyos.entity.ui.OSGui;

public class SlotView extends OSView {

    private IItemHandler inventory;
    private int index;
    private boolean isRendered;


    public SlotView(IItemHandler inventory, int idx) {
        this.inventory = inventory;
        this.index = idx;
        this.isRendered = false;
    }

    @Override
    public void render(OSGui gui, int x, int y) {
        super.render(gui, x, y);

        if (!isRendered) {
            gui.addSlotToContainer(new SlotItemHandler(inventory, index, x, y) {
                @Override
                public void onSlotChanged() {
                    gui.getTileEntity().markDirty();
                }
            });
            this.isRendered = true;
        }
    }

    @Override
    public void render(OSGui gui) {
        OSGui.GuiCanvas canvas = gui.getCanvas();

        canvas.setTexture(COMPONENTS_TEXTURE);
        canvas.drawTexturedModalRect(0, 0, 0, 0, UNIT_SIZE, UNIT_SIZE);
    }

}
