package simple.rpg.v2.units;

import simple.rpg.v2.Field;

public class Unit {

    public int x;
    public int y;
    public String shape = "⬜";

    public Unit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void onField() {
        Field.put(this);
    }
}
