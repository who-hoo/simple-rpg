package simple.rpg.v2.units;

import simple.rpg.v2.Field;

public class Unit {

    public int x;
    public int y;
    public String shape;
    public String realShape;

    public void onField() {
        Field.put(this);
    }
}
