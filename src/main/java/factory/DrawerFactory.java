package factory;

import baseDrawer.ShapeDrawer;
import exception.BusinessException;
import implDrawer.CmdLineDrawer;
import implDrawer.WebUIDrawer;
import implDrawer.WritingPenDrawer;

public class DrawerFactory {

    /**
     * Factory method, generate shapeDrawer by drawerType.
     * If need more support drawerType, you can extend this factory method.
     *
     */
    public static ShapeDrawer getDrawer(Integer drawerType) {
        return switch (drawerType) {
            case 0 -> new CmdLineDrawer();
            case 1 -> new WritingPenDrawer();
            case 2 -> new WebUIDrawer();
            default ->
                    throw new BusinessException(String.format("Unsupported parameter:[drawType=%s] , only support 0/1/2", drawerType));
        };

    }
}
