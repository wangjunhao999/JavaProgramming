package Test;

public class Main {
    public static void main(String args[]){
        System.out.println((0XFFFF0000 & 0XFF) << 16);
        System.out.println((0XFF00FF00 & 0XFF) << 8);
        System.out.println(0XFF0000FF & 0XFF);
    }
}
