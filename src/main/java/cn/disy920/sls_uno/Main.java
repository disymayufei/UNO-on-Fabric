package cn.disy920.sls_uno;

import cn.disy920.sls_uno.card.CardCache;
import cn.disy920.sls_uno.game.CurrentPlayerChangedReason;
import cn.disy920.sls_uno.game.Player;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

public class Main implements ModInitializer {
    @Override
    public void onInitialize() {
        CardCache.init();
    }

    private void setupEventListeners() {
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
            var player = handler.player;
            var wrapped = Player.wrap(player);
            var game = wrapped.getGame();
            if (game != null) {
                var currentPlayer = game.getCurrentPlayer();
                if (wrapped == currentPlayer) {
                    game.nextCommonRound(CurrentPlayerChangedReason.PLAYER_LEFT);
                }
            }
        });
    }
}
