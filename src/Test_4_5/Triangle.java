package Test_4_5;

public class Triangle extends ClosedFigure {

    public Point point2;
    public Point point3;

    public double a;
    public double b;
    public double c;

    public Triangle(Point p1, Point p2, Point p3) throws IllegalArgumentException {
        super(p1,"三角形");
        this.point2 = p2;
        this.point3 = p3;
        double k1 = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX()),k2 = ((p3.getY() - p2.getY()) / (p3.getX() - p2.getX()));
        if(k1 == k2)
            throw new IllegalArgumentException("三个点平行无法构造三角形");
        this.a = Line.length(p1,p2);
        this.b = Line.length(p2,p3);
        this.c = Line.length(p3,p1);
    }

    public Triangle(Point p1, double a, double b, double c){
        super(p1,"三角形");
        this.point2 = this.point3 = null;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(){
        this(new Point(),new Point(),new Point());
    }

    @Override
    public String toString() {
        return this.getClass().getName() + this.shape + ",三点坐标" + this.point + "," + (this.point2 == null ? "null" : this.point2.toString()) + "," + (this.point3 == null ? "null" : this.point3.toString()) + ",三边边长" + String.format("%1.2f,%1.2f,%1.2f",this.a,this.b,this.c);
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static double area(Point p1, Point p2, Point p3){
        return new Triangle(p1,p2,p3).area();
    }

    @Override
    public String getShape() {
        return super.getShape();
    }

    @Override
    public Point getPoint() {
        return super.getPoint();
    }

    public Point getPoint2() {
        return point2;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public Point getPoint3() {
        return point3;
    }

    @Override
    public void setShape(String shape) {
        super.setShape(shape);
    }

    @Override
    public void setPoint(Point point) {
        super.setPoint(point);
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
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

    @Override
    public boolean contains(Point p) {
        return false;
    }

    public static void main(String[] args) {
        Point point1 = new Point(0,0);
        Point point2 = new Point(5,0);
        Point point3 = new Point(3,4);

        Point point4 = new Point(0,0);
        Point point5 = new Point(1,1);
        Point point6 = new Point(2,2);

        Triangle t1 = new Triangle(point1,point2,point3);
        /*//下面是异常抛出测试
        Triangle t2 = new Triangle(point4,point5,point6);*/
    }
}
