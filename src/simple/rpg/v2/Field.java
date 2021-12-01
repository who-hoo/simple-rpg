package simple.rpg.v2;

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
    public static final String EMPTY_FIELD = "⬜";

    private static final Unit[][] board = new Unit[SIZE][SIZE];

    private Field() {
    }

    public static boolean isEmptySpace(int row, int col) {
        return board[row][col] == null;
    }

    public static boolean isMonster(int row, int col) {
        return Monster.REAL_SHAPE.equals(board[row][col].shape);
    }

    public static boolean isBomb(int row, int col) {
        return Bomb.REAL_SHAPE.equals(board[row][col].shape);
    }

    public static void put(Unit unit) {
        board[unit.x][unit.y] = unit;
    }

    public static void clean(int row, int col) {
        board[row][col] = null;
    }

    public static void print() {
        for (Unit[] row : board) {
            for (Unit col : row) {
                try {
                    System.out.print(col.shape);
                } catch (NullPointerException e) {
                    System.out.print(EMPTY_FIELD);
                }
            }
            System.out.println();
        }
    }

    public static void printGameOver() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                try {
                    System.out.print(isBomb(row, col) ? "\uD83D\uDCA3" : "\uD83D\uDCA5");
                } catch (NullPointerException e) {
                    System.out.print("\uD83D\uDCA5");
                }
            }
            System.out.println();
        }
    }
}
