package wishai.applyos.entity.ui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import wishai.applyos.ApplyOSMod;
import wishai.applyos.entity.ui.component.OSView;

public abstract class OSGui extends GuiContainer {

    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(ApplyOSMod.MOD_ID, "textures/guis/background.png");

    private InventoryPlayer playerInv;


    public OSGui(Container inventorySlotsIn, InventoryPlayer playerInv) {
        super(inventorySlotsIn);
        this.playerInv = playerInv;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    }

    public void add(OSView view) {
    }


    public void renderSlot(Slot slot) {
    }

}
