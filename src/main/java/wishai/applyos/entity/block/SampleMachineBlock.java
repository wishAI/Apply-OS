package wishai.applyos.entity.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import wishai.applyos.entity.tileentity.machine.OSMachine;
import wishai.applyos.entity.tileentity.machine.OSMachineTileEntity;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;


public class SampleMachineBlock extends OSMachineBlock {

    private Class<? extends OSMachineTileEntity> tileEntityClass;


    public SampleMachineBlock(String name) {
        super(name);
    }

    public void setTileEntityClass(Class<? extends OSMachineTileEntity> tileEntityClass) {
        this.tileEntityClass = tileEntityClass;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        try {
            return tileEntityClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Cannot create OS tileentity");
    }

    @Override
    protected int createGui() {
        OSMachine machine = tileEntityClass.getAnnotation(OSMachine.class);
        return machine.gui();
    }

}
