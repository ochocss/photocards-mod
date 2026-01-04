package net.chocs.photocards.item;

import net.chocs.photocards.Photocards;
import net.chocs.photocards.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Photocards.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PHOTOCARD_TAB = CREATIVE_MODE_TABS.register("photocard_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PHOTOBOOK.get()))
                    .title(Component.translatable("creativetab.photocard_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.TRADING_POST.get());
                        for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                            output.accept(item.get());
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
