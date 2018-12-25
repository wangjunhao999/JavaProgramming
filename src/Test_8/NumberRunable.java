package Test_8;

public class NumberRunable implements Runnable{

    private String name;
    private int first;
    private int end;
    private int step;

    private static final Object myTurn = new Object();

    public NumberRunable(String name,int first,int end,int step){
        this.name = name;
        this.first = first;
        this.end = end;
        this.step = step;
    }

    @Override
    public void run() {

        synchronized (myTurn){
            for(int i = first;i < end;i = i + step){
                System.out.println(this.name + ":" + i);
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
        new Thread(new NumberRunable("Runable奇数线程",1,50,2),"Runable奇数线程").start();
        new Thread(new NumberRunable("Runable偶数线程",2,50,2),"Runable偶数线程").start();
    }
}
