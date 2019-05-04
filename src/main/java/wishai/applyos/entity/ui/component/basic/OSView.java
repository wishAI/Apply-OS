package wishai.applyos.entity.ui.component.basic;

import net.minecraft.util.ResourceLocation;
import wishai.applyos.ApplyOSMod;
import wishai.applyos.entity.ui.OSGui;

public abstract class OSView {

    public static final int UNIT_SIZE = 16;
    public static final int GAP_SIZE = 2;
    protected static final ResourceLocation COMPONENTS_TEXTURE = new ResourceLocation(ApplyOSMod.MOD_ID, "textures/guis/os_components.png");
    private boolean visiable;

    public OSView() {
        this.visiable = true;
    }

    public void render(OSGui gui, int x, int y) {
        OSGui.GuiCanvas canvas = gui.getCanvas();

        if (canvas != null) {
            gui.getCanvas().translate(x, y);
            render(gui);
            gui.getCanvas().translate(-x, -y);
        }
    }

    protected abstract void render(OSGui gui);

}
