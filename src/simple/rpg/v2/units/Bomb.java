package simple.rpg.v2.units;

import java.util.HashMap;
import simple.rpg.v2.Field;
import simple.rpg.v2.RandomGenerator;

public class Bomb extends Unit {

    public static final String REAL_SHAPE = "\uD83D\uDCA3";

    public Bomb() {
        super();
        HashMap<String, Integer> position = new HashMap<>(
            RandomGenerator.generateEmptyFieldPosition());
        this.x = position.get("X");
        this.y = position.get("Y");
        this.shape = Field.EMPTY_FIELD;
        this.realShape = REAL_SHAPE;
    }
}
