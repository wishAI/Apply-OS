package wishai.applyos.entity.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class OSTileEntityTypeFactory {

    private static Map<String, TileEntityType<?>> tileEntityTypes = new HashMap<>();


    public static TileEntityType<?> getTileEntityType(Class<? extends TileEntity> tileEntityClass) {
        String className = tileEntityClass.getName();

        if (tileEntityTypes.containsKey(className))
            return tileEntityTypes.get(className);

        Supplier<? extends TileEntity> supplier = () -> {
            try {
                return tileEntityClass.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }

            return null;
        };

        TileEntityType<?> type = TileEntityType.Builder.create(supplier).build(null);
        tileEntityTypes.put(className, type);
        return type;
    }

}
