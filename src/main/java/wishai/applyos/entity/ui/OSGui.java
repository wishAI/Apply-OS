package wishai.applyos.entity.ui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import wishai.applyos.ApplyOSMod;
import wishai.applyos.entity.tileentity.OSTileEntity;
import wishai.applyos.entity.ui.component.OSView;
import wishai.applyos.entity.ui.component.PlayerInventoryView;
import wishai.applyos.entity.ui.component.SlotView;


public abstract class OSGui extends Container {

    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(ApplyOSMod.MOD_ID, "textures/guis/background.png");

    protected OSTileEntity tileEntity;
    private GuiCanvas canvas;


    public OSGui(InventoryPlayer playerInv, final OSTileEntity tileEntity) {
        this.tileEntity = tileEntity;

        // only initialize canvas on client
        if (tileEntity.getWorld().isRemote)
            this.canvas = new GuiCanvas(this);

        // add inventory of player
        add(new PlayerInventoryView(playerInv), 0, 0);

        // add all the other views
        addTileEntityViews();
    }

    protected void addTileEntityViews() {
        IItemHandler itemProvider = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);

        for (int i = 0; i < itemProvider.getSlots(); i ++) {
            add(new SlotView(itemProvider, i), 8 + i * 18, 142);
        }
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
        private int x, y;

        public GuiCanvas(Container inventorySlotsIn) {
            super(inventorySlotsIn);
            this.x = 0;
            this.y = 0;
        }

        public void translate(int x, int y) {
            this.x += x;
            this.y += y;
        }

        public void translateToUpperLeft() {}

        public int getTranslateX() {
            return this.x;
        }

        public int getTranslateY() {
            return this.y;
        }

        public void setTexture(ResourceLocation texture) {
            this.mc.getTextureManager().bindTexture(texture);
        }

        @Override
        public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
            super.drawTexturedModalRect(x + this.x, y + this.y, textureX, textureY, width, height);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
            GlStateManager.color(1, 1, 1, 1);
            setTexture(BG_TEXTURE);
            int x = (width - xSize) / 2;
            int y = (height - ySize) / 2;
            drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        }
    }
}
