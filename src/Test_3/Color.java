package Test_3;

import java.util.Scanner;

public class Color implements ColorConstant{

    private int value;

    public Color(int value){
        this.value = value;
    }

    public Color(int red,int green,int blue){
        this.value = 0xFF000000 | (red & 0XFF) << 16 | (green & 0XFF) << 8 | blue & 0XFF;
    }

    public Color(){
        this(BLACK);
    }

    public Color(Color color){
        this.value = color.value;
    }

    @Override
    public String toString() {
        return "RGB(" + ((this.value >> 16) & 0XFF) + "," + ((this.value >> 8) & 0XFF) + "," + (this.value & 0XFF) + ")";
    }

    public static void main(String args[]){
        System.out.println("请输入颜色的值(以输入0结束):");
        Scanner sc = new Scanner(System.in);
        int n;
        while((n = sc.nextInt()) != 0){
            System.out.println(new Color(n));
        }
        return;
    }

}
