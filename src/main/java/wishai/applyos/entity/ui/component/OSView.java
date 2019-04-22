package wishai.applyos.entity.ui.component;

import wishai.applyos.entity.ui.OSGui;

public abstract class OSView {


    public OSView() {
    }

    public void render(OSGui gui, int x, int y) {
        gui.getCanvas().translate(x, y);
        render(gui);
        gui.getCanvas().translate(-x, -y);
    }

    protected abstract void render(OSGui gui);

}
