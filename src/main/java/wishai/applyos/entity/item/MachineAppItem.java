package wishai.applyos.entity.item;


import net.minecraft.item.Item;

public class MachineAppItem extends OSItem {

    public MachineAppItem(String name) {
        super(name, (new Item.Properties()).maxStackSize(1));
    }

}
