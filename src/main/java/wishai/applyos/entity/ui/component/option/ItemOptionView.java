package wishai.applyos.entity.ui.component.option;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import wishai.applyos.entity.ui.component.basic.ItemView;
import wishai.applyos.entity.ui.component.basic.LabelView;


public class ItemOptionView extends OptionView {

    public static final int OPTION_WIDTH = 30;
    public static final int OPTION_HEIGHT = 28;



    public ItemOptionView(ItemStack stack, String text) {
        super(OPTION_WIDTH, OPTION_HEIGHT);
        add(new ItemView(stack), (OPTION_WIDTH - UNIT_SIZE) / 2, 1);
        add(new LabelView(text, OPTION_WIDTH), 0, OPTION_HEIGHT - 14);
    }

    public ItemOptionView(Item item, String text) {
        this(new ItemStack(item), text);
    }

}
