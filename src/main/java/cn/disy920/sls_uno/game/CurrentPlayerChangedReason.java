package cn.disy920.sls_uno.game;

public enum CurrentPlayerChangedReason {
    NORMAL, // nothing special
    PLAYER_LEFT; // the current player left the game, maybe disconnected from the server or actively left the game
}
