package wishai.applyos.entity.block;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import wishai.applyos.entity.ui.OSInteractionObject;


public abstract class OSMachineBlock extends OSBlock {

    public OSMachineBlock(String name) {
        super(name, Block.Properties.create(Material.IRON, MaterialColor.BLACK));
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote())
            return true;

        // get gui of tileentity
        TileEntity entity = worldIn.getTileEntity(pos);

        NetworkHooks.openGui((EntityPlayerMP) player, new OSInteractionObject(entity), buf -> buf.writeBlockPos(pos));

        return true;
    }

    // !!! all the stuff that deals with facing of a block, should be seperated from this

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.setBlockState(pos, state.with(FACING_H, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(FACING_H);
    }

}
