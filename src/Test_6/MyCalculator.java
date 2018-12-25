package Test_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculator extends JFrame implements ActionListener {

    private JTextArea out;
    private JTextArea in;

    public MyCalculator(){
        super("MyCalculator");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        JPanel display = new JPanel(new GridLayout(2,1,2,2));
        display.setBackground(Color.GRAY);
        this.add(display,BorderLayout.NORTH);
        JPanel calc = new JPanel(new GridLayout(4,4,2,2));
        calc.setBackground(Color.BLACK);
        this.add(calc,BorderLayout.CENTER);

        this.out = new JTextArea(5,10);
        out.setEditable(false);
        out.setLineWrap(true);
        display.add(out);
        this.in = new JTextArea(5,10);
        out.setLineWrap(true);
        display.add(in);

        String[] bottonstr = {"7","8","9","/","4","5","6","*","1","2","3","-","0","C","=","+"};
        for(int i = 0;i < bottonstr.length;i++){
            JButton a = new JButton(bottonstr[i]);
            a.setBackground(Color.gray);
            a.addActionListener(this);
            calc.add(a);
        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String str = actionEvent.getActionCommand();
        if(str.charAt(0) >= '0' && str.charAt(0) <= '9'){
            in.append(str);
        }
        else if(str.charAt(0) == '+' || str.charAt(0) == '-' || str.charAt(0) == '*' || str.charAt(0) == '/'){
            in.append(" ");
            in.append(str);
            in.append(" ");
        }
        else if(str.charAt(0) == 'C'){
            in.setText("");
            out.setText("");
        }
        else if(str.charAt(0) == '=') {
            out.setText("");
            in.append(" ");
            in.append(str);
            in.append(" ");
            String s[] = in.getText().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[2]);
            int c = 0;
            char op = s[1].charAt(0);

            if(op == '+'){
                c = a + b;
            }
            else if(op == '-'){
                c = a - b;
            }
            else if(op == '*'){
                c = a * b;
            }
            else if(op == '/'){
                c = a / b;
            }
            out.setText(c + "");
        }
    }
}
