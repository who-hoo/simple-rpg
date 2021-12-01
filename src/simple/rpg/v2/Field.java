package simple.rpg.v2;

import java.util.Arrays;
import simple.rpg.v2.units.Bomb;
import simple.rpg.v2.units.Monster;
import simple.rpg.v2.units.Unit;

public class Field {

    public static final int SIZE = 5;
    public static final int CENTER = SIZE / 2;
    public static final int TOP_EDGE = 0;
    public static final int LEFT_EDGE = 0;
    public static final int BOTTOM_EDGE = SIZE - 1;
    public static final int RIGHT_EDGE = SIZE - 1;
    private static final String[][] board = new String[SIZE][SIZE];

    private Field() {
    }

    public static void initBoard() {
        for (String[] row : board) {
            Arrays.fill(row, "⬜");
        }
    }

    public static boolean isEmptySpace(int row, int col) {
        return board[row][col].equals("⬜");
    }

    public static boolean isMonster(int row, int col) {
        return board[row][col].equals(Monster.REAL_SHAPE);
    }

    public static boolean isBomb(int row, int col) {
        return board[row][col].equals(Bomb.REAL_SHAPE);
    }

    public static void put(Unit unit) {
        board[unit.x][unit.y] = unit.shape;
    }

    public static void clean(int row, int col) {
        board[row][col] = "⬜";
    }

    public static void print() {
        for (String[] row : board) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static void printGameOver() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(isBomb(row, col) ? "\uD83D\uDCA3" : "\uD83D\uDCA5");
            }
            System.out.println();
        }
    }
}
