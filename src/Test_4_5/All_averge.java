package Test_4_5;

public class All_averge implements Average{

    private double s[];

    public All_averge(double s[]){
        this.s = s;
    }

    public All_averge(All_averge a){
        this(a.s);
    }

    public double average(){
        double sum = 0;
        for(double i:s)
            sum += i;
        return sum / s.length;
    }

    public static void main(String[] args) {
        double a[] = {1.1,2.2,3.3,4.4,5.5};
        System.out.println(new All_averge(a).average());
    }

}
