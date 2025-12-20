package net.chocs.photocards.gui.photobook;

import net.chocs.photocards.ModTags;
import net.chocs.photocards.gui.ModMenus;
import net.chocs.photocards.inventory.PhotobookInventory;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PhotobookMenu extends AbstractContainerMenu {

    private final PhotobookInventory inventory;
    private final ItemStack photobookStack;
    private final PagedItemHandler pagedHandler;

    public static final int PAGES = 10;
    public static final int SLOTS_PER_PAGE = 8;

    public PhotobookMenu(int containerId, Inventory playerInv, ItemStack photobookStack) {
        super(ModMenus.PHOTOBOOK.get(), containerId);

        this.photobookStack = photobookStack;
        this.inventory = new PhotobookInventory(PAGES * SLOTS_PER_PAGE);
        this.inventory.loadFrom(photobookStack);

        this.pagedHandler = new PagedItemHandler(inventory);

        this.slots.clear();

        addBookSlots();
        addPlayerInventory(playerInv);
    }

    // client-side constructor
    public PhotobookMenu(int containerId, Inventory inv, FriendlyByteBuf buffer) {
        this(containerId, inv, inv.player.getItemInHand(buffer.readEnum(InteractionHand.class)));
    }

    private void addBookSlots() {
        /* photobook slots: 10 pages
         *  X  X    X  X
         *  X  X    X  X
         */
        for(int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                addSlot(new CardSlot(this, pagedHandler, row*4 + col,
                        21 + col*36, 22 + row*49));
            }

            for (int col = 0; col < 2; col++) {
                addSlot(new CardSlot(this, pagedHandler, row*4 + 2 + col,
                        103 + col*36, 22 + row*49));
            }
        }
    }

    private void addPlayerInventory(Inventory inv) {
        // 3 rows
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new Slot(inv, col + row * 9 + 9, 8 + col * 18, 134 + row * 18));
            }
        }

        // hotbar
        for (int col = 0; col < 9; col++) {
            addSlot(new Slot(inv, col, 8 + col * 18, 192));
        }
    }

    public PhotobookInventory getInventory() {
        return inventory;
    }

    public void changePage(int page) {
        pagedHandler.currentPage = page;

        for (int i = 0; i < SLOTS_PER_PAGE; i++) {
            slots.get(i).setChanged();
        }

        broadcastChanges();
    }


    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack stack = slot.getItem();
            result = stack.copy();

            // photobook -> player
            if (index < SLOTS_PER_PAGE) {
                if (!this.moveItemStackTo(stack, SLOTS_PER_PAGE, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            // photobook <- player
            else {
                if (stack.is(ModTags.CARD)) {
                    if (!this.moveItemStackTo(stack, 0, SLOTS_PER_PAGE, false)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    return ItemStack.EMPTY;
                }
            }

            if (stack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return result;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);

        // save inventory back to the item
        inventory.saveTo(photobookStack);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
