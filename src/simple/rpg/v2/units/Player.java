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
        this.prevX = this.x;
        this.prevY = this.y;
        this.x--;
    }

    @Override
    public void moveDown() {
        this.prevX = this.x;
        this.prevY = this.y;
        this.x++;
    }

    @Override
    public void moveLeft() {
        this.prevX = this.x;
        this.prevY = this.y;
        this.y--;
    }

    @Override
    public void moveRight() {
        this.prevX = this.x;
        this.prevY = this.y;
        this.y++;
    }
}
