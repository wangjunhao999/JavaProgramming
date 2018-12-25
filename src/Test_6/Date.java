package Test_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Date extends JFrame implements ActionListener {

    private int year;
    private int mouth;
    private int day;

    private JTextField y;
    private JComboBox m;
    private JComboBox d;

    public Date(){
        super("输入日期");
        this.setSize(500,100);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        y = new JTextField("2018",5);
        this.add(y);
        this.add(new JLabel("年"));

        ComboBoxModel mouths = new DefaultComboBoxModel();
        for(int i = 1;i <= 12;i++){
            ((DefaultComboBoxModel) mouths).addElement(i);
        }
        m = new JComboBox(mouths);
        this.add(m);
        this.add(new JLabel("月"));

        ComboBoxModel days = new DefaultComboBoxModel();
        for(int i = 1;i <= 31;i++)
            ((DefaultComboBoxModel) days).addElement(i);
        d = new JComboBox(days);
        this.add(d);
        this.add(new JLabel("日"));

        m.addActionListener(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public boolean isLeapYear(){
        return this.year % 400 == 0 || this.year % 100 != 0 && this.year % 4 == 0;
    }

    public int getDayOfMouth(int i){
        if(i < 1 || i > 12)
            throw new IllegalArgumentException("月份必须在1-12之间");
        switch (i){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if(isLeapYear())
                    return 29;
                else
                    return 28;
        }
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("comboBoxChanged")){
            d.removeAllItems();
            this.year = Integer.parseInt(y.getText());
            this.mouth = (int)m.getSelectedItem();
            for(int i = 1;i <= getDayOfMouth(mouth);i++){
                d.addItem(i);
            }

        }
    }

    public static void main(String[] args) {
        new Date();
    }

}
