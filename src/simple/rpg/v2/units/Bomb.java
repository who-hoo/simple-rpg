package simple.rpg.v2.units;

public class Bomb extends Unit {

    public final String REAL_SHAPE = "\uD83D\uDCA3";

    public Bomb(int x, int y) {
        super(x, y);
        this.shape = "⬜";
    }
}
