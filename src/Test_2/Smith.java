package Test_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Smith {

    public static boolean isPrime(int n) {
        if (n == 2)
            return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static int numSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static boolean isSmith(int n) {
        int a = n;
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 2; i <= n; ) {
            if (isPrime(i) && n % i == 0) {
                array.add(i);
                n = n / i;
            } else {
                i++;
            }
        }
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum = sum + numSum(array.get(i));
        }
        array.clear();
        if (sum == numSum(a))
            return true;
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要求多少以内的Smith数(以输入0结束):");
        int n;
        while ((n = sc.nextInt()) != 0) {
            for (int i = 3; i <= n; i++) {
                if (isPrime(i)) {
                    if (isSmith(i)) {
                        System.out.print(i + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}
