package Test_3;

public abstract class ClosedFigure extends Figure{

    protected String shape;

    protected ClosedFigure(Point point,String shape){
        super(point);
        this.shape = shape;
    }

    protected ClosedFigure(){
        this(new Point(),"未知");
    }

    public abstract double perimeter();

    public abstract double area();

    public void print(){
        System.out.println(this.toString() + ",周长" + String.format("%1.2f,面积%1.2f",this.perimeter(),this.area()));
    }

    @Override
    public Point getPoint() {
        return super.getPoint();
    }

    public String getShape() {
        return shape;
    }

    @Override
    public void setPoint(Point point) {
        super.setPoint(point);
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public abstract boolean contains(Point p);
}
