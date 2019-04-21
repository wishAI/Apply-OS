package wishai.applyos.entity.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;


public class ItemProviderHandler extends ItemStackHandler {

    private List<ItemStack> itemTypes;


    public ItemProviderHandler(int size) {
        super(size);
        itemTypes = new ArrayList<>(size);
    }

    public ItemProviderHandler(int size, List<ItemStack> itemTypes) {
        super(size);
        this.itemTypes = itemTypes;

        // expand the size of types if not enough
        while (itemTypes.size() < size)
            this.itemTypes.add(null);
    }

    public void setItemType(int slot, ItemStack type) {
        itemTypes.set(slot, type);
    }

    public ItemStack getItemType(int slot) {
        if (hasType(slot))
            return itemTypes.get(slot);

        return null;
    }

    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        return ItemStack.EMPTY;
    }

    @Override
    protected void onContentsChanged(int slot) {
        // copy new item to the slot
        if (hasType(slot))
            super.insertItem(slot, itemTypes.get(slot), false);
    }

    private boolean hasType(int slot) {
        if (slot >= itemTypes.size())
            return false;

        return itemTypes.get(slot) != null;
    }

}
