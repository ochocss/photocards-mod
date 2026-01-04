package net.chocs.photocards.villager;

import com.google.common.collect.ImmutableSet;
import net.chocs.photocards.Photocards;
import net.chocs.photocards.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, Photocards.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Photocards.MOD_ID);

    public static final RegistryObject<PoiType> TRADING_POI = POI_TYPES.register("trading_poi", () -> new PoiType(
            ImmutableSet.copyOf(ModBlocks.TRADING_POST.get().getStateDefinition().getPossibleStates()), 1, 2));

    public static final RegistryObject<VillagerProfession> PC_TRADER = VILLAGER_PROFESSIONS.register("pc_trader", () -> new VillagerProfession(
            "pc_trader", holder -> holder.get() == TRADING_POI.get(), holder -> holder.get() == TRADING_POI.get(),
            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_LIBRARIAN));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
