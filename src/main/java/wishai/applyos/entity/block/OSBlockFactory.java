package wishai.applyos.entity.block;


import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public class OSBlockFactory {

    private static final Map<String, OSBlock> foodBlocks = new HashMap<>();


    public static OSBlock getBlock(Class<?> blockClass) {
        if (!OSBlock.class.isAssignableFrom(blockClass)) {
            throw new RuntimeException("The class is not a food block");
        }
        String className = blockClass.getName();
        OSBlock block = null;

        if(!foodBlocks.containsKey(className)) {
            try {
                block = (OSBlock) blockClass.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException("Block class not load! ");
            }
            foodBlocks.put(className, block);
            return block;
        }

        block = foodBlocks.get(className);
        if(block == null) {
            throw new NullPointerException();
        }
        return block;
    }

//    public static OSBlock getBlock(Block block) {
//        return getBlock(block.getClass());
//    }

}
