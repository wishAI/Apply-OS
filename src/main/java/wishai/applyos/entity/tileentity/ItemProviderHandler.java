package wishai.applyos.entity.tileentity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;


public class ItemProviderHandler extends ItemStackHandler {

    public ItemProviderHandler() {
        super(1);
    }

    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        return ItemStack.EMPTY;
    }

    public ItemStack provideItem(Item item) {
        ItemStack stack = new ItemStack(item);
        return provideItem(stack);
    }

    public ItemStack provideItem(ItemStack itemStack) {
        return super.insertItem(0, itemStack, false);
    }

}
