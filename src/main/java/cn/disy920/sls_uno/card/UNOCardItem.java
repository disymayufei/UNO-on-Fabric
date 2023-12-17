package cn.disy920.sls_uno.card;

import cn.disy920.sls_uno.game.Player;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class UNOCardItem extends Item {
    private final UNOCard cardType;
    public UNOCardItem(Identifier identifier, Settings settings, UNOCard cardType) {
        super(settings);
        Registry.register(Registries.ITEM, identifier, this);
        this.cardType = cardType;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            var spe = (ServerPlayerEntity) user;
            var wrapped = Player.wrap(spe);
            var game = wrapped.getGame();
            if (game != null) {
                var current = game.getCurrentPlayer();
                if (current == wrapped) {
                    game.eventHandler.playerConsumeCard(wrapped, cardType);
                } else {
                    // TODO error: not your turn!
                }
            }
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
