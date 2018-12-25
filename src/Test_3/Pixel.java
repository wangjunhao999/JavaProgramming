package Test_3;

public class Pixel extends Point implements ColorConstant {

    Color color;

    Pixel(Point point,Color color){
        super(point);
        this.color = color;
    }

    Pixel(){
        this(new Point(),new Color());
    }

    Pixel(Pixel p){
        super(p);
        this.color = p.color;
    }

    @Override
    public String toString() {
        return super.toString() + " " + color.toString();
    }

    public static void main(String args[]){
        System.out.println(new Pixel());
        System.out.println(new Pixel(new Point(4,5),new Color(WHITE)));
    }
}
