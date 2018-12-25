package Test_3;

public class Square extends Rectangle {

    public Square(Point p,double length){
        super(p,length,length);
        this.setShape("正方形");
    }

    public Square(){
        this(new Point(),0);
    }

    public Square(Square s){
        this(s.point,s.length);
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
    public void zoom() {
        super.zoom();
    }

    @Override
    public void revolve() {
        super.revolve();
    }
}
