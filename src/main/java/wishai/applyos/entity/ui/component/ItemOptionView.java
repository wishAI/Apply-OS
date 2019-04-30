package wishai.applyos.entity.ui.component;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import wishai.applyos.entity.ui.OSGui;

public class ItemOptionView extends OSMultiView {

    public static final int OPTION_WIDTH = 30;
    public static final int OPTION_HEIGHT = 28;

    private boolean selected;


    public ItemOptionView(ItemStack stack, String text) {
        add(new ItemView(stack), (OPTION_WIDTH - UNIT_SIZE) / 2, 1);
        add(new LabelView(text, OPTION_WIDTH), 0, OPTION_HEIGHT - 14);
        this.selected = true;
    }

    public ItemOptionView(Item item, String text) {
        this(new ItemStack(item), text);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    protected void render(OSGui gui) {
        OSGui.GuiCanvas canvas = gui.getCanvas();

        // draw background box if selected
        canvas.setTexture(COMPONENTS_TEXTURE);
        canvas.drawTexturedModalRect(0, 0, 0, UNIT_SIZE, OPTION_WIDTH, UNIT_SIZE);
        canvas.drawTexturedModalRect(0, OPTION_HEIGHT - UNIT_SIZE, 0, UNIT_SIZE, OPTION_WIDTH, UNIT_SIZE);

        super.render(gui);
    }

}
