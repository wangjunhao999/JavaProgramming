package Test_3;

public class Rectangle extends ClosedFigure {

    public double length;
    public double width;

    public Rectangle(Point p,double length,double width){
        super(p,"矩形");
        this.length = length;
        this.width = width;
    }

    public Rectangle(){
        this(new Point(),0,0);
    }

    public Rectangle(Rectangle r){
        this(r.point,r.length,r.width);
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }

    @Override
    public void draw() {

    }

    @Override
    public void zoom() {

    }

    @Override
    public void revolve() {

    }
}
