package wishai.applyos.entity.tileentity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;


public class ItemProviderHandler extends ItemStackHandler {


    public ItemProviderHandler() {
        super(1 );
//        itemTypes = new ArrayList<>(1);
//
//        for (int i = 0; i < size; i ++)
//            itemTypes.add(ItemStack.EMPTY);
    }

//    public ItemProviderHandler(int size, List<ItemStack> itemTypes) {
//        super(size);
//        this.itemTypes = itemTypes;
//
//        // expand the size of types if not enough
//        while (itemTypes.size() < size)
//            this.itemTypes.add(null);
//    }

//    public void setItemType(int slot, ItemStack type) {
//        itemTypes.set(slot, type);
//        onContentsChanged(slot);
//    }
//
//    public ItemStack getItemType(int slot) {
//        if (hasType(slot))
//            return itemTypes.get(slot);
//
//        return null;
//    }

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

//    @Override
//    protected void onContentsChanged(int slot) {
        // copy new item to the slot
//        if (hasType(slot))
//            super.insertItem(slot, itemTypes.get(slot), false);
//    }

//    private boolean hasType(int slot) {
//        if (slot >= itemTypes.size())
//            return false;
//
//        return itemTypes.get(slot) != ItemStack.EMPTY;
//    }

}
