package cn.disy920.sls_uno.game;

import cn.disy920.sls_uno.card.UNOCard;
import net.minecraft.server.network.ServerPlayerEntity;

public class GameEventHandlerImpl implements GameEventHandler {
    private final Game game;

    public GameEventHandlerImpl(Game game) {
        this.game = game;
    }

    @Override
    public void currentPlayerChanged(ServerPlayerEntity player, CurrentPlayerChangedReason reason) {
        // TODO notification here?
    }

    @Override
    public void playerConsumeCard(ServerPlayerEntity who, UNOCard card) {
        // TODO implement card check here
    }

    @Override
    public void playerReconnected(Player who) {
        // TODO notification here?
        who.resetWaitingRounds();
    }

    @Override
    public void playerQuit(Player who) {
        // TODO notification here?
        var currentPlayer = game.getCurrentPlayer();
        if (who == currentPlayer) {
            who.getServer().execute(() -> {
                game.nextCommonRound(CurrentPlayerChangedReason.PLAYER_LEFT);
            });
        }
        who.markOffline();
    }
}
