package cn.disy920.sls_uno.card;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
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

    public enum Basic {
        RED_0(Color.RED, 0, Items.CARD_0_RED.getItem()),
        RED_1(Color.RED, 1, Items.CARD_1_RED.getItem());

        // skip的num值为10，reverse为11，+2为12，其余均为-1
        final int num;
        final Color color;
        final Item item;

        Basic(Color color, int num, Item item) {
            this.color = color;
            this.num = num;
            this.item = item;
        }

        public int getNum() {
            return num;
        }

        public Color getColor() {
            return color;
        }

        public Item getItem() {
            return item;
        }
    }
}
