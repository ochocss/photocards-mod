package net.chocs.photocards.inventory;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class PhotobookInventory extends ItemStackHandler {

    private final int fixedSize;

    public PhotobookInventory(int size) {
        super(size);
        this.fixedSize = size;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);

        if (this.getSlots() != fixedSize) {
            this.setSize(fixedSize);
        }
    }

    public void saveTo(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.put("Items", serializeNBT());
    }

    public void loadFrom(ItemStack stack) {
        if (stack.hasTag() && stack.getTag() != null && stack.getTag().contains("Items")) {
            deserializeNBT(stack.getTag().getCompound("Items"));
        }
    }
}