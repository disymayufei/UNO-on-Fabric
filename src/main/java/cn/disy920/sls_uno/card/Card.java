package cn.disy920.sls_uno.card;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Arrays;

import static cn.disy920.sls_uno.card.Items.ICON_ITEM;

public class Card {
    public static ItemGroup UNO_CARD_GROUP;

    public static void registerCardGroup() {
        Registry.register(
                Registries.ITEM,
                new Identifier("sls_uno", "icon_item"),
                ICON_ITEM.getItem()
        );

        UNO_CARD_GROUP = FabricItemGroup.builder(new Identifier("sls_uno", "uno_cards_group"))
                .displayName(Text.translatable("sls_uno.uno_cards_group"))
                .icon(() -> new ItemStack(ICON_ITEM.getItem()))
                .entries((displayContext, entries) -> Arrays.stream(Items.values())
                        .filter(card -> card.getType() == Type.CARD)
                        .forEach(card -> entries.add(card.getItem()))
                )
                .build();
    }
}
