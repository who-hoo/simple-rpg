package simple.rpg.v2;

public class Monster extends Unit {

    public final String REAL_SHAPE = "\uD83D\uDC7B";

    public Monster(int x, int y) {
        super(x, y);
        this.shape = "⬜";
    }
}
