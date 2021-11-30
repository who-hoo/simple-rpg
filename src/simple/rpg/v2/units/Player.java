package simple.rpg.v2.units;

import simple.rpg.v2.Field;

public class Player extends Unit {

    public Player() {
        super(Field.CENTER, Field.CENTER);
        this.shape = "\uD83E\uDD77";
    }

    public void move(String direction) {
        switch (direction) {
            case "w":
                this.x--;
                break;
            case "a":
                this.y--;
                break;
            case "s":
                this.x++;
                break;
            case "d":
                this.y++;
                break;
        }
    }
}
