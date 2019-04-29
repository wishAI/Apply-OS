package wishai.applyos.entity.ui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import wishai.applyos.ApplyOSMod;
import wishai.applyos.entity.tileentity.OSTileEntity;
import wishai.applyos.entity.ui.component.OSView;
import wishai.applyos.entity.ui.component.PlayerInventoryView;

import java.util.List;


public abstract class OSGui extends Container {

    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(ApplyOSMod.MOD_ID, "textures/guis/os_background.png");
    private static final ResourceLocation BG_TEXTURE_CLEAN = new ResourceLocation(ApplyOSMod.MOD_ID, "textures/guis/os_background_clean.png");

    protected OSTileEntity tileEntity;
    private GuiCanvas canvas;
    private InventoryPlayer playerInv;


    public OSGui(InventoryPlayer playerInv, final OSTileEntity tileEntity) {
        this.tileEntity = tileEntity;
        this.playerInv = playerInv;

        // only initialize canvas on client
        addTileEntityViews();
        if (tileEntity.getWorld().isRemote)
            this.canvas = new GuiCanvas(this);
    }

    protected void addTileEntityViews() {
        // add inventory of player
        add(new PlayerInventoryView(playerInv), 2, 128);
    }

    public void add(OSView view, int x, int y) {
        view.render(this, x, y);
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

    public class GuiCanvas extends GuiContainer {

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
            return buttonList;
        }

        public List<GuiLabel> getLabelList() {
            return labelList;
        }

        public FontRenderer getFontRenderer() {
            return fontRenderer;
        }

        public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int xSize, int ySize) {
            super.drawTexturedModalRect(x, y, textureX, textureY, xSize, ySize);
        }

        public RenderItem getItemRender() {
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
            addTileEntityViews();
            translate(-guiLeft, -guiTop);
        }
    }

}
