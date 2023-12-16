package cn.disy920.sls_uno.game.screen;

import cn.disy920.sls_uno.card.UNOCard;

public interface CardButton extends UNOButton {
    /**
     * Get the card represented by this button.
     *
     * @return The card
     */
    UNOCard getCard();
}
