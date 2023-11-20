import baseDrawer.ShapeDrawer;
import exception.BusinessException;
import factory.DrawerFactory;
import implDrawer.CmdLineDrawer;
import implDrawer.WebUIDrawer;
import implDrawer.WritingPenDrawer;


public class DrawerFactoryTest {

    public static void main(String[] args) {
        testGetDrawer();
    }

    private static void testGetDrawer() {
        System.out.println("Testing getDrawer...");

        try {
            ShapeDrawer cmdLineDrawer = DrawerFactory.getDrawer(0);
            if (cmdLineDrawer instanceof CmdLineDrawer) {
                System.out.println("CmdLineDrawer Test Passed!");
            } else {
                System.out.println("CmdLineDrawer Test Failed!");
            }
        } catch (BusinessException e) {
            System.out.println("CmdLineDrawer Test Failed!");
        }

        try {
            ShapeDrawer writingPenDrawer = DrawerFactory.getDrawer(1);
            if (writingPenDrawer instanceof WritingPenDrawer) {
                System.out.println("WritingPenDrawer Test Passed!");
            } else {
                System.out.println("WritingPenDrawer Test Failed!");
            }
        } catch (BusinessException e) {
            System.out.println("WritingPenDrawer Test Failed!");
        }

        try {
            ShapeDrawer webUIDrawer = DrawerFactory.getDrawer(2);
            if (webUIDrawer instanceof WebUIDrawer) {
                System.out.println("WebUIDrawer Test Passed!");
            } else {
                System.out.println("WebUIDrawer Test Failed!");
            }
        } catch (BusinessException e) {
            System.out.println("WebUIDrawer Test Failed!");
        }

        try {
            DrawerFactory.getDrawer(3);
            System.out.println("Unsupported Drawer Test Failed!");
        } catch (BusinessException e) {
            System.out.println("Unsupported Drawer Test Passed!");
        }
    }
}
