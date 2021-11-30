package simple.rpg.v2;

import java.util.Scanner;
import simple.rpg.v2.units.Bomb;
import simple.rpg.v2.units.Monster;
import simple.rpg.v2.units.Player;

public class SimpleRPG {

    private final Scanner joystick = new Scanner(System.in);
    private Player p;
    private Monster m;
    private Bomb b;
    private int score = 0;
    private boolean gameOver = false;

    public SimpleRPG() {
        Field.initBoard();
        initUnits();
    }

    private void initUnits() {
        p = new Player();
        b = new Bomb();
        m = new Monster();

        p.onField();
        b.onField();
        m.onField();
    }

    private String getUserInput() {
        System.out.print("input direction >>>> ");
        return joystick.nextLine();
    }

    private void movePlayer() {
        int prevX = p.x;
        int prevY = p.y;

        p.move(getUserInput());
        if (Field.isBomb(p.x, p.y)) {
            gameOver();
            return;
        }
        if (Field.isMonster(p.x, p.y)) {
            p.onField();
            Field.clean(prevX, prevY);
            score++;
            m = new Monster();
            m.onField();
        }
        p.onField();
        Field.clean(prevX, prevY);
    }

    public void run() {
        while (!gameOver) {
            Field.print();
            movePlayer();
        }
    }

    private void gameOver() {
        System.out.println("score >>>>> " + score);
        gameOver = true;
    }
}
