package wishai.applyos.entity.ui.component.option;

import wishai.applyos.entity.ui.OSGui;
import wishai.applyos.entity.ui.component.basic.ButtonView;
import wishai.applyos.entity.ui.component.GuiEvent;
import wishai.applyos.entity.ui.component.OSMultiView;
import wishai.applyos.entity.ui.component.ClickListener;


public abstract class OptionView extends OSMultiView implements ClickListener {

    protected boolean isSelected;
    private int width;
    private int height;
    private OptionSet optionSet;


    public OptionView(int width, int height) {
        this.isSelected = false;
        this.width = width;
        this.height = height;

        ButtonView btn = new ButtonView("", width, height);
        btn.setHasBackground(false);
        add(btn, 0, 0);
        btn.addOnClickListener(this);
    }

    public void setOptionSet(OptionSet set) {
        this.optionSet = set;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    @Override
    public void onClick(GuiEvent event) {
        optionSet.setSelected(this);
    }

    public boolean isSelected() {
        return isSelected;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    protected void render(OSGui gui) {
        OSGui.GuiCanvas canvas = gui.getCanvas();

        if (isSelected) {
            canvas.setTexture(COMPONENTS_TEXTURE);
            canvas.drawTexturedModalRect(0, 0, 0, UNIT_SIZE, getWidth(), UNIT_SIZE);
            canvas.drawTexturedModalRect(0, getHeight() - UNIT_SIZE, 0, UNIT_SIZE, getWidth(), UNIT_SIZE);
        }

        super.render(gui);
    }

}
