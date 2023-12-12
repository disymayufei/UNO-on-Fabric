package cn.disy920.sls_uno.card;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public enum Items {
    // for item group icon
    ICON_ITEM(
            new Item(new FabricItemSettings()),
            Type.ICON
    ),

    // UNO cards
    CARD_0_RED(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_0_red"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_1_RED(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_1_red"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_2_RED(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_2_red"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_3_RED(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_3_red"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_4_RED(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_4_red"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_5_RED(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_5_red"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_6_RED(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_6_red"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_7_RED(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_7_red"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_8_RED(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_8_red"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_9_RED(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_9_red"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_SKIP_RED(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_skip_red"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_REVERSE_RED(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_reverse_red"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_DRAW_2_RED(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_draw_2_red"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_0_YELLOW(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_0_yellow"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_1_YELLOW(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_1_yellow"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_2_YELLOW(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_2_yellow"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_3_YELLOW(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_3_yellow"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_4_YELLOW(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_4_yellow"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_5_YELLOW(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_5_yellow"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_6_YELLOW(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_6_yellow"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_7_YELLOW(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_7_yellow"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_8_YELLOW(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_8_yellow"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_9_YELLOW(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_9_yellow"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_SKIP_YELLOW(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_skip_yellow"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_REVERSE_YELLOW(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_reverse_yellow"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_DRAW_2_YELLOW(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_draw_2_yellow"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_0_BLUE(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_0_blue"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_1_BLUE(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_1_blue"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_2_BLUE(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_2_blue"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_3_BLUE(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_3_blue"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_4_BLUE(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_4_blue"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_5_BLUE(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_5_blue"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_6_BLUE(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_6_blue"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_7_BLUE(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_7_blue"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_8_BLUE(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_8_blue"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_9_BLUE(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_9_blue"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_SKIP_BLUE(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_skip_blue"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_REVERSE_BLUE(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_reverse_blue"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_DRAW_2_BLUE(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_draw_2_blue"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_0_GREEN(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_0_green"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_1_GREEN(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_1_green"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_2_GREEN(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_2_green"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_3_GREEN(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_3_green"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_4_GREEN(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_4_green"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_5_GREEN(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_5_green"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_6_GREEN(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_6_green"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_7_GREEN(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_7_green"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_8_GREEN(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_8_green"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_9_GREEN(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_9_green"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_SKIP_GREEN(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_skip_green"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_REVERSE_GREEN(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_reverse_green"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_DRAW_2_GREEN(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_draw_2_green"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_WILD(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_wild"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    ),

    CARD_WILD_DRAW_4(
            Registry.register(
                    Registries.ITEM,
                    new Identifier("sls_uno", "card_wild_draw_4"),
                    new Item(new FabricItemSettings())
            ),
            Type.CARD
    );

    private final Item item;
    private final Type type;

    Items(Item item, Type type) {
        this.item = item;
        this.type = type;
    };

    public Item getItem() {
        return item;
    }

    public Type getType() {
        return type;
    }
}
