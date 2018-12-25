package Test_4_5;

public class Weight_average implements Average {

    private double weight[];
    private double number[];

    public Weight_average(double weight[], double number[]){
        this.number = number;
        this.weight = weight;
    }

    public Weight_average(Weight_average w){
        this(w.weight,w.number);
    }

    public double average(){
        double sum = 0;
        for(int i = 0;i < weight.length;i++){
            sum += weight[i] * number[i];
        }
        double sumweight = 0;
        for(double w:weight){
            sumweight += w;
        }
        return sum / sumweight;
    }

    public static void main(String[] args) {
        double number[] = {1,2,3,4,5};
        double weight[] = {5,4,3,2,1};
        System.out.println(new Weight_average(weight,number).average());
    }
}
