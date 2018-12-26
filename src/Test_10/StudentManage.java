package Test_10;

import javax.swing.*;

public class StudentManage extends JFrame {

    private InputPanel leftPanel;
    private DisplayPanel rightPanel;

    public StudentManage(){
        super("201700800377 王蕾锦");
        this.setSize(700,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.leftPanel = new InputPanel();
        this.rightPanel = new DisplayPanel();
        this.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPanel,rightPanel));

        /*this.pack();*/
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentManage();
    }
}
