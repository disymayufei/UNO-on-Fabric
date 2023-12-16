package cn.disy920.sls_uno.game.screen;

import org.jetbrains.annotations.Nullable;

public interface UNOScreen {

    @Nullable
    UNOScreen getParent();

    /**
     * Close this screen and let the player's client go back to the parent screen, if any.
     */
    void close();
}
