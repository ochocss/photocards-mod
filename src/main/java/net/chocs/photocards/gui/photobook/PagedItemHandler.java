package net.chocs.photocards.gui.photobook;

import net.chocs.photocards.ModTags;
import net.chocs.photocards.inventory.PhotobookInventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;

public class PagedItemHandler implements IItemHandlerModifiable {

    private final PhotobookInventory base;
    public int currentPage = 0;

    public PagedItemHandler(PhotobookInventory base) {
        this.base = base;
    }

    public int realIndex(int visibleIndex) {
        return currentPage * PhotobookMenu.SLOTS_PER_PAGE + visibleIndex;
    }

    @Override
    public int getSlots() {
        return PhotobookMenu.SLOTS_PER_PAGE;
    }

    @Override
    public @NotNull ItemStack getStackInSlot(int slot) {
        int real = realIndex(slot);
        if (realIndex(slot) >= base.getSlots()) {
            return ItemStack.EMPTY; // fallback
        }
        return base.getStackInSlot(real);
    }

    @Override
    public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        return base.insertItem(realIndex(slot), stack, simulate);
    }

    @Override
    public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
        return base.extractItem(realIndex(slot), amount, simulate);
    }

    @Override
    public void setStackInSlot(int slot, @NotNull ItemStack stack) {
        base.setStackInSlot(realIndex(slot), stack);
    }

    @Override
    public int getSlotLimit(int slot) {
        return 1;
    }

    @Override
    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        return stack.is(ModTags.CARD);
    }
}
