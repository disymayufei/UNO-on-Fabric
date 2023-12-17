package cn.disy920.sls_uno.card;

import cn.disy920.sls_uno.AbstractUNOCard;
import cn.disy920.sls_uno.card.enums.CardType;
import cn.disy920.sls_uno.card.enums.Color;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;

public class FunctionalCard extends AbstractUNOCard implements ColorfulCard {
    private final CardType cardType;
    private final Color color;

    public FunctionalCard(Color color, CardType cardType, Identifier identifier) {
        super(identifier, new FabricItemSettings());
        this.color = color;
        this.cardType = cardType;
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
