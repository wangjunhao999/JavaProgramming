package Test_3;

import java.util.Scanner;

public class Complex {

    private double real;
    private double virtual;

    public Complex(double real,double virtual){
        this.real = real;
        this.virtual = virtual;
    }

    public Complex(String s){
        char c;
        int realSign = 0;
        int virSign = 0;
        this.real = 0;
        this.virtual = 0;
        int flag = 0;
        for(int i = 0;i < s.length();i++){
            c = s.charAt(i);
            switch (c){
                case '+': case '-':
                    if(flag == 0 && c == '+'){
                        flag = 1;
                        realSign = 1;
                    }
                    else if(flag == 1 && c == '+'){
                        flag = 0;
                        virSign = 1;
                    }
                    else if(flag == 0 && c == '-'){
                        flag = 1;
                        realSign = -1;
                    }
                    else{
                        flag = 0;
                        virSign = -1;
                    }
                    break;
                case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
                    if(flag == 1 || i == 0){
                        if(i == 0){
                            flag = 1;
                            realSign = 1;
                        }
                        real = real * 10 + c - '0';
                    }
                    else
                        virtual = virtual * 10 + c - '0';
                default:
                    break;
            }
        }
        this.real = this.real * realSign;
        this.virtual = this.virtual * virSign;
    }

    public Complex(){
        this(0.0,0.0);
    }

    public Complex(Complex x){
        this(x.real,x.virtual);
    }

    public static Complex add(Complex a,Complex b){
        return new Complex(a.real + b.real, a.virtual + b.virtual);
    }

    public Complex add(Complex b){
        this.real += b.real;
        this.virtual += b.virtual;
        return this;
    }

    public Complex sub(Complex b){
        this.real -= b.real;
        this.virtual -= b.virtual;
        return this;
    }

    public static Complex sub(Complex a,Complex b){
        return new Complex(a.real - b.real,a.virtual - b.virtual);
    }

    @Override
    public String toString() {
        return "Complex" + "(" + this.real + "," + this.virtual + ")";
    }

    public boolean equals(Complex b) {
        return this.real == b.real && this.virtual == b.virtual;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.println("现在进行复数测试(以输入空结束):");
        System.out.println("请输入你的第一个复数：如（a+bi）");
        Complex a = new Complex(sc.nextLine());
        System.out.println("请输入你的第二个复数：如（a+bi）");
        Complex b = new Complex(sc.nextLine());
        System.out.println("下面输出这两个复数相加的结果：" + Complex.add(a,b).toString());
        System.out.println("下面输出这两个复数相减的结果：" + Complex.sub(a,b).toString());
        System.out.println("两个字符串是否相等:" + a.equals(b));
    }
}
