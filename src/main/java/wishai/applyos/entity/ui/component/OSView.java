package wishai.applyos.entity.ui.component;

import wishai.applyos.entity.ui.OSGui;

public abstract class OSView {

    public OSView() {
    }

    public void render(OSGui gui, int x, int y) {
        OSGui.GuiCanvas canvas = gui.getCanvas();

        if (canvas != null)
            gui.getCanvas().translate(x, y);

        if (canvas != null)
            render(gui);

        if (canvas != null)
            gui.getCanvas().translate(-x, -y);
    }

    protected abstract void render(OSGui gui);

}
