package wishai.applyos.ui.machine;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import wishai.applyos.entity.tileentity.OSTileEntity;
import wishai.applyos.ui.OSGui;
import wishai.applyos.ui.component.basic.OSView;
import wishai.applyos.ui.component.option.ItemRowOptionView;
import wishai.applyos.ui.component.option.OptionSet;

public class FilesGui extends OSGui {

    private static final int OPTION_NUM = 4;

    private OptionSet optionSet;


    public FilesGui(InventoryPlayer playerInv, OSTileEntity tileEntity) {
        super(playerInv, tileEntity);

        this.optionSet = new OptionSet();
        for (int i = 0; i < 10; i ++) {
            Item item = Items.APPLE;
            ItemRowOptionView option = new ItemRowOptionView(item, "Apple.txt", 4 * OSView.UNIT_SIZE);
            optionSet.add(option);
            add(option, MARGIN, MARGIN + i * OSView.UNIT_SIZE);
        }
    }

}
