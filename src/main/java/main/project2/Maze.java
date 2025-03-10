package main.project2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Maze extends JPanel implements Runnable {

    final static int WIDTH_PICTURE = 120;
    final static int HEIGHT_PICTURE = 80;


    int[][] maze;

    final static int BACK_GROUND_CODE = 0;
    final static int WALL_CODE = 1;
    final static int PATH_CODE = 2;
    final static int EMPTY_CODE = 3;
    final static int VISITED_CODE = 4;

    Color[] color;
    final static int ROWS = 41;
    final static int COLUMNS = 51;
    int border = 0;
    final static int SLEEP_TIME = 5000;
    final static int SPEED_SLEEP = 30;
    final static int BLOCK_SIZE = 12;

    int width = -1;
    int height = -1;

    int totalWidth;
    int totalHeight;
    int left;
    int top;
    boolean mazeExists = false;

    final static int PIGMENT_COLOR_1 = 200;
    final static int PIGMENT_COLOR_2 = 128;
    final static int PIGMENT_COLOR_3 = 255;

    public Maze() {
        color = new Color[] {
            new Color(PIGMENT_COLOR_1, 0, 0),
            new Color(PIGMENT_COLOR_1, 0, 0),
            new Color(PIGMENT_COLOR_2, PIGMENT_COLOR_2, PIGMENT_COLOR_3),
            Color.WHITE,
            new Color(PIGMENT_COLOR_1, PIGMENT_COLOR_1, PIGMENT_COLOR_1)
        };
        setBackground(color[BACK_GROUND_CODE]);
        setPreferredSize(new Dimension(BLOCK_SIZE * COLUMNS, BLOCK_SIZE * ROWS));
        new Thread(this).start();
    }

    void checkSize() {
        if (getWidth() != width || getHeight() != height) {
            width = getWidth();
            height = getHeight();
            int w = (width - 2 * border) / COLUMNS;
            int h = (height - 2 * border) / ROWS;
            left = (width - w * COLUMNS) / 2;
            top = (height - h * ROWS) / 2;
            totalWidth = w * COLUMNS;
            totalHeight = h * ROWS;
        }
    }

    synchronized protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        checkSize();
        redrawMaze(g);
    }

    void redrawMaze(Graphics g) {
        if (mazeExists) {
            int w = totalWidth / COLUMNS;
            int h = totalHeight / ROWS;
            for (int j = 0; j < COLUMNS; j++) {
                for (int i = 0; i < ROWS; i++) {
                    if (maze[i][j] < 0) {
                        g.setColor(color[EMPTY_CODE]);
                    } else {
                        g.setColor(color[maze[i][j]]);
                    }
                    g.fillRect((j * w) + left, (i * h) + top, w, h);
                }
            }
        }
    }

    final static int TIME_TO_SLEEP = 1000;

    public void run() {
        try {
            Thread.sleep(TIME_TO_SLEEP);
        } catch (InterruptedException e) {
        }
        while (true) {
            makeMaze();
            solveMaze(1, 1);
            synchronized (this) {
                try {
                    wait(SLEEP_TIME);
                } catch (InterruptedException e) {
                }
            }
            mazeExists = false;
            repaint();
        }
    }

    void makeMaze() {
        if (maze == null) {
            maze = new int[ROWS][COLUMNS];
        }
        int i;
        int j;
        int emptyCt = 0;
        int wallCt = 0;
        int[] wallrow = new int[(ROWS * COLUMNS) / 2];
        int[] wallcol = new int[(ROWS * COLUMNS) / 2];
        for (i = 0; i < ROWS; i++) {
            for (j = 0; j < COLUMNS; j++) {
                maze[i][j] = WALL_CODE;
            }
        }
        for (i = 1; i < ROWS - 1; i += 2) {
            for (j = 1; j < COLUMNS - 1; j += 2) {
                emptyCt++;
                maze[i][j] = -emptyCt;
                if (i < ROWS - 2) {
                    wallrow[wallCt] = i + 1;
                    wallcol[wallCt] = j;
                    wallCt++;
                }
                if (j < COLUMNS - 2) {
                    wallrow[wallCt] = i;
                    wallcol[wallCt] = j + 1;
                    wallCt++;
                }
            }
        }
        mazeExists = true;
        repaint();
        int r;
        for (i = wallCt - 1; i > 0; i--) {
            r = (int) (Math.random() * i);
            tearDown(wallrow[r], wallcol[r]);
            wallrow[r] = wallrow[i];
            wallcol[r] = wallcol[i];
        }
        for (i = 1; i < ROWS - 1; i++) {
            for (j = 1; j < COLUMNS - 1; j++) {
                if (maze[i][j] < 0) {
                    maze[i][j] = EMPTY_CODE;
                }
            }
        }
    }

    synchronized void tearDown(int row, int col) {
        if (row % 2 == 1 && maze[row][col - 1] != maze[row][col + 1]) {
            fill(row, col - 1, maze[row][col - 1], maze[row][col + 1]);
            maze[row][col] = maze[row][col + 1];
            repaint();
            try {
                wait(SPEED_SLEEP);
            } catch (InterruptedException e) {
            }
        } else if (row % 2 == 0 && maze[row - 1][col] != maze[row + 1][col]) {
            fill(row - 1, col, maze[row - 1][col], maze[row + 1][col]);
            maze[row][col] = maze[row + 1][col];
            repaint();
            try {
                wait(SPEED_SLEEP);
            } catch (InterruptedException e) {
            }
        }
    }

    void fill(int row, int col, int replace, int replaceWith) {
        if (maze[row][col] == replace) {
            maze[row][col] = replaceWith;
            fill(row + 1, col, replace, replaceWith);
            fill(row - 1, col, replace, replaceWith);
            fill(row, col + 1, replace, replaceWith);
            fill(row, col - 1, replace, replaceWith);
        }
    }



    boolean solveMaze(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLUMNS) {
            return false;
        }
        if (maze[row][col] == EMPTY_CODE) {
            maze[row][col] = PATH_CODE;
            repaint();
            if (row == ROWS - 2 && col == COLUMNS - 2) {
                return true;
            }
            try {
                Thread.sleep(SPEED_SLEEP);
            } catch (InterruptedException e) {
            }
            if (solveMaze(row - 1, col)
                || solveMaze(row, col - 1)
                || solveMaze(row + 1, col)
                || solveMaze(row, col + 1)) {
                return true;
            }
            maze[row][col] = VISITED_CODE;
            repaint();
            synchronized (this) {
                try {
                    wait(SPEED_SLEEP);
                } catch (InterruptedException e) {
                }
            }
        }
        return false;
    }
}

