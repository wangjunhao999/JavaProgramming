package Test_3;

public class Polygon extends ClosedFigure {

    private Point points[];

    public Polygon(final Point points[]){
        super(points[0],"多边形");
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
}
