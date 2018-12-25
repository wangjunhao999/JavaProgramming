package Test_3;

public class Swap {
    //值传递，不能交换
    public static void swap(Object x,Object y){
        Object tmp = x;
        x = y;
        y = tmp;
    }
    //引用传递，可以交换
    public static void swap(Object value[],int i,int j){
        if(value != null && i >= 0 && i < value.length && j >= 0 && j < value.length && i != j){
            Object tmp = value[j];
            value[j] = value[i];
            value[i] = tmp;
        }
    }

    public static void main(String args[]){
        int n = 10;
        Integer value[] = new Integer[n];
        Integer x = (int)(n * Math.random());
        Integer y = (int)(n * Math.random());
        System.out.println(x + " " + y);
        swap(x,y);
        System.out.println(x + " " + y);
        for(int i = 0;i < n;i++){
            value[i] = (int)(Math.random() * n);
            System.out.print(value[i] + " ");
        }
        System.out.println();
        swap(value,2,5);
        for(int i = 0;i < n;i++){
            System.out.print(value[i] + " ");
        }
    }
}
