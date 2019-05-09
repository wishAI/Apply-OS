package wishai.applyos.entity.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class RegularBlock extends OSBlock {

    public RegularBlock(Material blockMaterialIn, MaterialColor blockMapColorIn, String name) {
        super(name, Block.Properties.create(blockMaterialIn, blockMapColorIn));
    }

}
