package simple.rpg.v2.units;

import simple.rpg.v2.Field;

public class Player extends Unit implements Movable {

    public int prevX;
    public int prevY;

    public Player() {
        super();
        this.x = Field.CENTER;
        this.y = Field.CENTER;
        this.shape = "\uD83E\uDD77";
    }

    @Override
    public void moveUp() {
        if (this.x == Field.TOP_EDGE) {
            return;
        }
        this.prevX = this.x;
        this.prevY = this.y;
        this.x--;
    }

    @Override
    public void moveDown() {
        if (this.x == Field.BOTTOM_EDGE) {
            return;
        }
        this.prevX = this.x;
        this.prevY = this.y;
        this.x++;
    }

    @Override
    public void moveLeft() {
        if (this.y == Field.LEFT_EDGE) {
            return;
        }
        this.prevX = this.x;
        this.prevY = this.y;
        this.y--;
    }

    @Override
    public void moveRight() {
        if (this.y == Field.RIGHT_EDGE) {
            return;
        }
        this.prevX = this.x;
        this.prevY = this.y;
        this.y++;
    }
}
