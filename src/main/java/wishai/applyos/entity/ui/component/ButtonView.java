package wishai.applyos.entity.ui.component;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import wishai.applyos.entity.ui.OSGui;

import java.util.ArrayList;
import java.util.List;

public class ButtonView extends OSView {

    private String text;
    private int width;
    private List<OnClickListener> listeners;
    private boolean isRendered;


    public ButtonView(String text, int width) {
        this.text = text;
        this.width = width;
        this.isRendered = false;
        listeners = new ArrayList<>();
    }

    public void addOnClickListener(OnClickListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void render(OSGui gui, int x, int y) {
        super.render(gui, x, y);

        OSGui.GuiCanvas canvas = gui.getCanvas();

        if (canvas != null && !isRendered) {
            List<GuiButton> buttons = canvas.getButtonList();
            GuiButton button = new OSGuiButton(buttons.size(), x + canvas.getGuiLeft(), y + canvas.getGuiTop(), width, SLOT_SIZE, text);
            buttons.add(button);
            this.isRendered = true;
        }
    }

    @Override
    protected void render(OSGui gui) {
    }

    private class OSGuiButton extends GuiButton {

        public OSGuiButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
            super(buttonId, x, y, widthIn, heightIn, buttonText);
        }

        @Override
        public void mouseReleased(int mouseX, int mouseY) {
            super.mouseReleased(mouseX, mouseY);

            for (OnClickListener listener : listeners)
                listener.onClick(null);
        }

        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
        {
            if (this.visible)
            {
                FontRenderer fontrenderer = mc.fontRenderer;
                mc.getTextureManager().bindTexture(COMPONENTS_TEXTURE);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
                int i = this.getHoverState(this.hovered);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
                if (i > 0)
                    this.drawTexturedModalRect(this.x, this.y, 0, (i - 1) * SLOT_SIZE, this.width, this.height);
                this.mouseDragged(mc, mouseX, mouseY);
                int j = 14737632;

                if (packedFGColour != 0)
                {
                    j = packedFGColour;
                }
                else
                if (!this.enabled)
                {
                    j = 10526880;
                }
                else if (this.hovered)
                {
                    j = 16777120;
                }

                this.drawCenteredString(fontrenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, j);
            }
        }
    }

}
