package Test_11;

import javax.swing.*;
import java.awt.*;

public class StudentManagement extends JFrame {

    protected static TopJpanel topJpanel;
    protected static LeftJpanel leftJpanel;
    protected static RightJpanel rightJpanel;
    protected static SouthJpanel southJpanel;

    public static void setSouthJtable(JTable tmp1){
        southJpanel.remove(southJpanel.tmp);
        southJpanel.scrollPane.add(tmp1);
    }

    public static void setLeftJtable(JTable tmp1){
        leftJpanel.remove(leftJpanel.tmp);
        leftJpanel.scrollPane.add(tmp1);
    }

    public static void setRightJtable(JTable tmp1){
        leftJpanel.remove(leftJpanel.tmp);
        leftJpanel.scrollPane.add(tmp1);
    }

    public StudentManagement(){
        super("学生管理系统");
        this.setLayout(new GridLayout(3,1));
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(topJpanel = new TopJpanel(), BorderLayout.NORTH);
        JPanel tmpJpanel = new JPanel(new GridLayout(1,2));
        tmpJpanel.add(leftJpanel = new LeftJpanel());
        tmpJpanel.add(rightJpanel = new RightJpanel());
        this.add(tmpJpanel);
        this.add(southJpanel = new SouthJpanel(),BorderLayout.SOUTH);
        /*this.add(leftJpanel = new LeftJpanel(),BorderLayout.WEST);
        this.add(rightJpanel = new RightJpanel(),BorderLayout.EAST);
*/
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentManagement();
    }
}
