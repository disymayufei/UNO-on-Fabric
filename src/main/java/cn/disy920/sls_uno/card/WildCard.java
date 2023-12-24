package cn.disy920.sls_uno.card;

import cn.disy920.sls_uno.AbstractUNOCard;
import cn.disy920.sls_uno.card.enums.CardType;
import cn.disy920.sls_uno.card.enums.Color;
import cn.disy920.sls_uno.exception.ColorHasSetException;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;

public class WildCard extends AbstractUNOCard implements UNOCard, Cloneable {
    private final CardType cardType;

    private Color cardColor = null;

    public WildCard(CardType cardType, Identifier identifier) {
        super(identifier, new FabricItemSettings());
        this.cardType = cardType;
    }

    private WildCard(CardType cardType, Identifier identifier, Color color) {
        super(identifier, new FabricItemSettings());
        this.cardType = cardType;
        this.cardColor = color;
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

    public WildCard setCardColor(Color color) {
        if (isColorSet()) {
            throw new ColorHasSetException("This card has set color " + cardColor.name().toLowerCase());
        }

        WildCard wildCard = this.clone();
        wildCard.cardColor = color;
        return wildCard;
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

    @Override
    protected WildCard clone() {
        try {
            return (WildCard) super.clone();
        }
        catch (CloneNotSupportedException ignored) {}
    }
}
