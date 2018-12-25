package Test_3;

public class Ellipse extends ClosedFigure{

    public double radius_a;
    public double radius_b;

    public Ellipse(Point p,double radius_a,double radius_b){
        super(p,"椭圆");
        this.radius_a = radius_a;
        this.radius_b = radius_b;
    }

    public Ellipse(){
        this(new Point(),0,0);
    }

    public Ellipse(Ellipse e){
        this(new Point(e.point),e.radius_a,e.radius_b);
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }

    @Override
    public double area() {
        return Math.PI * radius_a * radius_b;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius_b + 4 * (radius_a - radius_b);
    }

    @Override
    public void draw() {

    }

    @Override
    public void revolve() {

    }

    @Override
    public void zoom() {

    }
}
