package cn.disy920.sls_uno.stdlib;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Our {@link net.minecraft.inventory.Inventory} implementation, simulating the large chest (9x6 size).
 *
 * @author SNWCreations
 */
// sample code to test this! Put it at somewhere you like!
//        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
//            dispatcher.register(literal("test").executes(ctx -> {
//                ServerPlayerEntity player = ctx.getSource().getPlayerOrThrow();
//                new CustomInventory(Text.literal("test")).open(player, i -> {
//                    i.setStack(1, new ItemStack(Items.GRASS_BLOCK));
//                });
//                return 0;
//            }));
//        });
//        CustomInventoryEvents.CLICK.register((player, inv, slot, itemClicked) -> {
//            System.out.println(itemClicked);
//            return false;
//        });
//        CustomInventoryEvents.CLOSING.register((player, cinv) -> {
//            System.out.println("Closing inv on " + player);
//        });
public class CustomInventory implements Inventory {
    private final DefaultedList<ItemStack> stacks;
    private final List<PlayerEntity> viewers;
    private final Text text;

    public CustomInventory(Text text) {
        this.text = text;
        this.stacks = DefaultedList.ofSize(54, ItemStack.EMPTY);
        this.viewers = new ArrayList<>();
    }

    /**
     * Open this inventory to the specified player.
     *
     * @param player The player who will see this inventory
     * @param beforeOpen The initialize code block before opening this inventory to the player.
     *                   Feel free to do some preparations like placing items!
     */
    public void open(ServerPlayerEntity player, @Nullable Consumer<CustomInventory> beforeOpen) {
        if (viewers.contains(player)) { // can't re-open when already viewing
            return;
        }
        if (beforeOpen != null) {
            beforeOpen.accept(this);
        }
        player.openHandledScreen(new NamedScreenHandlerFactory() {
            @Override
            public Text getDisplayName() {
                return CustomInventory.this.getTitle();
            }

            @Override
            public ScreenHandler createMenu(int syncId,
                                            PlayerInventory playerInventory,
                                            PlayerEntity player) {
                return new GenericContainerScreenHandler(
                        ScreenHandlerType.GENERIC_9X6, syncId,
                        player.getInventory(), CustomInventory.this, 6) {
                    @Override
                    public ItemStack quickMove(PlayerEntity player, int slot) {
                        return ItemStack.EMPTY;
                    }
                };
            }
        });
    }

    @Override
    public int size() {
        return stacks.size();
    }

    @Override
    public boolean isEmpty() {
        return stacks.isEmpty();
    }

    @Override
    public ItemStack getStack(int slot) {
        return stacks.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack stack = getStack(slot);
        if (stack == ItemStack.EMPTY) {
            return stack;
        } else {
            if (stack.getCount() <= amount) {
                setStack(slot, ItemStack.EMPTY);
                return ItemStack.EMPTY;
            } else {
                stack.decrement(slot);
                stack = stack.copy();
            }
        }
        markDirty(); // actually makes no sense lol, just to follow the rules from Minecraft code
        return stack;
    }

    @Override
    public ItemStack removeStack(int slot) {
        ItemStack stack = getStack(slot);
        setStack(slot, ItemStack.EMPTY);
        return stack;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        stacks.set(slot, stack);
    }

    @Override
    public void markDirty() {
        // nop here because this is just an in-memory object.
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return viewers.contains(player);
    }

    @Override
    public void clear() {
        stacks.clear();
    }

    @Override
    public void onOpen(PlayerEntity player) {
        viewers.add(player);
    }

    @Override
    public void onClose(PlayerEntity player) {
        if (player instanceof ServerPlayerEntity) { // prevent crash!
            CustomInventoryEvents.CLOSING.invoker().onClose((ServerPlayerEntity) player, this);
        }
        viewers.remove(player);
    }

    public Text getTitle() {
        return text;
    }
}
