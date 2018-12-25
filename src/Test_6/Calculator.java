package Test_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextArea ans;
    private boolean flag = false;
    private String a = "";
    private String b = "";
    private String c = "";
    private String op = "";

    public Calculator(){
        super("My calculator");
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        JPanel display = new JPanel(new FlowLayout());
        JPanel operation = new JPanel(new GridLayout(5,4));
        this.add(display,BorderLayout.NORTH);
        this.add(operation,BorderLayout.CENTER);

        ans = new JTextArea(5,40);
        ans.setLineWrap(true);
        ans.setFont(new Font("宋体", Font.PLAIN, 30));
        ans.setEditable(false);

        display.add(ans);


        String[] data = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","%","+","C","="};
        for(int i = 0;i < data.length;i++){
            JButton b = new JButton(data[i]);
            b.addActionListener(this);
            operation.add(b);
        }

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String option = actionEvent.getActionCommand();
        ans.append(option);
        switch (option){
            case "1": case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9": case "0": case ".":
                if(!flag){
                    a = a + option;
                }
                else{
                    b = b + option;
                }
                break;
            case "+": case "-": case "*": case "/": case "%":
                op = option;
                flag = true;
                break;
            case "C":
                a = "";
                b = "";
                c = "";
                ans.setText("");
                flag = false;
                break;
            case "=":
                double aa = Double.parseDouble(a);
                double bb = Double.parseDouble(b);
                double cc = 0.0;
                if(op.equals("+")){
                    cc = aa + bb;
                }
                else if(op.equals("-")){
                    cc = aa - bb;
                }
                else if(op.equals("*")){
                    cc = aa * bb;
                }
                else if(op.equals("/")){
                    cc = aa / bb;
                }
                else if(op.equals("%")){
                    cc = aa % bb;
                }
                c = cc + "";
                ans.append(c);
                a = "";
                b = "";
                c = "";
                flag = false;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }

}
