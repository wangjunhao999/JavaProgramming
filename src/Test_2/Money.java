package Test_2;

import java.util.Scanner;

public class Money {

    private static final String YUAN[] = {"万","千","佰","拾","亿","千","佰","拾","万","千","佰","拾","元","角","分"};
    private static final String DIGIT[] = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    private static final double MAX_VALUE = 9999999999999.99;

    public static String convertMoney(double n){
        if(n < 0 || n > MAX_VALUE)
            return null;
        long money = Math.round(n * 100);
        String result = "";
        for(int i = YUAN.length - 1;money > 0 && i > 0;i--,money /= 10){
            result = "" + DIGIT[(int)(money % 10)] + YUAN[i] + result;
        }
        return result;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入金额的小写形式(以输入0结束):");
        double n;
        while((n = sc.nextDouble()) != 0){
            System.out.println(convertMoney(n));
        }
    }

}
