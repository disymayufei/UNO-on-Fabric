package cn.disy920.sls_uno.game;

import cn.disy920.sls_uno.card.UNOCard;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

public final class CardInventory {
    private final Player player;
    private final Object2IntOpenHashMap<UNOCard> storage = new Object2IntOpenHashMap<>();

    CardInventory(Player player) {
        this.player = player;
    }

    public void addCard(UNOCard card) {
        addCard(card, 1);
    }

    public void addCard(UNOCard card, int count) {
        storage.addTo(card, count);
    }

    public void removeCard(UNOCard card, int count) {
        addCard(card, -count);
    }

    public void removeAllTyped(UNOCard card) {
        storage.removeInt(card);
    }

    public int getCardCount(UNOCard card) {
        return storage.getInt(card);
    }

    public void clear() {
        storage.clear();
    }

    public void syncToPlayerInventory() {
        // TODO
    }

}
