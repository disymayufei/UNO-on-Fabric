package cn.disy920.sls_uno.game;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

import java.lang.ref.WeakReference;
import java.util.UUID;

public final class Player {
    private final UUID uuid;
    private final MinecraftServer serverHandle;
    private WeakReference<ServerPlayerEntity> nmsRef;

    public Player(ServerPlayerEntity serverPlayer) {
        this.uuid = serverPlayer.getUuid();
        this.nmsRef = new WeakReference<>(serverPlayer);
        this.serverHandle = serverPlayer.getServer();
    }

    public ServerPlayerEntity getNMSPlayer() {
        return getOrRefresh();
    }

    public boolean isOnline() {
        var handle = getOrRefresh();
        return handle != null;
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

}
