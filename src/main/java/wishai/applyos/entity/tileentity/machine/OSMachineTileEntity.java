package wishai.applyos.entity.tileentity.machine;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import wishai.applyos.entity.tileentity.ItemProviderHandler;
import wishai.applyos.entity.tileentity.OSTileEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public abstract class OSMachineTileEntity extends OSTileEntity implements ICapabilityProvider {

    protected ItemProviderHandler itemProvider;


    public OSMachineTileEntity() {
        this.itemProvider = createItemProvider();
    }

    public ItemProviderHandler createItemProvider() {
        return null;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return true;
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return (T) this.itemProvider;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        // Itemstackhelper.loadAllItems
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        return super.writeToNBT(compound);
    }

}
