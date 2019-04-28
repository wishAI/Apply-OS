package wishai.applyos.entity.block;

import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import wishai.applyos.ApplyOSMod;
import wishai.applyos.entity.ui.OSTab;

public abstract class OSBlock extends Block {

    public static final PropertyDirection FACING_H = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);


    public OSBlock(Material blockMaterialIn, MapColor blockMapColorIn, String name) {
        super(blockMaterialIn, blockMapColorIn);
        setUnlocalizedName(ApplyOSMod.MOD_NAME + "." + name);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(OSTab.getInstance());
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
