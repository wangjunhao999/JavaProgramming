package Test_4_5;

import java.util.Scanner;

public class Polygon extends ClosedFigure {

    private Point points[];

    public Polygon(final Point points[]) throws IllegalArgumentException{
        super(points[0],"多边形");
        if(points.length < 3){
            throw new IllegalArgumentException("小于三个点无法构造多边形");
        }
        this.points = points;
    }

    @Override
    public String toString() {
        String str = this.getClass().getName() + this.shape + "," + points.length + "个点" + this.points[0].toString();
        for(int i = 1;i < points.length;i++){
            str += ", " + points[i].toString();
        }
        return str;
    }

    @Override
    public double perimeter() {
        double per = 0;
        int n = points.length;
        for(int i = 0;i < n;i++){
            per += Line.length(points[i],points[(i + 1) % n]);
        }
        return per;
    }

    @Override
    public double area() {
        double s = 0;
        for(int i = 0;i < points.length;i++){
            s += Triangle.area(points[0],points[i],points[i + 1]);
        }
        return s;
    }

    @Override
    public Point getPoint() {
        return super.getPoint();
    }

    @Override
    public String getShape() {
        return super.getShape();
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public void setPoint(Point point) {
        super.setPoint(point);
    }

    @Override
    public void setShape(String shape) {
        super.setShape(shape);
    }

    public void setPoints(Point[] points) {
        this.points = points;
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
        int n;
        Point points[];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入多边形的点数!");
        n = sc.nextInt();
        points = new Point[n];
        for(int i = 0;i< n;i++){
            points[i] = new Point(i,i);
        }
        Polygon p = new Polygon(points);
        //当n输入小于三时将抛出java.lang.IllegalArgumentException: 小于三个点无法构造多边形   异常
    }
}
