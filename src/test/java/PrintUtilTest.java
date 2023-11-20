
import utils.PrintUtil;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class PrintUtilTest {
    public static void main(String[] args) {
        testPrintCanvas();
    }

    public static void testPrintCanvas() {
        // Arrange
        char[][] canvas = {
                {'X', 'X', 'X'},
                {'X', 'O', 'X'},
                {'X', 'X', 'X'}
        };

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Act
        PrintUtil.printCanvas(canvas);

        // Assert
        String expectedOutput = "XXX\r\nXOX\r\nXXX\r\n";
        String actualOutput = outContent.toString();
        System.setOut(originalOut);
        if (expectedOutput.equals(actualOutput)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
            System.out.printf("Expected Output:%s%n", expectedOutput);
            System.out.println();
            System.out.printf("Actual Output:%s%n", actualOutput);
        }

    }
}
