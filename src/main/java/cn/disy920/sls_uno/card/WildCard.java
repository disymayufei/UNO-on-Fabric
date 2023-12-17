package cn.disy920.sls_uno.card;

import cn.disy920.sls_uno.AbstractUNOCard;
import cn.disy920.sls_uno.card.enums.CardType;
import cn.disy920.sls_uno.card.enums.Color;
import cn.disy920.sls_uno.exception.ColorHasSetException;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;

public class WildCard extends AbstractUNOCard implements UNOCard {
    private final CardType cardType;

    private Color cardColor = null;

    public WildCard(CardType cardType, Identifier identifier) {
        super(identifier, new FabricItemSettings());
        this.cardType = cardType;
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
