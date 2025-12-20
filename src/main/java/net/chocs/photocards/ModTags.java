package net.chocs.photocards;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static final TagKey<Item> CARD = TagKey.create(
        net.minecraft.core.registries.Registries.ITEM,
        new ResourceLocation("photocards", "card")
    );
}