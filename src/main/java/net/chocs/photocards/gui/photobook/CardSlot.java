package net.chocs.photocards.gui.photobook;

import net.chocs.photocards.ModTags;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class CardSlot extends SlotItemHandler {

    private final PhotobookMenu menu;

    public CardSlot(PhotobookMenu menu, IItemHandler handler, int index, int x, int y) {
        super(handler, index, x, y);
        this.menu = menu;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.is(ModTags.CARD);
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public void setChanged() {
        menu.slotsChanged(null);
    }
}