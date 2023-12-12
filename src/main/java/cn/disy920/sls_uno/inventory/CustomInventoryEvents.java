package cn.disy920.sls_uno.inventory;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;

/**
 * Events related to {@link CustomInventory}.
 * Events under this class only got called in SERVER environment.
 *
 * @author SNWCreations
 */
public class CustomInventoryEvents {

    /**
     * Got called when player clicks on our {@link CustomInventory}.
     */
    public static final Event<Clicked> CLICK = EventFactory.createArrayBacked(Clicked.class,
            (player, inv, slot, itemClicked) -> true,
            listeners -> ((player, inv, slot, itemClicked) -> {
                boolean noCancel = true;
                boolean isAir = Items.AIR.equals(itemClicked.getItem());
                for (Clicked listener : listeners) {
                    if (isAir && listener.rejectAirClicks()) {
                        continue;
                    }
                    noCancel = noCancel & listener.onClick(player, inv, slot, itemClicked);
                }
                return noCancel;
            }));

    public interface Clicked {
        /**
         * @return True if we should NOT cancel the click
         */
        boolean onClick(ServerPlayerEntity player, CustomInventory inv, int slot, ItemStack itemClicked);

        /**
         * Override this and return false if you want to hook into clicks on AIR items!
         * @return True if we should NOT be called when player clicking on AIR items
         */
        default boolean rejectAirClicks() {
            return true;
        }
    }

    /**
     * Got called when player no longer views the {@link CustomInventory}.
     */
    public static final Event<Closing> CLOSING = EventFactory.createArrayBacked(Closing.class,
            (player, cinv) -> {},
            listeners -> (player, cinv) -> {
                for (Closing listener : listeners) {
                    listener.onClose(player, cinv);
                }
            });

    public interface Closing {
        void onClose(ServerPlayerEntity player, CustomInventory cinv);
    }
}
