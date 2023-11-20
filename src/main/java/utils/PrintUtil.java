package utils;

public class PrintUtil {
    public static void printCanvas(char[][] canvas) {
        for (char[] row : canvas) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
