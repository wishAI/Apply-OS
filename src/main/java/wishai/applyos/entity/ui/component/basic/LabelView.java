package wishai.applyos.entity.ui.component.basic;

import net.minecraft.client.gui.GuiLabel;
import wishai.applyos.entity.ui.OSGui;

import java.util.List;

public class LabelView extends OSView {

    private String text;
    private int width;
    private GuiLabel label;
    private List<GuiLabel> labelList;


    public LabelView(String text, int width) {
        this.text = text;
        this.width = width;
    }

    public void setText(String text) {
        this.text = text;
        if (labelList != null)
            labelList.remove(label);
        this.label = null;
    }

    @Override
    public void render(OSGui gui, int x, int y) {
        super.render(gui, x, y);

        OSGui.GuiCanvas canvas = gui.getCanvas();

        if (canvas != null && label == null) {
            this.labelList = canvas.getLabelList();
            this.label = new GuiLabel(canvas.getFontRenderer(), labelList.size() + 1, x + canvas.getGuiLeft(), y + canvas.getGuiTop(), width, UNIT_SIZE, 0xFFFFFF);
            label.setCentered();
            label.addLine(text);
            labelList.add(label);
        }
    }

    @Override
    protected void render(OSGui gui) {
    }

}
