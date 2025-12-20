package net.chocs.photocards.network;

import net.chocs.photocards.Photocards;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Optional;

public class ModNetwork {

    private static final String PROTOCOL = "1";
    public static final SimpleChannel CHANNEL =
            NetworkRegistry.newSimpleChannel(
                    new ResourceLocation(Photocards.MOD_ID, "network"),
                    () -> PROTOCOL,
                    PROTOCOL::equals,
                    PROTOCOL::equals
            );

    private static int packetIndex = 0;

    public static void register() {
        CHANNEL.registerMessage(
                packetIndex++,
                ChangePagePacket.class,
                ChangePagePacket::encode,
                ChangePagePacket::decode,
                ChangePagePacket::handle,
                Optional.of(NetworkDirection.PLAY_TO_SERVER)
        );
    }

    public static void sendToServer(Object msg) {
        CHANNEL.sendToServer(msg);
    }
}