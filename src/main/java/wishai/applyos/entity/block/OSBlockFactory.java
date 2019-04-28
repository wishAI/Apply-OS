package wishai.applyos.entity.block;


import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import wishai.applyos.entity.tileentity.machine.OSMachine;
import wishai.applyos.entity.tileentity.machine.OSMachineTileEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public class OSBlockFactory {

    private static final Map<String, OSBlock> blocks = new HashMap<>();


    public static OSBlock getRegularBlock(Material material, MapColor mapColor, String name) {
        // return if this block has been already created
        String className = RegularBlock.class.getName() + "." + name;
        if (blocks.containsKey(className))
            return blocks.get(className);

        OSBlock block = new RegularBlock(material, mapColor, name);

        blocks.put(className, block);
        return block;
    }

    public static OSBlock getRegularBlock(Class<? extends OSBlock> blockClass) {
        if (!OSBlock.class.isAssignableFrom(blockClass))
            throw new RuntimeException("The class is not an os block. ");

        // return if this block has been already created
        String className = blockClass.getName();
        if (blocks.containsKey(className))
            return blocks.get(className);

        OSBlock block = null;
        try {
            block = blockClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Block class not load! ");
        }

        blocks.put(className, block);
        return block;
    }

    public static OSBlock getMachineBlock(Class<? extends OSMachineTileEntity> tileEntityClass) {
        if (!OSMachineTileEntity.class.isAssignableFrom(tileEntityClass))
            throw new RuntimeException("The class is not a os machine tile entity. ");

        // return if this block has been already created
        String className = tileEntityClass.getName();
        if (blocks.containsKey(className))
            return blocks.get(className);

        // create as a regular block if it is not a sample machine
        OSMachine annotation = tileEntityClass.getAnnotation(OSMachine.class);
        Class<? extends OSMachineBlock> blockClass = annotation.blockClass();
        if (!SampleMachineBlock.class.isAssignableFrom(blockClass))
            return getRegularBlock(blockClass);

        String name = className;
        name = name.substring(0, name.indexOf("TileEntity"));
        name = name.substring(name.lastIndexOf(".") + 1);
        name = name.toLowerCase();
        SampleMachineBlock block = new SampleMachineBlock(name);
        block.setTileEntityClass(tileEntityClass);

        blocks.put(className, block);
        return block;
    }

}
