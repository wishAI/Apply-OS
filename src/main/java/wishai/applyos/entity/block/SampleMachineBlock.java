package wishai.applyos.entity.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import wishai.applyos.entity.tileentity.OSTileEntityTypeFactory;
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

    // TODO: clear deprecated code
//    @Override
//    protected int createGui() {
//        OSMachine machine = tileEntityClass.getAnnotation(OSMachine.class);
//        return machine.gui();
//    }

    @Nullable
    @Override
    public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
        try {
            return tileEntityClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Cannot create OS tileentity");
    }

}
