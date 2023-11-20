package utils;

import entity.Point;

import static commons.ConstantVariables.SHAPE_FILL_CHAR;

public class DrawUtil {
    public static void drawLine(char[][] canvas, Point start, Point end) {
        for (int x = start.getX(); x <= end.getX(); x++) {
            for (int y = start.getY(); y <= end.getY(); y++) {
                if (x == start.getX() || x == end.getX() || y == start.getY() || y == end.getY()) {
                    canvas[y][x] = SHAPE_FILL_CHAR;
                }
            }
        }
    }

    public static void drawRectangle(char[][] canvas, Point start, Point end) {
        for (int x = start.getX(); x <= end.getX(); x++) {
            for (int y = start.getY(); y <= end.getY(); y++) {
                if (x == start.getX() || x == end.getX() || y == start.getY() || y == end.getY()) {
                    canvas[y][x] = SHAPE_FILL_CHAR;
                }
            }
        }
    }
}
