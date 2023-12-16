package cn.disy920.sls_uno.card;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public final class CardItemGroup {
    public static ItemGroup UNO_CARD_GROUP;

    private static final Item ICON_ITEM = new Item(new FabricItemSettings());

    public static void registerCardGroup() {
        Registry.register(
                Registries.ITEM,
                new Identifier("sls_uno", "icon_item"),
                ICON_ITEM
        );

        UNO_CARD_GROUP = FabricItemGroup.builder(new Identifier("sls_uno", "uno_cards_group"))
                .displayName(Text.translatable("sls_uno.uno_cards_group"))
                .icon(() -> new ItemStack(ICON_ITEM))
                .entries(
                        (displayContext, entries) -> {
                            // add all number card
                            for (NumberCard numberCard : CardCache.numberCard) {
                                entries.add(numberCard.getItem());
                            }

                            // add all basic functional card
                            for (FunctionalCard functionalCard : CardCache.basicFunctionalCard) {
                                entries.add(functionalCard.getItem());
                            }

                            // add all basic wild card
                            for (WildCard wildCard : CardCache.basicWildCard) {
                                entries.add(wildCard.getItem());
                            }
                        }
                )
                .build();
    }
}
