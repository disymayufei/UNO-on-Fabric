package cn.disy920.sls_uno.card;

import cn.disy920.sls_uno.card.enums.CardType;
import cn.disy920.sls_uno.card.enums.Color;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static cn.disy920.sls_uno.card.enums.Color.*;

public final class NumberCard implements ColorfulCard {
    private final int code;  // Number on the face of the card
    private final Color color;
    private final Item item;

    public NumberCard(Color color, int code, Item item) {
        this.color = color;
        this.code = code;
        this.item = item;
    }

    @Override
    public Item getItem() {
        return item;
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
