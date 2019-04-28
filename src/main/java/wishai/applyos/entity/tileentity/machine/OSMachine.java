package wishai.applyos.entity.tileentity.machine;

import wishai.applyos.entity.block.OSMachineBlock;
import wishai.applyos.entity.block.SampleMachineBlock;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface OSMachine {
//    public static final Class<? extends OSMachineBlock> DEFAULT_BLOCK = SampleMachineBlock.class;

    Class<? extends OSMachineBlock> blockClass() default SampleMachineBlock.class;
    int gui();
//    Class appClass() default DEFAULT_APP;
}
