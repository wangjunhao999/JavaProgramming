package Test_10;

public class ScrollThread extends Thread {

    public ScrollThread(){
        super();
    }

    @Override
    public void run() {
        while(true){
            try {
                sleep(2000);
                Student tmp = DisplayPanel.getFirstStudent();
                DisplayPanel.removeFirstStudent();
                DisplayPanel.addStudent(tmp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
