package wishai.applyos.entity.ui.component;

import net.minecraft.client.gui.GuiLabel;
import wishai.applyos.entity.ui.OSGui;

import java.util.List;

public class LabelView extends OSView {

    private String text;
    private int width;
    private boolean isRendered;


    public LabelView(String text, int width) {
        this.text = text;
        this.width = width;
        this.isRendered = false;
    }

    @Override
    public void render(OSGui gui, int x, int y) {
        super.render(gui, x, y);

        OSGui.GuiCanvas canvas = gui.getCanvas();

        if (canvas != null && !isRendered) {
            List<GuiLabel> labels = canvas.getLabelList();
            GuiLabel label = new GuiLabel(canvas.getFontRenderer(), labels.size() + 1, x + canvas.getGuiLeft(), y + canvas.getGuiTop(), width, SLOT_SIZE, 0xFFFFFF);
            label.addLine(text);
            labels.add(label);
            isRendered = true;
        }
    }

    @Override
    protected void render(OSGui gui) {
    }

}
