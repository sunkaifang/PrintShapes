import baseDrawer.ShapeDrawer;
import entity.DrawingArgs;
import factory.DrawerFactory;

import java.util.Scanner;

import static commons.ConstantVariables.CMD_QUIT_SYS;

/**
 * Demo: cmd-lines-input implement drawing shapes
 */
public class Main {

    // Here, we just demo with hard-coding(drawerType=0), use Cmd lines input implement drawing shapes.
    // In real project, you can pass drawType dynamically, to get a dynamic shapeDrawer instance.
    private static final ShapeDrawer shapeDrawer = DrawerFactory.getDrawer(0);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.printf("Enter a command (type %s to quit): ", CMD_QUIT_SYS);
            String command = scanner.nextLine();

            if (command.equals(CMD_QUIT_SYS)) {
                System.out.println("Exiting the program.");
                break;
            }

            Object[] drawArgs = new Object[1];
            drawArgs[0] = command;

            shapeDrawer.drawTemplate(new DrawingArgs(drawArgs));

        }

        scanner.close();
    }
}
