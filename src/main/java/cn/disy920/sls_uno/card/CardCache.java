package cn.disy920.sls_uno.card;

import cn.disy920.sls_uno.card.enums.CardType;
import cn.disy920.sls_uno.card.enums.Color;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static cn.disy920.sls_uno.card.enums.CardType.*;
import static cn.disy920.sls_uno.card.enums.Color.*;

public final class CardCache {
    private static NumberCard[] allNumberCard;
    private static FunctionalCard[] basicFunctionalCard;

    private static WildCard[] basicWildCard;

    static {
        initNumberCard();
        initBasicFunctionalCard();
        initBasicWildCard();
    }

    private static void initNumberCard() {
        allNumberCard = new NumberCard[40];
        final Color[] colors = {RED, YELLOW, BLUE, GREEN};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                Item cardItem = Registry.register(
                        Registries.ITEM,
                        new Identifier("sls_uno", "card_" + j + "_" + colors[i].name().toLowerCase()),
                        new Item(new FabricItemSettings())
                );

                allNumberCard[i * 10 + j] = new NumberCard(colors[i], j, cardItem);
            }
        }
    }

    private static void initBasicFunctionalCard() {
        basicFunctionalCard = new FunctionalCard[12];
        final Color[] colors = {RED, YELLOW, BLUE, GREEN};
        final CardType[] cardTypes = {SKIP, REVERSE, DRAW_2};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                Item cardItem = Registry.register(
                        Registries.ITEM,
                        new Identifier("sls_uno", "card_" + cardTypes[j] + "_" + colors[i].name().toLowerCase()),
                        new Item(new FabricItemSettings())
                );

                basicFunctionalCard[i * 3 + j] = new FunctionalCard(colors[i], cardTypes[j], cardItem);
            }
        }
    }

    private static void initBasicWildCard() {
        basicWildCard = new WildCard[2];

        basicWildCard[0] = new WildCard(WILD, Registry.register(
                Registries.ITEM,
                new Identifier("sls_uno", "card_wild"),
                new Item(new FabricItemSettings())
        ));

        basicWildCard[1] = new WildCard(WILD_DRAW_4, Registry.register(
                Registries.ITEM,
                new Identifier("sls_uno", "card_wild_draw_4"),
                new Item(new FabricItemSettings())
        ));
    }

    public static NumberCard getNumberCard(Color color, int num) {
        if (color == BLACK) {
            return null;
        }

        return allNumberCard[getIndex(color) * 10 + num];
    }

    public static FunctionalCard getBasicFunctionalCard(Color color, CardType cardType) {
        if (color == BLACK) {
            return null;
        }

        int index = getIndex(cardType);
        if (index == -1) {
            return null;
        }

        return basicFunctionalCard[getIndex(color) * 3 + index];
    }

    public static WildCard getBasicWildCard(CardType cardType) {
        if (cardType == WILD) {
            return basicWildCard[0];
        }
        else if (cardType == WILD_DRAW_4) {
            return basicWildCard[1];
        }
        else {
            return null;
        }
    }

    public static NumberCard[] getAllNumberCard() {
        return allNumberCard.clone();
    }

    public static FunctionalCard[] getAllBasicFunctionalCard() {
        return basicFunctionalCard.clone();
    }

    public static WildCard[] getAllBasicWildCard() {
        return basicWildCard.clone();
    }

    private static int getIndex(Color color) {
        int index = -1;
        switch (color) {
            case RED -> index = 0;
            case YELLOW -> index = 1;
            case BLUE -> index = 2;
            case GREEN -> index = 3;
        }

        return index;
    }

    private static int getIndex(CardType cardType) {
        int index = -1;
        switch (cardType) {
            case SKIP -> index = 0;
            case REVERSE -> index = 1;
            case DRAW_2 -> index = 2;
        }

        return index;
    }
}
