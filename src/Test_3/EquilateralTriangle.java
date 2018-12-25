package Test_3;

public class EquilateralTriangle extends Triangle {

    public EquilateralTriangle(double length){
        super(new Point(),length,length,length);
    }

    public EquilateralTriangle(){
        this(0);
    }

    public EquilateralTriangle(EquilateralTriangle e){
        this(e.a);
    }

    @Override
    public double area() {
        return super.area();
    }

    @Override
    public double perimeter() {
        return super.perimeter();
    }

    @Override
    public boolean contains(Point p) {
        return super.contains(p);
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void revolve() {
        super.revolve();
    }

    @Override
    public void zoom() {
        super.zoom();
    }
}
