package wishai.applyos.entity.ui.component;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import wishai.applyos.ApplyOSMod;
import wishai.applyos.entity.ui.OSGui;

public class SlotView extends OSView {

    private static final ResourceLocation SLOT_TEXTURE = new ResourceLocation(ApplyOSMod.MOD_ID, "textures/guis/slot.png");

    private IItemHandler inventory;
    private int index;


    public SlotView(IItemHandler inventory, int idx) {
        this.inventory = inventory;
        this.index = idx;
    }

    @Override
    public void render(OSGui gui, int x, int y) {
        super.render(gui, x, y);

        gui.addSlotToContainer(new SlotItemHandler(inventory, index, x, y) {
            @Override
            public void onSlotChanged() {
                gui.getTileEntity().markDirty();
            }
        });
    }

    @Override
    public void render(OSGui gui) {
        OSGui.GuiCanvas canvas = gui.getCanvas();

        canvas.setTexture(SLOT_TEXTURE);
        canvas.drawTexturedModalRect(0, 0, 0, 0, 16, 16);
    }

}
