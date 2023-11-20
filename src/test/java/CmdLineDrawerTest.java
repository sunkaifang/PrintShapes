import implDrawer.CmdLineDrawer;
import entity.DrawingArgs;
import exception.BusinessException;

public class CmdLineDrawerTest {

    public static void main(String[] args) {
        testCheckingArgs();
        testProcessArgs();
    }

    private static void testCheckingArgs() {
        System.out.println("Testing checkingArgs...");

        CmdLineDrawer cmdLineDrawer = new CmdLineDrawer();
        DrawingArgs validArgs = new DrawingArgs(new Object[]{"C 5 5"});
        DrawingArgs invalidArgs1 = new DrawingArgs(null);
        DrawingArgs invalidArgs2 = new DrawingArgs(new Object[0]);
        DrawingArgs invalidArgs3 = new DrawingArgs(new Object[]{""});

        try {
            cmdLineDrawer.checkingArgs(validArgs);
            System.out.println("Valid Args Test Passed!");
        } catch (BusinessException e) {
            System.out.println("Valid Args Test Failed!");
        }

        try {
            cmdLineDrawer.checkingArgs(invalidArgs1);
            System.out.println("Invalid Args Test Failed!");
        } catch (BusinessException e) {
            System.out.println("Invalid Args Test Passed!");
        }

        try {
            cmdLineDrawer.checkingArgs(invalidArgs2);
            System.out.println("Invalid Args Test Failed!");
        } catch (BusinessException e) {
            System.out.println("Invalid Args Test Passed!");
        }

        try {
            cmdLineDrawer.checkingArgs(invalidArgs3);
            System.out.println("Invalid Args Test Failed!");
        } catch (BusinessException e) {
            System.out.println("Invalid Args Test Passed!");
        }
    }

    private static void testProcessArgs() {
        System.out.println("Testing processArgs...");

        CmdLineDrawer cmdLineDrawer = new CmdLineDrawer();
        DrawingArgs validCanvasArgs = new DrawingArgs(new Object[]{"C 5 5"});

        try {
            cmdLineDrawer.processArgs(validCanvasArgs);
            System.out.println("Valid Canvas Args Test Passed!");
        } catch (BusinessException e) {
            System.out.println("Valid Canvas Args Test Failed!");
        }


    }
}
