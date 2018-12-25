package Test_4_5;

public class Line extends Figure {

    public Point point2;

    public Line(Point a, Point b){
        super(a);
        this.point2 = b;
    }

    public Line(){
        this(new Point(),new Point());
    }

    public Line(Line l){
        this(l.point,l.point2);
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    @Override
    public String toString() {
        return "Line(" + point + "," + point2 + ")";
    }

    public static void main(String args[]){
        System.out.println(new Line());
    }

    public double length(){
        double length2 = (point.getX() - point2.getX()) * (point.getX() - point2.getX()) + (point.getY() - point2.getY()) * (point.getY() - point2.getY());
        return Math.sqrt(length2);
    }

    public static double length(Point point1, Point point2){
        double length2 = (point1.getX() - point2.getX()) * (point1.getX() - point2.getX()) + (point1.getY() - point2.getY()) * (point1.getY() - point2.getY());
        return Math.sqrt(length2);
    }

    public boolean contains(Point p){
        double k1 = p.getY() - point.getY() / p.getX() - point.getX();
        double k2 = point2.getY() - p.getY() / point2.getX() - p.getX();
        return Math.abs(k1) == Math.abs(k2);
    }

    public Boolean intersects(Line line){
        double k1 = point2.getY() - point.getY() / point2.getX() - point.getX();
        double k2 = line.point2.getY() - line.point.getY() / line.point2.getX() - line.point.getX();
        return Math.abs(k1) != Math.abs(k2);
    }

    public double distance(Point p){
        double a = this.length();
        double b = Line.length(point,p);
        double c = Line.length(point2,p);
        return Math.sqrt((a+b+c)*(a+b-c)*(a+c-b)*(b+c-a)) / 2*a;
    }

    @Override
    public void draw() {

    }


    @Override
    public void zoom() {

    }

    public void zoom(double n){
        this.point = new Point(point.getX() * n,point.getY() * n);
        this.point2 = new Point(point2.getX() * n,point2.getY() * n);
    }

    @Override
    public void revolve() {

    }

    //绕原点旋转angle度
    public void revolve(int angle){
        double rad = Math.sin(angle * (Math.PI / 180));
        double x;
        double y;
        x = point.getX() * Math.cos(rad) - point.getY() * Math.sin(rad);
        y = point.getY() * Math.sin(rad) + point.getY() * Math.cos(rad);
        this.point = new Point(x,y);
        x = point2.getX() * Math.cos(rad) - point2.getY() * Math.sin(rad);
        y = point2.getY() * Math.sin(rad) + point2.getY() * Math.cos(rad);
        this.point2 = new Point(x,y);
    }
}
