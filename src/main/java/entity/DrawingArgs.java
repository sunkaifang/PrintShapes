package entity;

/**
 * Arguments to draw
 */
public class DrawingArgs {

    private Object[] data;

    public DrawingArgs(Object[] data){
        this.data=data;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }
}
