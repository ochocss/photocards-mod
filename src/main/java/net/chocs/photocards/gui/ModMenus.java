package net.chocs.photocards.gui;

import net.chocs.photocards.gui.photobook.PhotobookMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, "photocards");

    public static final RegistryObject<MenuType<PhotobookMenu>> PHOTOBOOK =
            MENUS.register("photobook", () -> IForgeMenuType.create(PhotobookMenu::new));


    public static void register(IEventBus bus) {
        MENUS.register(bus);
    }
}
