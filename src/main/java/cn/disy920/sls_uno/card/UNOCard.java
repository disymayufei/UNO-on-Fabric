package cn.disy920.sls_uno.card;

import cn.disy920.sls_uno.card.enums.CardType;
import net.minecraft.item.Item;

public interface UNOCard {
    Item getItem();
    CardType getType();

    /**
     * Get the penalty score of the card after winning
     */
    int getScore();

    /**
     * Get the number of the card in the deck
     */
    int getCardNum();
}
