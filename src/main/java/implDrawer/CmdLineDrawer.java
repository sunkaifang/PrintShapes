package implDrawer;

import baseDrawer.ShapeDrawer;
import entity.DrawingArgs;
import exception.BusinessException;

import static commons.ConstantVariables.*;

/**
 * Draw shapes with command lines input
 */
public class CmdLineDrawer implements ShapeDrawer {

    /**
     * Validation args
     * Has supported rule:
     * 1. When create canvas use C cmd, parameter count should at least 3
     * 2. When crate Line/Rectangle use L/R, parameter count should at least 5
     * 3. Only support vertical/horizontal lines, so x1==x2, or y1==y2 need ensure
     * <p>
     * Maybe need to support rule: todo
     * 1.(x1,x2),(y1,y2), should smaller than canvas width/height or not? I think should not.
     * As we know, many painting application can extend canvas size automatically. I think we should not limit canvas size as fixed.
     */
    @Override
    public boolean checkingArgs(DrawingArgs args) {
        if (null == args) {
            System.out.println("args is null");
            return false;
        }

        if (null == args.getData()) {
            System.out.println("args.data is null");
            return false;
        }

        if (0 == args.getData().length) {
            System.out.println("args.data is empty array");
            return false;
        }

        if (null == args.getData()[0]) {
            System.out.println("args.data[0] is null");
            return false;
        }

        String commandStr = args.getData()[0].toString().trim();

        if (commandStr.isEmpty()) {
            System.out.println("args.data[0] is empty or blank");
            return false;
        }

        String[] commands = commandStr.split(CMD_SPLIT_CHAR);
        String cmdType = commands[0];

        switch (cmdType) {
            case CREATE_CANVAS:
                if (CREATE_CANVAS_PARAMETER_COUNT_LIMIT > commands.length) {
                    System.out.printf("CREATE_CANVAS should have %d parameters at least!%n", CREATE_CANVAS_PARAMETER_COUNT_LIMIT);
                    return false;
                }
                break;
            case CREATE_LINE:
                if (CREATE_SHAPES_PARAMETER_COUNT_LIMIT > commands.length) {
                    System.out.printf("CREATE_LINE/CREATE_RECTANGLE should have %d parameters at least!%n", CREATE_SHAPES_PARAMETER_COUNT_LIMIT);
                    return false;
                }
                // only support horizontal or vertical line
                if (!commands[1].equals(commands[3]) && !commands[2].equals(commands[4])) {
                    System.out.println("only support horizontal or vertical line");
                    return false;
                }
            case CREATE_RECTANGLE:
                if (CREATE_SHAPES_PARAMETER_COUNT_LIMIT > commands.length) {
                    System.out.printf("CREATE_LINE/CREATE_RECTANGLE should have %d parameters at least!%n", CREATE_SHAPES_PARAMETER_COUNT_LIMIT);
                    return false;
                }
                break;
        }

        return true;

    }

    @Override
    public void processArgs(DrawingArgs args) {
        String command = args.getData()[0].toString();
        String[] commands = command.trim().split(CMD_SPLIT_CHAR);

        try {
            String cmdType = commands[0];

            switch (cmdType) {
                case CREATE_CANVAS -> createCanvas(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                case CREATE_LINE, CREATE_RECTANGLE ->
                        createShape(cmdType, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]),
                                Integer.parseInt(commands[3]), Integer.parseInt(commands[4]));
                default -> System.out.println("Invalid command. Please enter a valid command.");
            }
        } catch (Exception e) {
            throw new BusinessException("CmdLineDraw.processArgs exception", e);
        }
    }


}
