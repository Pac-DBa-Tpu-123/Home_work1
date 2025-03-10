package main.project2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MazeTest {

    private Maze maze;

    @BeforeEach
    public void setUp() {
        maze = new Maze();
    }

    @Test
    public void testMazeCreation() {
        maze.makeMaze();
        assertNotNull(maze.maze);
        assertEquals(Maze.ROWS, maze.maze.length);
        assertEquals(Maze.COLUMNS, maze.maze[0].length);
        assertTrue(maze.mazeExists);
    }

    @Test
    public void testTearDown() {
        maze.makeMaze();
        int initialWallCount = countWalls(maze.maze);

        int row = 1;
        int col = 1;
        while (maze.maze[row][col] != Maze.WALL_CODE) {
            row = (int) (Math.random() * (Maze.ROWS - 2)) + 1;
            col = (int) (Math.random() * (Maze.COLUMNS - 2)) + 1;
        }

        assertEquals(Maze.WALL_CODE, maze.maze[row][col], "Выбранная ячейка должна быть стеной");

        maze.tearDown(row, col);

        int finalWallCount = countWalls(maze.maze);

        assertTrue(finalWallCount < initialWallCount, "Количество стен должно уменьшиться после разрушения стены");

        assertNotEquals(Maze.WALL_CODE, maze.maze[row][col], "Выбранная стена должна быть разрушена");
    }

    @Test
    public void testSolveMaze() {
        maze.makeMaze();
        boolean solved = maze.solveMaze(1, 1);
        assertTrue(solved);
        assertEquals(Maze.PATH_CODE, maze.maze[Maze.ROWS - 2][Maze.COLUMNS - 2]);
    }

    @Test
    public void testRedrawMaze() {
        maze.makeMaze();
        BufferedImage image = new BufferedImage(Maze.WIDTH_PICTURE, Maze.HEIGHT_PICTURE, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        maze.paintComponent(g);

        boolean hasNonZeroColor = false;
        for (int x = 0; x < Maze.WIDTH_PICTURE; x++) {
            for (int y = 0; y < Maze.HEIGHT_PICTURE; y++) {
                int color = image.getRGB(x, y);
                if (color != 0) {
                    hasNonZeroColor = true;
                    break;
                }
            }
            if (hasNonZeroColor) {
                break;
            }
        }
        assertTrue(hasNonZeroColor, "Изображение не должно быть пустым");
    }

    private int countWalls(int[][] maze) {
        int wallCount = 0;
        for (int i = 0; i < Maze.ROWS; i++) {
            for (int j = 0; j < Maze.COLUMNS; j++) {
                if (maze[i][j] == Maze.WALL_CODE) {
                    wallCount++;
                }
            }
        }
        return wallCount;
    }
}
