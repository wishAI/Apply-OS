package wishai.applyos.entity.ui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import wishai.applyos.ApplyOSMod;
import wishai.applyos.entity.tileentity.OSTileEntity;
import wishai.applyos.entity.ui.component.OSMultiView;
import wishai.applyos.entity.ui.component.basic.OSView;
import wishai.applyos.entity.ui.component.basic.PlayerInventoryView;

import java.util.List;


public abstract class OSGui extends Container {

    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(ApplyOSMod.MOD_ID, "textures/guis/os_background.png");
    private static final ResourceLocation BG_TEXTURE_CLEAN = new ResourceLocation(ApplyOSMod.MOD_ID, "textures/guis/os_background_clean.png");
    public static final String UP_ARROW = "\u2191";
    public static final String DOWN_ARROW = "\u2193";
    public static final String RIGHT_ARROW = ">";
    protected static final int MARGIN = 8;
    protected static final int GUI_WIDTH = 176;
    protected static final int GUI_HEIGHT = 70;

    protected OSTileEntity tileEntity;
    private GuiCanvas canvas;
    private InventoryPlayer playerInv;
    private OSMultiView rootView;


    public OSGui(InventoryPlayer playerInv, final OSTileEntity tileEntity) {
        this.tileEntity = tileEntity;
        this.playerInv = playerInv;
        this.rootView = new OSMultiView();

        // only initialize canvas on client
        if (tileEntity.getWorld().isRemote)
            this.canvas = new GuiCanvas(this);

        // add inventory of player
        add(new PlayerInventoryView(playerInv), 2, 128);
    }

    private void update() {
        rootView.render(this, 0, 0);
    }

    public void add(OSView view, int x, int y) {
        this.rootView.add(view, x, y);
    }

    public void remove(OSView view) {
        this.rootView.remove(view);
    }

    public GuiCanvas getCanvas() {
        return canvas;
    }

    public OSTileEntity getTileEntity() {
        return tileEntity;
    }

    @Override
    public Slot addSlotToContainer(Slot slotIn) {
        return super.addSlotToContainer(slotIn);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }


    public static class GuiCanvas extends GuiContainer {

        public GuiCanvas(Container inventorySlotsIn) {
            super(inventorySlotsIn);
        }

        public void translate(float x, float y) {
            GlStateManager.translate(x, y, 0.0F);
        }


        public void setTexture(ResourceLocation texture) {
            GlStateManager.color(1, 1, 1, 1);
            this.mc.getTextureManager().bindTexture(texture);
        }

        public int getGuiLeft() {
            return guiLeft;
        }

        public int getGuiTop() {
            return guiTop;
        }

        public List<GuiButton> getButtonList() {
            return buttons;
        }

        public List<GuiLabel> getLabelList() {
            return labels;
        }

        public FontRenderer getFontRenderer() {
            return fontRenderer;
        }

        public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int xSize, int ySize) {
            super.drawTexturedModalRect(x, y, textureX, textureY, xSize, ySize);
        }

        public ItemRenderer getItemRender() {
            return itemRender;
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
            super.drawGuiContainerForegroundLayer(mouseX, mouseY);
            translate(-guiLeft, -guiTop);
            renderHoveredToolTip(mouseX, mouseY);
            translate(guiLeft, guiTop);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
            setTexture(BG_TEXTURE);
            int x = (width - xSize) / 2;
            int y = (height - ySize) / 2;
            drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

            // render all the views for the client
            translate(guiLeft, guiTop);
            update();
            translate(-guiLeft, -guiTop);
        }
    }

}
