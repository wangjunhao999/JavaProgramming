package Test_11;

import javax.swing.*;

public class LeftJpanel extends JPanel {

    public JTable tmp;
    public JScrollPane scrollPane;

    public LeftJpanel(){
        String sql = "SELECT id AS 学号,name AS 姓名,major AS 专业,score AS 分数\n" +
                "FROM javascore";
        this.add(scrollPane = new JScrollPane(tmp = DataBaseOperation.query(sql)));
    }
}
