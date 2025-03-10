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

        int row = 1, col = 1;
        while (maze.maze[row][col] != Maze.WALL_CODE) {
            row = (int) (Math.random() * (Maze.ROWS - 2)) + 1;
            col = (int) (Math.random() * (Maze.COLUMNS - 2)) + 1;
        }

        maze.tearDown(row, col);

        int finalWallCount = countWalls(maze.maze);
        assertFalse(finalWallCount < initialWallCount);
    }

    @Test
    public void testSolveMaze() {
        maze.makeMaze();
        assertFalse(maze.solveMaze(1, 1));
        assertEquals(3, maze.maze[Maze.ROWS - 2][Maze.COLUMNS - 2]);
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
                if (image.getRGB(x, y) != 0) {
                    hasNonZeroColor = true;
                    break;
                }
            }
            if (hasNonZeroColor) {
                break;
            }
        }
        assertFalse(hasNonZeroColor);
    }

    private int countWalls(int[][] maze) {
        int wallCount = 0;
        for (int[] row : maze) {
            for (int cell : row) {
                if (cell == Maze.WALL_CODE) {
                    wallCount++;
                }
            }
        }
        return wallCount;
    }
}
