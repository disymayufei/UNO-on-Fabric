package cn.disy920.sls_uno.card;

import cn.disy920.sls_uno.card.enums.Color;

public interface ColorfulCard extends UNOCard {

    /**
     * Get the color of the card
     * @return the color of the card
     */
    Color getColor();
}
