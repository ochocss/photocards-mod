package net.chocs.photocards.item;

import net.chocs.photocards.Photocards;
import net.chocs.photocards.item.custom.PhotobookItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Photocards.MOD_ID);

    // others
    public static final RegistryObject<Item> PHOTOBOOK = ITEMS.register("photobook", () -> new PhotobookItem(new Item.Properties().stacksTo(1)));

    // sk_lee
    public static final RegistryObject<Item> SK_LEE_MIXTAPE_BLUE = ITEMS.register("sk_lee_mixtape_blue", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_MIXTAPE_GREY = ITEMS.register("sk_lee_mixtape_grey", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SK_LEE_NOT_BLOND = ITEMS.register("sk_lee_not_blond", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_NOT_SHORT = ITEMS.register("sk_lee_not_short", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SK_LEE_WHO_BLACK = ITEMS.register("sk_lee_who_black", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_WHO_BLUE = ITEMS.register("sk_lee_who_blue", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_WHO_GREY = ITEMS.register("sk_lee_who_grey", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_WHO_YELLOW = ITEMS.register("sk_lee_who_yellow", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SK_LEE_MAXIDENT_STRIPES = ITEMS.register("sk_lee_maxident_stripes", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_MAXIDENT_BALL = ITEMS.register("sk_lee_maxident_ball", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_MAXIDENT_BALLHEART = ITEMS.register("sk_lee_maxident_ballheart", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_MAXIDENT_HEART = ITEMS.register("sk_lee_maxident_heart", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SK_LEE_GREETINGS = ITEMS.register("sk_lee_greetings", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SK_LEE_GO_ORANGE = ITEMS.register("sk_lee_go_orange", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_GO_ORANGE2 = ITEMS.register("sk_lee_go_orange2", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_GO_TWO = ITEMS.register("sk_lee_go_two", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SK_LEE_NOEASY_BLACK = ITEMS.register("sk_lee_noeasy_black", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_NOEASY_COLLAR = ITEMS.register("sk_lee_noeasy_collar", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_NOEASY_FLOWER = ITEMS.register("sk_lee_noeasy_flower", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_NOEASY_PT = ITEMS.register("sk_lee_noeasy_pt", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_NOEASY_RED = ITEMS.register("sk_lee_noeasy_red", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_NOEASY_SURF1 = ITEMS.register("sk_lee_noeasy_surf1", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_NOEASY_SURF2 = ITEMS.register("sk_lee_noeasy_surf2", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_NOEASY_THREE = ITEMS.register("sk_lee_noeasy_three", () -> new Item(new Item.Properties().stacksTo(1)));
    
    public static final RegistryObject<Item> SK_LEE_5STAR_THUMBS = ITEMS.register("sk_lee_5star_thumbs", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_5STAR_TWO = ITEMS.register("sk_lee_5star_two", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_5STAR_HAT = ITEMS.register("sk_lee_5star_hat", () -> new Item(new Item.Properties().stacksTo(1)));
    
    public static final RegistryObject<Item> SK_LEE_ROCK_TWO = ITEMS.register("sk_lee_rock_two", () -> new Item(new Item.Properties().stacksTo(1)));
    
    public static final RegistryObject<Item> SK_LEE_ORDINARY = ITEMS.register("sk_lee_ordinary", () -> new Item(new Item.Properties().stacksTo(1)));
    
    public static final RegistryObject<Item> SK_LEE_STAY_PUFF = ITEMS.register("sk_lee_stay_puff", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_STAY_DRAWING = ITEMS.register("sk_lee_stay_drawing", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SK_LEE_STAY_TWO = ITEMS.register("sk_lee_stay_two", () -> new Item(new Item.Properties().stacksTo(1)));
    
    public static final RegistryObject<Item> SK_LEE_YELLOW_OH = ITEMS.register("sk_lee_yellow_oh", () -> new Item(new Item.Properties().stacksTo(1)));
    
    // sk_han
    public static final RegistryObject<Item> SK_HAN_ORDINARY_BLACK = ITEMS.register("sk_han_ordinary_black", () -> new Item(new Item.Properties().stacksTo(1)));
    
    // sk_felix
    public static final RegistryObject<Item> SK_FELIX_ORDINARY_WHITE = ITEMS.register("sk_felix_ordinary_white", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SK_FELIX_MAXIDENT_HEART = ITEMS.register("sk_felix_maxident_heart", () -> new Item(new Item.Properties().stacksTo(1)));
    
    // sk_bang
    public static final RegistryObject<Item> SK_BANG_5STAR_BLACK = ITEMS.register("sk_bang_5star_black", () -> new Item(new Item.Properties().stacksTo(1)));
    
    public static final RegistryObject<Item> SK_BANG_MAXIDENT_PINK = ITEMS.register("sk_bang_maxident_pink", () -> new Item(new Item.Properties().stacksTo(1)));
    
    // sk_seungmin
    public static final RegistryObject<Item> SK_SEUNGMIN_MAXIDENT = ITEMS.register("sk_seungmin_maxident", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SK_SEUNGMIN_ORDINARY = ITEMS.register("sk_seungmin_ordinary", () -> new Item(new Item.Properties().stacksTo(1)));
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
