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
    final Deque<UNOCard> usedCards;
    final Deque<UNOCard> availableCards;
    final Circle<ServerPlayerEntity> players;
    Circle.Entry<ServerPlayerEntity> currentPlayer;
    final GameEventHandler eventHandler;

    public Game(ServerPlayerEntity roomOwner) {
        usedCards = new ArrayDeque<>();
        availableCards = new ArrayDeque<>();
        players = new Circle<>() {
            @Override
            protected void beforeDisconnectEntry(Entry<ServerPlayerEntity> entryBeingDisconnected) {
                if (Objects.equals(entryBeingDisconnected.obj, currentPlayer.obj)) {
                    // TODO handle player quit
                }
            }
        };
        players.add(roomOwner);
        currentPlayer = players.getEntryOf(roomOwner);
        eventHandler = null; // TODO put impl here
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
            usedCards.push(pop);
        } while (pop.getType().isWild());
        for (ServerPlayerEntity player : players) {
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

    public void reverseOrder() {
        reversingOrder = !reversingOrder;
    }

    public void nextRound() {
        // TODO check for special case, if not, call nextCommonRound()
    }

    public void nextCommonRound() {
        setupCommonRound(reversingOrder ? currentPlayer.getPrevious() : currentPlayer.getNext(),
                CurrentPlayerChangedReason.NORMAL);
    }

    private void setupCommonRound(Circle.Entry<ServerPlayerEntity> entry, CurrentPlayerChangedReason reason) {
        this.currentPlayer = entry;
        eventHandler.currentPlayerChanged(entry.obj, reason);
    }

    private void ensureDataClean() {
        usedCards.clear();
        availableCards.clear();
    }

    private void cleanup() {
        currentPlayer = null;
//        players.clear(); // maybe will be played again?
        reversingOrder = false;
    }
}
