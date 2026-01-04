package net.chocs.photocards.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.chocs.photocards.Photocards;
import net.chocs.photocards.item.ModItems;
import net.chocs.photocards.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@Mod.EventBusSubscriber(modid = Photocards.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.PC_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // photobook trade
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(Items.BOOK, 1),
                    new ItemStack(ModItems.PHOTOBOOK.get(), 1),
                    4, 6, 0.1F
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ModItems.PHOTOBOOK.get(), 1),
                    4, 6, 0.1F
            ));


            List<RegistryObject<Item>> itemsList = ModItems.ITEMS.getEntries().stream().toList();
            int length = itemsList.size();

            // card trades
            for (int i = 2; i < length; i++) {
                int finalI = i;
                int rarity = (i % 5) + 1;

                trades.get(rarity).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 17 + (rarity*6)),
                        new ItemStack(itemsList.get(finalI).get(), 1),
                        2, 11, 0.4F
                ));

                trades.get(rarity).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 15 + (rarity*6)),
                        new ItemStack(itemsList.get(finalI).get(), 1),
                        2, 11, 0.4F
                ));
            }
        }
    }
}
