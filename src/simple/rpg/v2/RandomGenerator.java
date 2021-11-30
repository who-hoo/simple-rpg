package simple.rpg.v2;

import java.util.*;

public class RandomGenerator {

    private static final Random random = new Random();

    private RandomGenerator() {
    }

    public static Map<String, Integer> generateEmptyFieldPosition() {
        Map<String, Integer> emptyFieldPosition = new HashMap<>();

        boolean isEmpty = false;
        int x = 0;
        int y = 0;

        while (!isEmpty) {
            x = random.nextInt(Field.SIZE);
            y = random.nextInt(Field.SIZE);
            isEmpty = Field.isEmptySpace(x, y);
        }

        emptyFieldPosition.put("X", x);
        emptyFieldPosition.put("Y", y);

        return emptyFieldPosition;
    }
}
