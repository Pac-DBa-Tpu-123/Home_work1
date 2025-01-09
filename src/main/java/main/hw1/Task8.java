package main.hw1;

public class Task8 {

    private static final int ARRAY_ELEMENT = -2;
    private static final int CYCLE_ELEMENT = 8;

    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        int[][] moves = {
            {2, 1}, {2, -1}, {ARRAY_ELEMENT, 1}, {ARRAY_ELEMENT, -1},
            {1, 2}, {1, ARRAY_ELEMENT}, {-1, 2}, {-1, ARRAY_ELEMENT}
        };

        for (int i = 0; i < CYCLE_ELEMENT; i++) {
            for (int j = 0; j < CYCLE_ELEMENT; j++) {
                if (board[i][j] == 1) {
                    for (int[] hod : moves) {
                        int x = i + hod[0];
                        int y = j + hod[1];
                        if (x >= 0 && x < CYCLE_ELEMENT && y >= 0 && y < CYCLE_ELEMENT && board[x][y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
