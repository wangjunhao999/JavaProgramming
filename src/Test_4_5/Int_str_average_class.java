package Test_4_5;

public class Int_str_average_class implements Int_str_average {

    public Int_str_average_class(){

    }

    public int average(int a[]){
        try{
            int sum = 0;
            for(int i:a){
                sum += i;
            }
            return sum / a.length;
        }
        catch (ArithmeticException e){
            return 0;
        }
    }

    public int average(String s[]){
        try{
            int sum = 0;
            for(int i = 0;i < s.length;i++){
                sum += Integer.parseInt(s[i]);
            }
            return sum / s.length;
        }
        catch (ArithmeticException a){
            return 0;
        }
    }

    public static void main(String[] args) {
        int s1[] = {1,2,3,4,5};
        String s2[] = {"6","7","8","9","10"};
        System.out.println(new Int_str_average_class().average(s1));
        System.out.println(new Int_str_average_class().average(s2));
        //以下测试错误catch语句
        System.out.println(new Int_str_average_class().average(new int[0]));
        System.out.println(new Int_str_average_class().average(new String[0]));
    }
}
