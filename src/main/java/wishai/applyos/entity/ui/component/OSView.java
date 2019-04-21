package wishai.applyos.entity.ui.component;

import wishai.applyos.entity.ui.OSGui;

public abstract class OSView {

    private int x;
    private int y;

    public OSView(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void render(OSGui gui);

}
