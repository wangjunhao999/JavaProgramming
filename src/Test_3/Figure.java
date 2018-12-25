package Test_3;

public abstract class Figure {

    public Point point;

    protected Figure(Point point){
        this.point = point;
    }

    protected Figure(){
        this(new Point());
    }

    protected Figure(Figure p){
        this(p.point);
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public abstract void revolve();//旋转

    public abstract void zoom();//缩放

    public abstract void draw();//绘图
}
