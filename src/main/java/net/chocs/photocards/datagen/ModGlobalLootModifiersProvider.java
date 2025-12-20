package net.chocs.photocards.datagen;

import net.chocs.photocards.Photocards;
import net.chocs.photocards.item.ModItems;
import net.chocs.photocards.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
        public ModGlobalLootModifiersProvider(PackOutput output) {
                super(output, Photocards.MOD_ID);
        }

        @Override
        protected void start() {
                ModItems.ITEMS.getEntries().stream()
                                .filter(itemRegistryObject -> itemRegistryObject.getId().getPath().contains("noeasy"))
                                .forEach(itemRegistryObject -> {
                                        add(itemRegistryObject.get() + "_from_village_plains",
                                                        new AddItemModifier(new LootItemCondition[] {
                                                                        new LootTableIdCondition.Builder(
                                                                                        new ResourceLocation(
                                                                                                        "chests/village/village_plains_house"))
                                                                                        .build(),
                                                                        LootItemRandomChanceCondition.randomChance(0.5F)
                                                                                        .build()
                                                        }, itemRegistryObject.get()));
                                });

                // FILTER (NUM OF CARDS)
                // noeasy (8)
                addAllFromGroup("noeasy", "_from_village_plains",
                                "chests/village/village_plains_house", 0.25F);

                addAllFromGroup("noeasy", "_from_village_savanna",
                                "chests/village/village_savanna_house", 0.25F);

                addAllFromGroup("noeasy", "_from_village_desert",
                                "chests/village/village_desert_house", 0.25F);

                addAllFromGroup("noeasy", "_from_village_snowy",
                                "chests/village/village_snowy_house", 0.25F);

                addAllFromGroup("noeasy", "_from_village_taiga",
                                "chests/village/village_taiga_house", 0.25F);

                // mixtape (2)
                addAllFromGroup("mixtape", "_from_armorer",
                                "chests/village/village_armorer", 0.5F);

                addAllFromGroup("mixtape", "_from_fletcher",
                                "chests/village/village_fletcher", 0.5F);

                // not (2)
                addAllFromGroup("not", "_from_cartographer",
                                "chests/village/village_cartographer", 0.5F);

                addAllFromGroup("not", "_from_mason",
                                "chests/village/village_mason", 0.5F);

                // who (4)
                addAllFromGroup("who", "_from_weaponsmith",
                                "chests/village/village_weaponsmith", 0.4F);

                addAllFromGroup("who", "_from_toolsmith",
                                "chests/village/village_toolsmith", 0.4F);

                // maxident (7)
                addAllFromGroup("maxident", "_from_temple",
                                "chests/village/village_temple", 0.5F);

                addAllFromGroup("maxident", "_from_tannery",
                                "chests/village/village_tannery", 0.3F);

                addAllFromGroup("maxident", "_from_desert_pyramid",
                                "chests/desert_pyramid", 0.2F);

                // go (3)
                addAllFromGroup("go", "_from_shepherd",
                                "chests/village/village_shepherd", 0.3F);

                addAllFromGroup("go", "_from_fisher",
                                "chests/village/village_fisher", 0.3F);

                // greetings (1)
                addAllFromGroup("greetings", "_from_igloo_chest",
                                "chests/igloo_chest", 1F);

                // 5star (4)
                addAllFromGroup("5star", "_abandoned_mineshaft",
                                "chests/village/abandoned_mineshaft", 0.3F);

                // rock (1)
                addAllFromGroup("rock", "_from_ruined_portal",
                                "chests/village/ruined_portal", 0.3F);

                // ordinary (4)
                addAllFromGroup("ordinary", "_from_abandoned_mineshaft",
                                "chests/village/abandoned_mineshaft", 0.3F);

                // stay (3)
                addAllFromGroup("ordinary", "_from_shipwreck_map",
                                "chests/village/shipwreck_map", 0.6F);

                addAllFromGroup("ordinary", "_from_shipwreck_supply",
                                "chests/village/shipwreck_supply", 0.6F);

                addAllFromGroup("ordinary", "_from_shipwreck_treasure",
                                "chests/village/shipwreck_treasure", 0.6F);

                // yellow (1)
                addAllFromGroup("ordinary", "_from_abandoned_mineshaft",
                                "chests/village/abandoned_mineshaft", 0.3F);
        }

        private void addAllFromGroup(String group, String genericJsonName, String lootTableLocation, float chance) {
                ModItems.ITEMS.getEntries().stream()
                                .filter(itemRegistryObject -> itemRegistryObject.getId().getPath().contains(group))
                                .forEach(itemRegistryObject -> {
                                        add(itemRegistryObject.get() + genericJsonName,
                                                        new AddItemModifier(new LootItemCondition[] {
                                                                        new LootTableIdCondition.Builder(
                                                                                        new ResourceLocation(
                                                                                                        lootTableLocation))
                                                                                        .build(),
                                                                        LootItemRandomChanceCondition
                                                                                        .randomChance(chance).build()
                                                        }, itemRegistryObject.get()));
                                });
        }
}
