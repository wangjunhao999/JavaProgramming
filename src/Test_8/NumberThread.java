package Test_8;

public class NumberThread extends Thread{

    private int first;
    private int end;
    private int step;
    private static final Object myTurn = new Object();

    public NumberThread(String name,int first,int end,int step){
        super(name);
        this.first = first;
        this.end = end;
        this.step = step;
    }

    public void run(){

        synchronized (myTurn){
            for(int i = first;i < end;i = i + step){
                System.out.println(this.getName() + ":" + i);
                myTurn.notify();
                try {
                    myTurn.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        new NumberThread("奇数线程",1,50,2).start();
        new NumberThread("偶数线程",2,50,2).start();
    }
}
