package wishai.applyos.entity.block;

import net.minecraft.state.DirectionProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.Block;


public abstract class OSBlock extends Block {

    public static final DirectionProperty FACING_H = DirectionProperty.create("facing", EnumFacing.Plane.HORIZONTAL);


    public OSBlock(String name, Block.Properties properties) {
        super(properties);
        setRegistryName(name);
    }

//    public OSBlock(MapColor blockMapColorIn, String name) {
//        this(Material.IRON, blockMapColorIn, name);
//    }

//    @SideOnly(Side.CLIENT)
//    public void initModel() {
//        ModelLoader.setCustomModelResourceLocation(OSItemFactory.getItem(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
//    }
//
//    @Override
//    public IBlockState getStateFromMeta(int meta) {
//        return super.getStateFromMeta(meta);
////        EnumFacing.Plane.HORIZONTAL
////        PropertyDirection
//    }
//
//    @Override
//    public int getMetaFromState(IBlockState state) {
//        return super.getMetaFromState(state);
//    }

}
