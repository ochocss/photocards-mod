package net.chocs.photocards.network;

import net.chocs.photocards.gui.photobook.PhotobookMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ChangePagePacket {

    private final int page;

    public ChangePagePacket(int page) {
        this.page = page;
    }

    public static void encode(ChangePagePacket msg, FriendlyByteBuf buf) {
        buf.writeInt(msg.page);
    }

    public static ChangePagePacket decode(FriendlyByteBuf buf) {
        return new ChangePagePacket(buf.readInt());
    }

    public static void handle(ChangePagePacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            var player = ctx.get().getSender();
            if (player != null && player.containerMenu instanceof PhotobookMenu menu) {
                menu.changePage(msg.page);
            }
        });

        ctx.get().setPacketHandled(true);
    }
}
