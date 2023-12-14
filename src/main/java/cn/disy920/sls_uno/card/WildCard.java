package cn.disy920.sls_uno.card;

import cn.disy920.sls_uno.card.enums.CardType;
import cn.disy920.sls_uno.card.enums.Color;
import cn.disy920.sls_uno.exception.ColorHasSetException;
import net.minecraft.item.Item;

public class WildCard implements UNOCard {

    private final CardType cardType;
    private final Item item;

    private Color cardColor = null;

    public WildCard(CardType cardType, Item item) {
        this.cardType = cardType;
        this.item = item;
    }

    /**
     * Returns whether the color of the card has been set
     */
    public boolean isColorSet() {
        return cardColor == null;
    }

    /**
     * If the color of the card is set, return the transformed color; otherwise, return a null value
     * @return the transformed color
     */
    public Color getTransformedColor() {
        return cardColor;
    }

    public void setCardColor(Color color) {
        if (isColorSet()) {
            throw new ColorHasSetException("This card has set color " + cardColor.name().toLowerCase());
        }

        cardColor = color;
    }

    @Override
    public Item getItem() {
        return item;
    }

    @Override
    public CardType getType() {
        return cardType;
    }

    @Override
    public int getScore() {
        return 50;
    }

    @Override
    public int getCardNum() {
        return 4;
    }
}
