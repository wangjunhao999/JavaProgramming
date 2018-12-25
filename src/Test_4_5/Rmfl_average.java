package Test_4_5;

public class Rmfl_average implements Average{

    private double s[];

    public Rmfl_average(double s[]){
        this.s = s;
    }

    public Rmfl_average(Rmfl_average r){
        this(r.s);
    }

    public double average(){
        double sum = 0;
        for(int i = 1; i< s.length - 1;i++){
            sum += s[i];
        }
        return sum / s.length;
    }

    public static void main(String[] args) {
        double a[] = {1.1,2.2,3.3,4.4,5.5};
        System.out.println(new Rmfl_average(a).average());
    }
}
