package wishai.applyos.entity.tileentity.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.ItemStackHandler;
import wishai.applyos.entity.tileentity.OSTileEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public abstract class OSMachineTileEntity extends OSTileEntity implements ICapabilityProvider {

    protected ItemStackHandler itemProvider;


    public OSMachineTileEntity() {
        this.itemProvider = createItemProvider();
    }

    public ItemStackHandler createItemProvider() {
        return null;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return true;
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return super.getCapability(capability, facing);
    }

}
