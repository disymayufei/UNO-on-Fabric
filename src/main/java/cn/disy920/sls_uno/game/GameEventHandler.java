package cn.disy920.sls_uno.game;

import cn.disy920.sls_uno.card.UNOCard;
import net.minecraft.server.network.ServerPlayerEntity;

public interface GameEventHandler {

    void currentPlayerChanged(ServerPlayerEntity player, CurrentPlayerChangedReason reason);

    void playerConsumeCard(Player who, UNOCard card);

    void playerReconnected(Player who);

    void playerQuit(Player who);
}
