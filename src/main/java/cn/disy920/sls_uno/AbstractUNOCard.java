package cn.disy920.sls_uno;

import cn.disy920.sls_uno.card.UNOCard;
import cn.disy920.sls_uno.card.UNOCardItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public abstract class AbstractUNOCard implements UNOCard {
    private final UNOCardItem item;

    public AbstractUNOCard(Identifier identifier, Item.Settings settings) {
        this.item = new UNOCardItem(identifier, settings, this);
    }

    @Override
    public UNOCardItem getItem() {
        return item;
    }
}
