package Test_4_5;

import java.util.Scanner;

public class Circular_cone implements Area,Volume {

    private double radius;
    private double height;

    public Circular_cone(double radius,double height){
        this.radius = radius;
        this.height = height;
    }

    public Circular_cone(Circular_cone c){
        this(c.radius,c.height);
    }

    public double area(){
        return Math.PI * radius * radius + Math.PI * Math.sqrt(radius * radius + height * height);
    }

    public double volume(){
        return Math.PI * radius * radius * height / 3;
    }

    @Override
    public String toString() {
        return "圆锥的半径为:" + radius + "\t圆锥的高度为:" + height + "\t圆锥的表面积为:" + this.area() + "\t圆锥的体积为:" + this.volume();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radius,height;
        System.out.println("请输入圆锥的半径和高度:");
        radius = sc.nextDouble();
        height = sc.nextDouble();
        Circular_cone c = new Circular_cone(radius,height);
        System.out.println(c);
    }
}
