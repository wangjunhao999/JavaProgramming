package Test_3;

import java.util.Scanner;

public class Point {

    private double x;
    private double y;

    Point(double x,double y){
        this.x = x;
        this.y = y;
    }

    Point(){
        this(0,0);
    }

    Point(Point p){
        this(p.x,p.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point" + "(" + this.x + "," + this.y + ")";
    }

    public static void main(String args[]){
        System.out.println("请输入点坐标(以输入0 0结束):");
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        while(((x = sc.nextInt()) != 0) && ((y = sc.nextInt()) != 0)){
            System.out.println(new Point(x,y));
        }
    }
}
