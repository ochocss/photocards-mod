package net.chocs.photocards.gui.photobook;

import net.chocs.photocards.ModTags;
import net.chocs.photocards.network.ChangePagePacket;
import net.chocs.photocards.network.ModNetwork;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public class PhotobookScreen extends AbstractContainerScreen<PhotobookMenu> {
    private int page = 0;

    private static final ResourceLocation BG =
            new ResourceLocation("photocards", "textures/gui/photobook.png");

    public PhotobookScreen(PhotobookMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 216;
        
        this.titleLabelX = Integer.MIN_VALUE;
        this.inventoryLabelX = Integer.MIN_VALUE;
    }

    @Override
    protected void init() {
        super.init();

        this.clearWidgets();

        addRenderableWidget(
            Button.builder(Component.literal("<"), b ->  {
                page--;

                if(page <  0) page = PhotobookMenu.PAGES - 1;

                ModNetwork.sendToServer(new ChangePagePacket(page));
            }).bounds(leftPos + 1, topPos + 50, 10, 10).build()
        );

        addRenderableWidget(
            Button.builder(Component.literal(">"), b -> {
                page++;

                if(page >= PhotobookMenu.PAGES) page = 0;

                ModNetwork.sendToServer(new ChangePagePacket(page));
            }).bounds(leftPos + 165, topPos + 50, 10, 10).build()
        );
    }

    @Override
    protected void renderBg(GuiGraphics gui, float partialTicks, int mouseX, int mouseY) {
        gui.blit(BG, leftPos, topPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        pGuiGraphics.drawCenteredString(this.font, String.valueOf(2*page+1), leftPos + 15,  topPos + 112, 0xEDEDED);
        pGuiGraphics.drawCenteredString(this.font, String.valueOf(2*page+2), leftPos + 161,  topPos + 112, 0xEDEDED);

        // TODO: implement slot hover maybe ???
        renderLargeCard(pGuiGraphics);
        renderInventoryTooltips(pGuiGraphics, pMouseX, pMouseY);
    }

    private void renderLargeCard(GuiGraphics gui) {
        forEachSlotPosition((x, y, index) -> renderCard(gui, x, y, index));
    }

    private void renderCard(GuiGraphics gui, int slotX, int slotY, int index) {
        ItemStack stack = menu.getInventory().getStackInSlot(index);

        if(stack.isEmpty()) return;
        if(!stack.is(ModTags.CARD)) return;

        gui.pose().pushPose();

        gui.pose().translate(slotX, slotY, 150);
        gui.pose().scale(2F, 2.94F, 1F);

        // no common rendering
        gui.renderItem(stack, 0, 0);
        gui.renderItemDecorations(font, stack, 0, 0);

        gui.pose().popPose();
    }

    private void renderInventoryTooltips(GuiGraphics gui, int mouseX, int mouseY) {
        boolean[] found = {false};
        forEachSlotPosition((x, y, index) -> {
            if (!found[0] && renderTooltip(gui, mouseX, mouseY, x, y, 32, 47, index)) {
                found[0] = true;
            }
        });

        if (found[0]) return;

        if (this.hoveredSlot == null) return;

        // player inventory
        if (hoveredSlot.index < 8) return;

        ItemStack stack = hoveredSlot.getItem();
        if (stack.isEmpty()) return;

        gui.renderTooltip(font, stack, mouseX, mouseY);
    }

    @Override
    protected void renderTooltip(GuiGraphics pGuiGraphics, int pX, int pY) {}

    private boolean renderTooltip(GuiGraphics gui, int mouseX, int mouseY, int slotX, int slotY, int slotW, int slotH, int i) {
        if (mouseX >= slotX && mouseX <= slotX + slotW &&
                mouseY >= slotY && mouseY <= slotY + slotH) {

            ItemStack stack = menu.getInventory().getStackInSlot(i);
            if (!stack.isEmpty()) {
                gui.renderTooltip(font, stack, mouseX, mouseY);
                return true;
            }
        }
        return false;
    }

    private void forEachSlotPosition(SlotPositionConsumer consumer) {
        int index = 0;

        for(int row = 0; row < 2; row++) {
            int slotY = topPos + 7 + row * 49;

            for (int col = 0; col < 2; col++) {
                int slotX = leftPos + 13 + col * 36;
                consumer.accept(slotX, slotY, index++);
            }

            for (int col = 0; col < 2; col++) {
                int slotX = leftPos + 95 + col * 36;
                consumer.accept(slotX, slotY, index++);
            }
        }
    }

    @FunctionalInterface
    private interface SlotPositionConsumer {
        void accept(int x, int y, int index);
    }
}
