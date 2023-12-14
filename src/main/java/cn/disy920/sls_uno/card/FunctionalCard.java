package cn.disy920.sls_uno.card;

import cn.disy920.sls_uno.card.enums.CardType;
import cn.disy920.sls_uno.card.enums.Color;
import net.minecraft.item.Item;

public class FunctionalCard implements ColorfulCard {

    private final CardType cardType;
    private final Color color;
    private final Item item;

    public FunctionalCard(Color color, CardType cardType, Item item) {
        this.color = color;
        this.cardType = cardType;
        this.item = item;
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
        return 20;
    }

    @Override
    public int getCardNum() {
        return 2;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
