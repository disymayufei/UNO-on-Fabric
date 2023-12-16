package cn.disy920.sls_uno.card.enums;

public enum Color {
    RED(0),
    YELLOW(1),
    BLUE(2),
    GREEN(3),
    BLACK(-1);
    private final int index;

    Color(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
