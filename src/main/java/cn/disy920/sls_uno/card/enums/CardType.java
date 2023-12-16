package cn.disy920.sls_uno.card.enums;

import cn.disy920.sls_uno.card.CardCache;
import cn.disy920.sls_uno.card.FunctionalCard;
import cn.disy920.sls_uno.card.NumberCard;
import cn.disy920.sls_uno.card.WildCard;

public enum CardType {
    NUMBER,
    SKIP(0),
    REVERSE(1),
    DRAW_2(2),
    WILD {
        @Override
        public WildCard getAsWild() {
            return CardCache.WILD;
        }
    },
    WILD_DRAW_4 {
        @Override
        public WildCard getAsWild() {
            return CardCache.WILD_DRAW_4;
        }
    };

    private final int index;

    CardType() {
        this(-1);
    }

    CardType(int index) {
        this.index = index;
    }

    public boolean isWild() {
        return getAsWild() != null;
    }

    public int getIndex() {
        return index;
    }

    public boolean indexUnavailable() {
        return getIndex() == -1;
    }

    /**
     * Get the wild card object represented by this value.
     *
     * @return The wild card object, null if not a wild card type
     */
    public WildCard getAsWild() {
        return null;
    }

    /**
     * Get the functional card object using the provided argument.
     *
     * @param color The color
     * @return The card object, null if not a functional card type
     */
    public FunctionalCard getAsFunctional(Color color) {
        return indexUnavailable() ? null : CardCache.basicFunctionalCard.get(color.getIndex() * 3 + getIndex());
    }

    /**
     * Get the number card object using the provided argument.
     *
     * @param color The color
     * @param num The num
     * @return The card object, null if not a number card type
     */
    public NumberCard getAsNumber(Color color, int num) {
        if (color.getIndex() == -1) {
            return null;
        }
        return CardCache.numberCard.get(color.getIndex() * 10 + num);
    }
}
