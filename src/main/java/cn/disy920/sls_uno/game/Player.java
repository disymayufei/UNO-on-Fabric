package cn.disy920.sls_uno.game;

import com.google.common.base.Preconditions;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Player {
    private static final int MAX_WAITING_ROUNDS = 3;
    private static final Map<UUID, Player> cache = new HashMap<>();
    private final UUID uuid;
    private final MinecraftServer serverHandle;
    private Game game;
    private WeakReference<ServerPlayerEntity> nmsRef;
    private int waitingRounds = MAX_WAITING_ROUNDS;

    private Player(ServerPlayerEntity serverPlayer) {
        this.uuid = serverPlayer.getUuid();
        this.nmsRef = new WeakReference<>(serverPlayer);
        this.serverHandle = serverPlayer.getServer();
    }

    public ServerPlayerEntity getNMSPlayer() {
        Preconditions.checkState(isOnline(), "Tried to get the player object when the player is not online");
        return getOrRefresh();
    }

    public MinecraftServer getServer() {
        return serverHandle;
    }

    public boolean isOnline() {
        var handle = getOrRefresh();
        return handle != null;
    }

    void markOffline() {
        nmsRef = null;
    }

    private ServerPlayerEntity getOrRefresh() {
        if (nmsRef.get() == null) {
            var fetchResult = serverHandle.getPlayerManager().getPlayer(uuid);
            if (fetchResult != null) {
                nmsRef = new WeakReference<>(fetchResult);
            }
            return fetchResult;
        }
        return nmsRef.get();
    }

    public int decreaseWaitingRound() {
        return --waitingRounds;
    }

    public void resetWaitingRounds() {
        waitingRounds = MAX_WAITING_ROUNDS;
    }

    private Player refresh(ServerPlayerEntity player) {
        Preconditions.checkArgument(player.getUuid().equals(uuid), "Incompatible player object");
        if (nmsRef != null) {
            if (nmsRef.get() != player) {
                nmsRef = new WeakReference<>(player);
            } // or we don't need to update
        }
        return this;
    }

    /*
     * Only called by Game#addPlayer.
     */
    void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public static Player wrap(ServerPlayerEntity player) {
        return cache.computeIfAbsent(player.getUuid(), unused -> new Player(player)).refresh(player);
    }

}
