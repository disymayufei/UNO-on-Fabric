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
        // skip的num值为10，reverse为11，+2为12，其余均为-1
        //RED
        RED_0(Color.RED, 0, Items.CARD_0_RED.getItem()),
        RED_1(Color.RED, 1, Items.CARD_1_RED.getItem()),
        RED_2(Color.RED,2,Items.CARD_2_RED.getItem()),
        RED_3(Color.RED, 3, Items.CARD_3_RED.getItem()),
        RED_4(Color.RED, 4, Items.CARD_4_RED.getItem()),
        RED_5(Color.RED, 5, Items.CARD_5_RED.getItem()),
        RED_6(Color.RED, 6, Items.CARD_6_RED.getItem()),
        RED_7(Color.RED, 7, Items.CARD_7_RED.getItem()),
        RED_8(Color.RED, 8, Items.CARD_8_RED.getItem()),
        RED_9(Color.RED, 9, Items.CARD_9_RED.getItem()),
        RED_skip(Color.RED, 10, Items.CARD_SKIP_RED.getItem()),
        RED_reverse(Color.RED, 11, Items.CARD_REVERSE_RED.getItem()),
        RED_draw_2(Color.RED, 12, Items.CARD_DRAW_2_RED.getItem()),
        //YELLOW
        YELLOW_0(Color.YELLOW, 0, Items.CARD_0_YELLOW.getItem()),
        YELLOW_1(Color.YELLOW, 1, Items.CARD_1_YELLOW.getItem()),
        YELLOW_2(Color.YELLOW,2,Items.CARD_2_YELLOW.getItem()),
        YELLOW_3(Color.YELLOW, 3, Items.CARD_3_YELLOW.getItem()),
        YELLOW_4(Color.YELLOW, 4, Items.CARD_4_YELLOW.getItem()),
        YELLOW_5(Color.YELLOW, 5, Items.CARD_5_YELLOW.getItem()),
        YELLOW_6(Color.YELLOW, 6, Items.CARD_6_YELLOW.getItem()),
        YELLOW_7(Color.YELLOW, 7, Items.CARD_7_YELLOW.getItem()),
        YELLOW_8(Color.YELLOW, 8, Items.CARD_8_YELLOW.getItem()),
        YELLOW_9(Color.YELLOW, 9, Items.CARD_9_YELLOW.getItem()),
        YELLOW_skip(Color.YELLOW, 10, Items.CARD_SKIP_YELLOW.getItem()),
        YELLOW_reverse(Color.YELLOW, 11, Items.CARD_REVERSE_YELLOW.getItem()),
        YELLOW_draw_2(Color.YELLOW, 12, Items.CARD_DRAW_2_YELLOW.getItem()),
        //BLUE
        BLUE_0(Color.BLUE, 0, Items.CARD_0_BLUE.getItem()),
        BLUE_1(Color.BLUE, 1, Items.CARD_1_BLUE.getItem()),
        BLUE_2(Color.BLUE,2,Items.CARD_2_BLUE.getItem()),
        BLUE_3(Color.BLUE, 3, Items.CARD_3_BLUE.getItem()),
        BLUE_4(Color.BLUE, 4, Items.CARD_4_BLUE.getItem()),
        BLUE_5(Color.BLUE, 5, Items.CARD_5_BLUE.getItem()),
        BLUE_6(Color.BLUE, 6, Items.CARD_6_BLUE.getItem()),
        BLUE_7(Color.BLUE, 7, Items.CARD_7_BLUE.getItem()),
        BLUE_8(Color.BLUE, 8, Items.CARD_8_BLUE.getItem()),
        BLUE_9(Color.BLUE, 9, Items.CARD_9_BLUE.getItem()),
        BLUE_skip(Color.BLUE, 10, Items.CARD_SKIP_BLUE.getItem()),
        BLUE_reverse(Color.BLUE, 11, Items.CARD_REVERSE_BLUE.getItem()),
        BLUE_draw_2(Color.BLUE, 12, Items.CARD_DRAW_2_BLUE.getItem()),
        //GREEN
        GREEN_0(Color.GREEN, 0, Items.CARD_0_GREEN.getItem()),
        GREEN_1(Color.GREEN, 1, Items.CARD_1_GREEN.getItem()),
        GREEN_2(Color.GREEN,2,Items.CARD_2_GREEN.getItem()),
        GREEN_3(Color.GREEN, 3, Items.CARD_3_GREEN.getItem()),
        GREEN_4(Color.GREEN, 4, Items.CARD_4_GREEN.getItem()),
        GREEN_5(Color.GREEN, 5, Items.CARD_5_GREEN.getItem()),
        GREEN_6(Color.GREEN, 6, Items.CARD_6_GREEN.getItem()),
        GREENE_7(Color.GREEN, 7, Items.CARD_7_GREEN.getItem()),
        GREEN_8(Color.GREEN, 8, Items.CARD_8_GREEN.getItem()),
        GREEN_9(Color.GREEN, 9, Items.CARD_9_GREEN.getItem()),
        GREEN_skip(Color.GREEN, 10, Items.CARD_SKIP_GREEN.getItem()),
        GREEN_reverse(Color.GREEN, 11, Items.CARD_REVERSE_GREEN.getItem()),
        GREEN_draw_2(Color.GREEN, 12, Items.CARD_DRAW_2_GREEN.getItem()),
        //WILD
        WILD(Color.BLACK,1,Items.CARD_WILD.getItem()),
        WILD_draw_4(Color.BLACK,2,Items.CARD_WILD_DRAW_4.getItem());

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
