package cn.disy920.sls_uno;

import cn.disy920.sls_uno.card.CardCache;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
    @Override
    public void onInitialize() {
        CardCache.init();
    }
}
