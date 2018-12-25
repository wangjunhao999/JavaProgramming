package Test_3;

public class Circle extends Ellipse {

    public Circle(Point p,double radius_a){
        super(p,radius_a,radius_a);
        this.setShape("圆");
    }

    public Circle(){
        this(new Point(),0);
    }

    @Override
    public boolean contains(Point p) {
        return super.contains(p);
    }

    @Override
    public double area() {
        return super.area();
    }

    @Override
    public double perimeter() {
        return super.perimeter();
    }
}
