package wishai.applyos.entity.ui.component;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import wishai.applyos.entity.ui.OSGui;

public class PlayerInventoryView extends OSView {

    private InventoryPlayer playerInv;


    public PlayerInventoryView(InventoryPlayer playerInv) {
        this.playerInv = playerInv;
    }

    @Override
    public void render(OSGui gui, int x, int y) {
        super.render(gui, x, y);

        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 9; j ++) {
                gui.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; k ++) {
            gui.addSlotToContainer(new Slot(playerInv, k, 8 + k * 18, 142));
        }
    }

    @Override
    protected void render(OSGui gui) {
    }

}
