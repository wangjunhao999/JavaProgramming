package Test_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDate extends JFrame implements ActionListener {

    private JTextField yearTextField;
    private JComboBox mouthComboBox,dayComboBox;
    private DefaultComboBoxModel mouthModel,dayModel;

    public MyDate(){
        super("MyDate");
        this.setSize(300,80);
        this.setLocationRelativeTo(null);
        JPanel a = new JPanel(new FlowLayout());
        this.add(a);
        this.yearTextField = new JTextField("2018",5);
        a.add(yearTextField);
        a.add(new JLabel("年"));
        this.mouthModel = new DefaultComboBoxModel();
        for(int i = 1;i <= 12;i++)
            this.mouthModel.addElement(i);
        this.mouthComboBox = new JComboBox(mouthModel);
        this.mouthComboBox.addActionListener(this);
        a.add(mouthComboBox);
        a.add(new JLabel("月"));
        this.dayModel = new DefaultComboBoxModel();
        for(int i = 1;i <= 31;i++)
            this.dayModel.addElement(i);
        this.dayComboBox = new JComboBox(dayModel);
        a.add(dayComboBox);
        a.add(new JLabel("日"));

        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static boolean isLearYear(int year){
        return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
    }

    public static int getDay(int year,int mouth){
        int[] day = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(mouth == 2){
            if(isLearYear(year))
                return day[mouth] + 1;
            else
                return day[mouth];
        }
        return day[mouth];
    }

    public static void main(String[] args) {
        new MyDate();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int year = Integer.parseInt(yearTextField.getText());
        int mouth = (Integer) mouthComboBox.getSelectedItem();
        int day = getDay(year,mouth);
        int oldDay = dayModel.getSize();

        if(day == oldDay)
            return;
        else if(day < oldDay){
            for(int i = oldDay;i > day;i--)
                dayModel.removeElement(i);
                /*dayModel.removeElementAt(i-1);*/
        }
        else{
            for(int i = oldDay + 1;i <= day;i++){
                dayModel.addElement(i);
            }
        }
    }
}
