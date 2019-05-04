package wishai.applyos.entity.ui.machine;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import wishai.applyos.entity.item.MachineAppItem;
import wishai.applyos.entity.item.OSItemFactory;
import wishai.applyos.entity.tileentity.OSTileEntity;
import wishai.applyos.entity.ui.OSGui;
import wishai.applyos.entity.ui.component.*;
import wishai.applyos.entity.ui.component.basic.ButtonView;
import wishai.applyos.entity.ui.component.basic.OSView;
import wishai.applyos.entity.ui.component.basic.SlotView;
import wishai.applyos.entity.ui.component.option.ItemOptionView;
import wishai.applyos.entity.ui.component.option.OptionSet;
import wishai.applyos.entity.ui.component.option.OptionView;
import wishai.applyos.util.Translator;

import java.util.List;


public class LauncherGui extends OSGui implements ClickListener {

    private static final int OPTION_NUM = 6;

    private OptionSet optionSet;
    private List<MachineAppItem> appItems;
    private int pageIdx;
    private ButtonView btn_up;
    private ButtonView btn_down;
    private ButtonView btn_provide;


    public LauncherGui(InventoryPlayer playerInv, OSTileEntity tileEntity) {
        super(playerInv, tileEntity);

        this.appItems = OSItemFactory.getAllMachineAppItems();

        // add app menu and buttons
        this.optionSet = new OptionSet();
        switchPage(0);
        this.btn_up = new ButtonView(UP_ARROW, OSView.UNIT_SIZE, ItemOptionView.OPTION_HEIGHT);
        this.btn_up.addOnClickListener(this);
        add(btn_up, MARGIN + ItemOptionView.OPTION_WIDTH * 3 + OSView.GAP_SIZE, 15);
        this.btn_down = new ButtonView(DOWN_ARROW, OSView.UNIT_SIZE, ItemOptionView.OPTION_HEIGHT);
        this.btn_down.addOnClickListener(this);
        add(btn_down, MARGIN + ItemOptionView.OPTION_WIDTH * 3 + OSView.GAP_SIZE, 15 + ItemOptionView.OPTION_HEIGHT);

        // add provider slot and buttons
        IItemHandler itemProvider = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        add(new SlotView(itemProvider, 0), GUI_WIDTH - OSView.UNIT_SIZE - MARGIN, 15 + 2 * ItemOptionView.OPTION_HEIGHT - OSView.UNIT_SIZE);
        this.btn_provide = new ButtonView(RIGHT_ARROW, OSView.UNIT_SIZE, OSView.UNIT_SIZE);
        this.btn_provide.addOnClickListener(this);
        add(btn_provide, GUI_WIDTH - 2 * OSView.UNIT_SIZE - OSView.GAP_SIZE - MARGIN, 15 + 2 * ItemOptionView.OPTION_HEIGHT - OSView.UNIT_SIZE);
    }

    @Override
    public void onClick(GuiEvent event) {
        OSView src = event.getSource();

        if (src == btn_up)
            switchPage(pageIdx + 1);
        else if (src == btn_down)
            switchPage(pageIdx - 1);
    }

    private void switchPage(int idx) {
        if (idx < 0 || idx * OPTION_NUM >= appItems.size())
            return;

        // remove all options
        for (OptionView option : optionSet.getOptions())
            remove(option);
        this.optionSet.clear();

        // add all the options in this page
        for (int i = 0; i < OPTION_NUM; i ++) {
            if (i + idx * OPTION_NUM >= appItems.size())
                break;

            Item app = appItems.get(i);
            ItemOptionView option = new ItemOptionView(app, Translator.getTranslatedItemName(app));
            add(option, MARGIN + ItemOptionView.OPTION_WIDTH * (i % 3), 15 + ItemOptionView.OPTION_HEIGHT * (i / 3));
            this.optionSet.add(option);
        }

        pageIdx ++;
    }

}
