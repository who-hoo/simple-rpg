package simple.rpg.v2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import simple.rpg.v2.units.Bomb;
import simple.rpg.v2.units.Monster;
import simple.rpg.v2.units.Player;

public class SimpleRPG {

    private static final Random randomGenerator = new Random();
    private final String[][] board = new String[5][5];
    private final Scanner joystick = new Scanner(System.in);
    private Player p;
    private Monster m;
    private Bomb b;
    private int score = 0;
    private boolean gameOver = false;

    public SimpleRPG() {
        initBoard();
        createPlayer();
        createBomb();
        createMonster();
    }

    private void initBoard() {
        for (String[] row : board) {
            Arrays.fill(row, "⬜");
        }
    }

    private boolean isEmptySpace(int x, int y) {
        return board[x][y].equals("⬜");
    }

    private boolean isMonster(int x, int y) {
        return board[x][y].equals(m.REAL_SHAPE);
    }

    private boolean isBomb(int x, int y) {
        return board[x][y].equals(b.REAL_SHAPE);
    }

    private void createPlayer() {
        p = new Player();
        board[p.x][p.y] = p.shape;
    }

    private void createBomb() {
        int x = randomGenerator.nextInt(4);
        int y = randomGenerator.nextInt(4);

        if (isEmptySpace(x, y)) {
            b = new Bomb(x, y);
            board[b.x][b.y] = b.shape;
            return;
        }

        createBomb();
    }

    private void createMonster() {
        int x = randomGenerator.nextInt(4);
        int y = randomGenerator.nextInt(4);

        if (isEmptySpace(x, y)) {
            m = new Monster(x, y);
            board[m.x][m.y] = m.shape;
            return;
        }

        createMonster();
    }

    private void print() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

    private String getUserInput() {
        System.out.print("input direction >>>> ");
        return joystick.nextLine();
    }

    private void movePlayer() {
        int prevX = p.x;
        int prevY = p.y;

        p.move(getUserInput());
        if (isBomb(p.x, p.y)) {
            gameOver();
            return;
        }
        if (isMonster(p.x, p.y)) {
            board[p.x][p.y] = p.shape;
            board[prevX][prevY] = "⬜";
            score++;
            createMonster();
        }
        board[p.x][p.y] = p.shape;
        board[prevX][prevY] = "⬜";
    }

    public void run(SimpleRPG game) {
        while (!gameOver) {
            game.print();
            movePlayer();
        }
    }

    private void gameOver() {
        System.out.println("score >>>>> " + score);
        gameOver = true;
    }
}
