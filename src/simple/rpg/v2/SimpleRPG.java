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
        initUnits();
    }

    private void initUnits() {
        p = new Player();
        Field.put(p);
        b = new Bomb();
        Field.put(b);
        m = new Monster();
        Field.put(m);
    }

    private void getUserInput() {
        System.out.print("input direction[w(상), s(하), a(좌), d(우), q(종료)] >>>> ");
        String input = joystick.nextLine();
        switch (input.toLowerCase()) {
            case "w":
                p.moveUp();
                break;
            case "a":
                p.moveLeft();
                break;
            case "s":
                p.moveDown();
                break;
            case "d":
                p.moveRight();
                break;
            case "q":
                System.exit(0);
                break;
            default:
                getUserInput();
        }
    }

    private void refresh() {
        if (Field.isEmptySpace(p.x, p.y)) {
            Field.put(p);
            Field.clean(p.prevX, p.prevY);
        }
        if (Field.isBomb(p.x, p.y)) {
            gameOver();
            return;
        }
        if (Field.isMonster(p.x, p.y)) {
            Field.put(p);
            Field.clean(p.prevX, p.prevY);
            score++;
            m = new Monster();
            Field.put(m);
        }
    }

    public void run() {
        while (!gameOver) {
            Field.print();
            getUserInput();
            refresh();
        }
    }

    private void gameOver() {
        Field.printGameOver();
        System.out.println("Boom! Game Over");
        System.out.println("your score >>>>> " + score);
        gameOver = true;
    }
}
