package cn.disy920.sls_uno.inventory.mixin;

import cn.disy920.sls_uno.inventory.CustomInventory;
import cn.disy920.sls_uno.inventory.CustomInventoryEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ClickType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ScreenHandler.class)
public abstract class ScreenHandlerMixin {
    @Shadow protected abstract boolean handleSlotClick(PlayerEntity player, ClickType clickType, Slot slot, ItemStack stack, ItemStack cursorStack);

    @Redirect(at = @At(value = "INVOKE",
            target = "Lnet/minecraft/screen/ScreenHandler;handleSlotClick(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/ClickType;Lnet/minecraft/screen/slot/Slot;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;)Z"),
            method = "internalOnSlotClick")
    private boolean wrappedHandle(ScreenHandler instance, PlayerEntity player,
                                  ClickType clickType, Slot slot, ItemStack stack, ItemStack cursorStack) {
        if (((Object) this) instanceof GenericContainerScreenHandler generic) {
            if (generic.getInventory() instanceof CustomInventory cinv && slot.inventory == cinv) { // yes our time!
                // we're sure the player is server-sided
                // because this mixin only available in SERVER environment
                boolean noCancel = CustomInventoryEvents.CLICK.invoker()
                        .onClick((ServerPlayerEntity) player, cinv, slot.id, stack);
                if (!noCancel) {
                    return true; // already handled
                }
            }
        }
        // not our time!
        return handleSlotClick(player, clickType, slot, stack, cursorStack); // should work like vanilla
    }
}
