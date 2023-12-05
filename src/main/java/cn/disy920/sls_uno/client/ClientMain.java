package cn.disy920.sls_uno.client;

import cn.disy920.sls_uno.card.Card;
import net.fabricmc.api.ClientModInitializer;

public class ClientMain implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Card.registerCardGroup();
    }
}
