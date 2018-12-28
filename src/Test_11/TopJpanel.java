package Test_11;

import Test_10.StudentManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopJpanel extends JPanel implements ActionListener {

    protected JTextField exactQueryTextField;
    protected JTextField fuzzyQueryTextField;
    protected JButton sortButton;

    public TopJpanel(){
        super();
        this.add(new JLabel("学号精确查询:"));
        this.add(exactQueryTextField = new JTextField(12));
        this.add(new JLabel("学号模糊查询:"));
        this.add(fuzzyQueryTextField = new JTextField(12));
        this.add(sortButton = new JButton("排序"));
        exactQueryTextField.addActionListener(this);
        fuzzyQueryTextField.addActionListener(this);
        sortButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(exactQueryTextField)){
            String sql = "SELECT *\n" +
                    "FROM javascore\n" +
                    "WHERE id = " + exactQueryTextField.getText();
            JTable tmp = DataBaseOperation.query(sql);
            StudentManagement.setSouthJtable(tmp);
        }
        else if(actionEvent.getSource().equals(fuzzyQueryTextField)){
            String sql = "SELECT *\n" +
                    "FROM javascore\n" +
                    "WHERE id LIKE " + fuzzyQueryTextField.getText();
            JTable tmp = DataBaseOperation.query(sql);
            StudentManagement.setSouthJtable(tmp);
        }
        else if(actionEvent.getSource().equals(sortButton)){
            String sql1 = "SELECT id AS 学号,name AS 姓名,major AS 专业,score AS 分数\n" +
                    "FROM javascore\n" +
                    "ORDER BY score DESC";
            String sql2 = "SELECT id AS 学号,name AS 姓名,major AS 专业,\n" +
                    "       CASE WHEN score >= 90 THEN 'A' WHEN score >= 75 THEN 'B' WHEN score >= 60 THEN 'C' ELSE 'D' END AS 成绩等级\n" +
                    "FROM javascore\n" +
                    "ORDER BY score DESC";
            JTable tmp1 = DataBaseOperation.query(sql1);
            JTable tmp2 = DataBaseOperation.query(sql2);

            StudentManagement.setLeftJtable(tmp1);
            StudentManagement.setRightJtable(tmp2);
        }
    }
}
