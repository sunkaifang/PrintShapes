import entity.*;
import utils.*;

public class DrawUtilTest {
    private static final char SHAPE_FILL_CHAR = 'X';

    public static void main(String[] args) {
        testDrawLine();
        testDrawRectangle();
    }

    public static void testDrawLine() {
        // Arrange
        char[][] canvas = createEmptyCanvas(5, 5);
        Point start = new Point(1, 1);
        Point end = new Point(3, 1);

        // Act
        DrawUtil.drawLine(canvas, start, end);

        // Assert
        char[][] expectedCanvas = {
                {'\0', '\0', '\0', '\0', '\0'},
                {'\0', 'X', 'X', 'X', '\0'},
                {'\0', '\0', '\0', '\0', '\0'},
                {'\0', '\0', '\0', '\0', '\0'},
                {'\0', '\0', '\0', '\0', '\0'}

        };

        assertCanvasEquals(expectedCanvas, canvas);
    }

    public static void testDrawRectangle() {
        // Arrange
        char[][] canvas = createEmptyCanvas(5, 5);
        Point start = new Point(1, 1);
        Point end = new Point(3, 3);

        // Act
        DrawUtil.drawRectangle(canvas, start, end);

        // Assert
        char[][] expectedCanvas = {
                {'\0', '\0', '\0', '\0', '\0'},
                {'\0', 'X', 'X', 'X', '\0'},
                {'\0', 'X', '\0', 'X', '\0'},
                {'\0', 'X', 'X', 'X', '\0'},
                {'\0', '\0', '\0', '\0', '\0'}
        };

        assertCanvasEquals(expectedCanvas, canvas);
    }

    private static char[][] createEmptyCanvas(int width, int height) {
        return new char[height][width];
    }

    private static void assertCanvasEquals(char[][] expected, char[][] actual) {
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                if (expected[i][j] != actual[i][j]) {
                    System.out.println("Test Failed!");
                    System.out.println("Expected Canvas:");
                    printCanvas(expected);
                    System.out.println("Actual Canvas:");
                    printCanvas(actual);
                    return;
                }
            }
        }
        System.out.println("Test Passed!");
    }

    private static void printCanvas(char[][] canvas) {
        for (char[] row : canvas) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
