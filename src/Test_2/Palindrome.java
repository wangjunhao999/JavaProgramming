package Test_2;

import java.util.Scanner;

public class Palindrome {

    public static boolean isPalindrome(String s){
        for(int i = 0,j = s.length() - 1;i < s.length();i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串(以字符串0结束):");
        String s;
        while(!(s = sc.nextLine()).equals("0")){
            System.out.println(isPalindrome(s));
        }
    }
}
