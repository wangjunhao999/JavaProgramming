package Test_2;

import java.util.Scanner;

public class Upmat {

    public static void print(int mat[][]){
        for(int i = 0;i < mat.length;i++){
            for(int j = 0;j < mat[i].length;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] initMat_input(int n){
        int mat[][] = new int[n][n];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                 mat[i][j] = sc.nextInt();
            }
        }
        return mat;
    }

    public static int[][] initMat(int n){
        int mat[][] = new int[n][n];
        int count = 1;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                mat[i][j] = count++;
            }
        }
        return mat;
    }

    public static int[][] reverseMat(int [][] originalMat){
        for(int i = 0;i < originalMat.length;i++){
            for(int j = 0;j < i;j++){
                int tmp = originalMat[j][i];
                originalMat[j][i] = originalMat[i][j];
                originalMat[i][j] = tmp;
            }
        }
        return originalMat;
    }

    public static void main(String args[]){
        int n;
        System.out.println("请输入方阵的秩(以输入小于等于0结束):");
        Scanner input = new Scanner(System.in);
        while((n = input.nextInt()) > 0){
            System.out.println("请输入初始化矩阵:");
            int original[][] = initMat_input(n);
            System.out.println("该矩阵为:");
            print(original);
            System.out.println("翻转矩阵为:");
            print(reverseMat(original));
        }
    }
}
