package simple.rpg.v2;

import java.util.Random;
import java.util.Scanner;
import simple.rpg.v2.units.Bomb;
import simple.rpg.v2.units.Monster;
import simple.rpg.v2.units.Player;

public class SimpleRPG {

    private static final Random randomGenerator = new Random();
    private final Scanner joystick = new Scanner(System.in);
    private Player p;
    private Monster m;
    private Bomb b;
    private int score = 0;
    private boolean gameOver = false;

    public SimpleRPG() {
        Field.initBoard();
        createPlayer();
        createBomb();
        createMonster();
    }

    private void createPlayer() {
        p = new Player();
        p.onField();
    }

    private void createBomb() {
        int x = randomGenerator.nextInt(Field.size());
        int y = randomGenerator.nextInt(Field.size());

        if (Field.isEmptySpace(x, y)) {
            b = new Bomb(x, y);
            b.onField();
            return;
        }

        createBomb();
    }

    private void createMonster() {
        int x = randomGenerator.nextInt(Field.size());
        int y = randomGenerator.nextInt(Field.size());

        if (Field.isEmptySpace(x, y)) {
            m = new Monster(x, y);
            m.onField();
            return;
        }

        createMonster();
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
            createMonster();
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
