package cn.disy920.sls_uno.client;

import cn.disy920.sls_uno.card.CardItemGroup;
import net.fabricmc.api.ClientModInitializer;

public class ClientMain implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CardItemGroup.registerCardGroup();
    }
}
