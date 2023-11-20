import baseDrawer.ShapeDrawer;
import entity.DrawingArgs;
import entity.Shape;

import java.util.List;

public class ShapeDrawerTest {

    public static void main(String[] args) {
        testCreateCanvas();
        testCreateShape();
    }


    private static void testCreateCanvas() {
        System.out.println("Testing createCanvas...");

        ShapeDrawer shapeDrawer = new ShapeDrawer() {
            @Override
            public void processArgs(DrawingArgs args) {
                // Implement if needed
            }

            @Override
            public boolean checkingArgs(DrawingArgs args) {
                // Implement if needed
                return true;
            }
        };

        shapeDrawer.createCanvas(5, 5);
        List<Shape> shapes = shapeDrawer.shapes;

        System.out.println("Expected Canvas Size: 1");
        System.out.println("Actual Canvas Size: " + shapes.size());
    }

    private static void testCreateShape() {
        System.out.println("Testing createShape...");

        ShapeDrawer shapeDrawer = new ShapeDrawer() {
            @Override
            public void processArgs(DrawingArgs args) {
                // Implement if needed
            }

            @Override
            public boolean checkingArgs(DrawingArgs args) {
                return true;
            }
        };

        shapeDrawer.createShape("Line", 1, 1, 3, 1);
        List<Shape> shapes = shapeDrawer.shapes;

        System.out.println("Expected Shapes Size: 1");
        // need to exclude canvas itself, so need to minus 1
        System.out.println("Actual Shapes Size: " + (shapes.size() - 1));


        shapeDrawer.createShape("Line", 3, 3, 5, 6);
        System.out.println("Expected Shapes Size: 2");
        // need to exclude canvas itself, so need to minus 1
        System.out.println("Actual Shapes Size: " + (shapes.size() - 1));
    }
}
