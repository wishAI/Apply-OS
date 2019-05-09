package wishai.applyos.ui.component.basic;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import wishai.applyos.ui.OSGui;


public class ItemView extends OSView {

    private ItemStack itemStack;


    public ItemView(Item item) {
        this(new ItemStack(item));
    }

    public ItemView(ItemStack itemStack) {
        this.itemStack = itemStack.copy();
    }

    @Override
    protected void render(OSGui gui) {
        OSGui.GuiCanvas canvas = gui.getCanvas();

        canvas.getItemRender().renderItemAndEffectIntoGUI(itemStack, 0, 0);
    }

}
