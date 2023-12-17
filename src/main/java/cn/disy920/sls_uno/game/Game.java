package cn.disy920.sls_uno.game;

import cn.disy920.sls_uno.card.CardCache;
import cn.disy920.sls_uno.card.UNOCard;
import cn.disy920.sls_uno.utils.Circle;
import com.google.common.base.Preconditions;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.*;

public class Game {
    private boolean running;
    boolean reversingOrder;
    final Deque<UNOCard> availableCards;
    final Circle<Player> players;
    Circle.Entry<Player> currentPlayer;
    public final GameEventHandler eventHandler;

    public Game(ServerPlayerEntity roomOwner) {
        availableCards = new ArrayDeque<>();
        players = new Circle<>();
        players.add(Player.wrap(roomOwner));
        currentPlayer = players.getOrigin();
        eventHandler = new GameEventHandlerImpl(this);
    }

    public void start() {
        Preconditions.checkState(!running, "Game already running");
        running = true;
        ensureDataClean();
        List<UNOCard> cards = new ArrayList<>(CardCache.gameCards);
        Collections.shuffle(cards);
        availableCards.addAll(cards);
        UNOCard pop;
        do {
            pop = availableCards.pop();
            availableCards.addLast(pop);
        } while (pop.getType().isWild());
        for (Player wrapper : players) {
            var player = wrapper.getNMSPlayer();
            var inv = player.getInventory();
            for (int i = 0; i < 7; i++) {
                var card = availableCards.pop();
                var stack = card.getItem().getDefaultStack();
                inv.insertStack(stack);
            }
        }
        // TODO open screen?
    }

    public void stop() {
        Preconditions.checkState(running, "Game not running");
        running = false;
        // TODO
    }

    public Player getCurrentPlayer() {
        return currentPlayer != null ? currentPlayer.obj : null;
    }

    public void reverseOrder() {
        reversingOrder = !reversingOrder;
    }

    public void addPlayer(ServerPlayerEntity player) {
        addPlayer(Player.wrap(player));
    }

    public void addPlayer(Player player) {
        Preconditions.checkState(player.isOnline(), "Provided player is not online");
        players.add(player);
        player.setGame(this);
    }

    public void removePlayer(Player player) {
        if (player.getGame() != this) {
            return; // nop because not in this game
        }
        players.remove(player);
        player.setGame(null);
    }

    public void nextRound() {
        // TODO check for special case, if not, call nextCommonRound()
    }

    public void nextCommonRound() {
        nextCommonRound(CurrentPlayerChangedReason.NORMAL);
    }

    public void nextCommonRound(CurrentPlayerChangedReason reason) {
        var next = reversingOrder ? currentPlayer.getPrevious() : currentPlayer.getNext();
        setupCommonRound(next, reason);
    }

    private void setupCommonRound(Circle.Entry<Player> entry, CurrentPlayerChangedReason reason) {
        if (!entry.obj.isOnline()) {
            var next = reversingOrder ? currentPlayer.getPrevious() : currentPlayer.getNext();
            if (entry.obj.decreaseWaitingRound() <= 0) {
                entry.obj.resetWaitingRounds();
                entry.disconnect();
            }
            setupCommonRound(next, CurrentPlayerChangedReason.PLAYER_NOT_ONLINE);
            return;
        }
        this.currentPlayer = entry;
        eventHandler.currentPlayerChanged(entry.obj.getNMSPlayer(), reason);
    }

    private void ensureDataClean() {
        availableCards.clear();
    }

    private void cleanup() {
        currentPlayer = null;
//        players.forEach(this::removePlayer); // maybe will be played again?
        reversingOrder = false;
    }
}
