package cn.disy920.sls_uno.card;

import cn.disy920.sls_uno.card.enums.CardType;
import cn.disy920.sls_uno.card.enums.Color;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Collection;

import static cn.disy920.sls_uno.card.enums.CardType.*;
import static cn.disy920.sls_uno.card.enums.Color.*;

public final class CardCache {
    public static ImmutableList<NumberCard> numberCard;
    public static ImmutableList<FunctionalCard> basicFunctionalCard;
    public static ImmutableList<WildCard> basicWildCard;
    public static ImmutableList<UNOCard> gameCards;
    public static final WildCard WILD = new WildCard(CardType.WILD,
            new Identifier("sls_uno", "card_wild")
    );
    public static final WildCard WILD_DRAW_4 = new WildCard(CardType.WILD_DRAW_4,
            new Identifier("sls_uno", "card_wild_draw_4")
    );

    public static void init() {
        initNumberCard();
        initBasicFunctionalCard();
        initGameCard();
    }

    private static void initGameCard() {
        var result = new ArrayList<UNOCard>();
        computeCard(result, numberCard);
        computeCard(result, basicFunctionalCard);
        computeCard(result, basicWildCard);
        gameCards = ImmutableList.copyOf(result);
    }

    private static <T extends UNOCard> void computeCard(Collection<UNOCard> mutableC, Collection<T> from) {
        for (T t : from) {
            for (int i = 0; i < t.getCardNum(); i++) {
                mutableC.add(t);
            }
        }
    }

    private static void initNumberCard() {
        var array = new NumberCard[40];
        final Color[] colors = {RED, YELLOW, BLUE, GREEN};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                var identifier = new Identifier("sls_uno",
                        ("card_" + j + "_" + colors[i].name()).toLowerCase());

                array[i * 10 + j] = new NumberCard(colors[i], j, identifier);
            }
        }
        numberCard = ImmutableList.copyOf(array);
    }

    private static void initBasicFunctionalCard() {
        var array = new FunctionalCard[12];
        final Color[] colors = {RED, YELLOW, BLUE, GREEN};
        final CardType[] cardTypes = {SKIP, REVERSE, DRAW_2};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                var identifier = new Identifier("sls_uno",
                        ("card_" + cardTypes[j] + "_" + colors[i].name()).toLowerCase());

                array[i * 3 + j] = new FunctionalCard(colors[i], cardTypes[j], identifier);
            }
        }
        basicFunctionalCard = ImmutableList.copyOf(array);
    }

    private CardCache() {
    }
}
