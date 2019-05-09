package wishai.applyos.ui.component.option;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import wishai.applyos.ui.component.basic.ItemView;
import wishai.applyos.ui.component.basic.LabelView;


public class ItemRowOptionView extends OptionView {

    public ItemRowOptionView(ItemStack stack, String text, int width) {
        super(width, UNIT_SIZE);
        add(new ItemView(stack), 0, 0);
        add(new LabelView(text, getWidth() - UNIT_SIZE - GAP_SIZE), UNIT_SIZE + GAP_SIZE, 0);
    }

    public ItemRowOptionView(Item item, String text, int width) {
        this(new ItemStack(item), text, width);
    }

}
