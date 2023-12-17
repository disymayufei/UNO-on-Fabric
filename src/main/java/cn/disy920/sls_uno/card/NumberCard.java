package cn.disy920.sls_uno.card;

import cn.disy920.sls_uno.AbstractUNOCard;
import cn.disy920.sls_uno.card.enums.CardType;
import cn.disy920.sls_uno.card.enums.Color;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;

public final class NumberCard extends AbstractUNOCard implements ColorfulCard {
    private final int code;  // Number on the face of the card
    private final Color color;

    public NumberCard(Color color, int code, Identifier identifier) {
        super(identifier, new FabricItemSettings());
        this.color = color;
        this.code = code;
    }

    @Override
    public CardType getType() {
        return CardType.NUMBER;
    }

    @Override
    public int getScore() {
        return code;
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
