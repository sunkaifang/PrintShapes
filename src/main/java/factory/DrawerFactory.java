package factory;

import baseDrawer.ShapeDrawer;
import exception.BusinessException;
import implDrawer.CmdLineDrawer;
import implDrawer.WritingPenDrawer;
import implDrawer.WebUIDrawer;

public class DrawerFactory {

    /**
     * Factory method, generate shapeDrawer by drawerType.
     * If need more support drawerType, you can extend this factory method.
     * @param drawerType
     * @return
     */
    public static ShapeDrawer getDrawer(Integer drawerType) {
        switch (drawerType) {
            case 0:
                return new CmdLineDrawer();
            case 1:
                return new WritingPenDrawer();
            case 2:
                return new WebUIDrawer();
            default:
                throw new BusinessException(String.format("Unsupported parameter:[drawType=%s] , only support 0/1/2", drawerType));
        }

    }
}
