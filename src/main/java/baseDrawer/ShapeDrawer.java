package baseDrawer;

import entity.DrawingArgs;
import entity.Point;
import entity.Shape;
import utils.DrawUtil;
import utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

import static commons.ConstantVariables.*;

public interface ShapeDrawer {
    List<Shape> shapes = new ArrayList<>();

    /**
     * subClass need to implement
     */
    void processArgs(DrawingArgs args);

    boolean checkingArgs(DrawingArgs args);

    /**
     * Template method to draw shapes
     */
    default void drawTemplate(DrawingArgs args) {
        //Step 1: checking args in subClass
        boolean checkResult = checkingArgs(args);
        if (checkResult) {
            //Step 2: process args in subClass
            processArgs(args);
            //Step 3: draw shapes in superClass, shapes are stored in memory array
            char[][] canvas = drawShapesInMemory();
            //Step 4: print memory shapes to UI
            PrintUtil.printCanvas(canvas);
        } else {
            System.out.println("Arguments checking failed, will do nothing");
        }

    }

    default char[][] drawShapesInMemory() {
        char[][] canvas = createEmptyCanvas();
        for (Shape shape : shapes) {
            if (CREATE_LINE.equals(shape.getType())) {
                DrawUtil.drawLine(canvas, shape.getStart(), shape.getEnd());
            } else if (CREATE_RECTANGLE.equals(shape.getType())) {
                DrawUtil.drawRectangle(canvas, shape.getStart(), shape.getEnd());
            }
        }

        return canvas;
    }

    private char[][] createEmptyCanvas() {
        int maxWidth = 0, maxHeight = 0;
        for (Shape shape : shapes) {
            maxWidth = Math.max(maxWidth, shape.getEnd().getX());
            maxHeight = Math.max(maxHeight, shape.getEnd().getY());
        }

        char[][] canvas = new char[maxHeight + 1][maxWidth + 1];

        // Fill canvas borders with '_' and '|'
        for (int i = 0; i <= maxHeight; i++) {
            for (int j = 0; j <= maxWidth; j++) {
                if (i == 0 || i == maxHeight) {
                    canvas[i][j] = '_';
                } else if (j == 0 || j == maxWidth) {
                    canvas[i][j] = '|';
                }
            }
        }

        return canvas;
    }


    default void createCanvas(int width, int height) {
        shapes.clear(); // Clear existing shapes when creating a new canvas
        shapes.add(new Shape(CREATE_CANVAS, new Point(0, 0), new Point(width + 1, height + 1)));
    }

    default void createShape(String cmdType, int x1, int y1, int x2, int y2) {
        shapes.add(new Shape(cmdType, new Point(x1, y1), new Point(x2, y2)));
    }

}
