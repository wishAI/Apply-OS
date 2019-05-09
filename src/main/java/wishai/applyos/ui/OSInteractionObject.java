package wishai.applyos.ui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import wishai.applyos.ApplyOSMod;
import wishai.applyos.util.Translator;

import javax.annotation.Nullable;

public class OSInteractionObject implements IInteractionObject {

    private String translateKey;
    private TileEntity tileEntity;


    public OSInteractionObject(TileEntity tileEntity) {
        this.tileEntity = tileEntity;
        // TODO: get translate key from tileentity
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        // TODO: return container based on tile entity
        return null;
    }

    @Override
    public String getGuiID() {
        return ApplyOSMod.MOD_ID + ":" + Translator.getTranslatedString(translateKey);
    }

    @Override
    public ITextComponent getName() {
        return new TextComponentTranslation(translateKey);
    }

    @Override
    public boolean hasCustomName() {
        return true;
    }

    @Nullable
    @Override
    public ITextComponent getCustomName() {
        return new TextComponentTranslation(translateKey);
    }

}
