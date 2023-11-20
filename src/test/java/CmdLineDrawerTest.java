import entity.DrawingArgs;
import exception.BusinessException;
import implDrawer.CmdLineDrawer;

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


        boolean actualResult = cmdLineDrawer.checkingArgs(validArgs);
        if (actualResult) {
            System.out.println("Valid Args Test Passed!");

        } else {
            System.out.println("Valid Args Test Failed!");
        }

        boolean actualResult1 = cmdLineDrawer.checkingArgs(invalidArgs1);
        if (!actualResult1) {
            System.out.println("Invalid Args Test1 Passed!");
        } else {
            System.out.println("Invalid Args Test1 Failed!");
        }

        boolean actualResult2 = cmdLineDrawer.checkingArgs(invalidArgs2);
        if (!actualResult2) {
            System.out.println("Invalid Args Test2 Passed!");

        } else {
            System.out.println("Invalid Args Test2 Failed!");

        }

        boolean actualResult3 = cmdLineDrawer.checkingArgs(invalidArgs3);
        if (!actualResult3) {
            System.out.println("Invalid Args Test3 Passed!");

        } else {
            System.out.println("Invalid Args Test3 Failed!");

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

        DrawingArgs inValidCanvasArgs = new DrawingArgs(new Object[]{"C 5"});
        try {
            cmdLineDrawer.processArgs(inValidCanvasArgs);
            System.out.println("Inalid Canvas Args Test Failed!");
        } catch (BusinessException e) {
            System.out.println("Invalid Canvas Args Test Passed!");
        }

        DrawingArgs inValidCanvasArgs2 = new DrawingArgs(new Object[]{"L 5 3"});
        try {
            cmdLineDrawer.processArgs(inValidCanvasArgs2);
            System.out.println("Inalid Canvas Args Test2 Failed!");
        } catch (BusinessException e) {
            System.out.println("Invalid Canvas Args Test Passed!");
        }

    }
}
