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


public abstract class OSGui extends Container {

    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(ApplyOSMod.MOD_ID, "textures/guis/background.png");

    protected OSTileEntity tileEntity;
    private GuiCanvas canvas;
    private InventoryPlayer playerInv;


    public OSGui(InventoryPlayer playerInv, final OSTileEntity tileEntity) {
        this.tileEntity = tileEntity;
        this.playerInv = playerInv;

        // only initialize canvas on client
        if (tileEntity.getWorld().isRemote)
            this.canvas = new GuiCanvas(this);
        else {
            // render all the other views in the constructor for the server
            addTileEntityViews();
        }
    }

    protected void addTileEntityViews() {
        // add inventory of player
        add(new PlayerInventoryView(playerInv), 0, 0);
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
