package simple.rpg.v2.units;

import java.util.HashMap;
import simple.rpg.v2.RandomGenerator;

public class Monster extends Unit {

    public static final String REAL_SHAPE = "\uD83D\uDC7B";

    public Monster() {
        super();
        HashMap<String, Integer> position = new HashMap<>(
            RandomGenerator.generateEmptyFieldPosition());
        this.x = position.get("X");
        this.y = position.get("Y");
        this.shape = REAL_SHAPE;
        this.realShape = REAL_SHAPE;
    }
}
