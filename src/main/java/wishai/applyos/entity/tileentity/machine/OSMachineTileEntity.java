package wishai.applyos.entity.tileentity.machine;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import wishai.applyos.entity.tileentity.ItemProviderHandler;
import wishai.applyos.entity.tileentity.OSTileEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public abstract class OSMachineTileEntity extends OSTileEntity implements ICapabilityProvider {

    protected LazyOptional<ItemProviderHandler> itemProvider;


    public OSMachineTileEntity(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
        this.itemProvider = createItemProvider();
    }

    public LazyOptional<ItemProviderHandler> createItemProvider() {
        return null;
    }

    // TODO: solve high coupling in LazyOptional
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return itemProvider.cast();
        return null;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable EnumFacing side) {
        return null;
    }

    @Override
    public void read(NBTTagCompound compound) {
        super.read(compound);
        // Itemstackhelper.loadAllItems
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound) {
        return super.write(compound);
    }

}
