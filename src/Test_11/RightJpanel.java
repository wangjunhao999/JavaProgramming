package Test_11;

import javax.swing.*;


public class RightJpanel extends JPanel {

    public JTable tmp;
    public JScrollPane scrollPane;

    public RightJpanel(){
        String sql = "SELECT id AS 学号,name AS 姓名,major AS 专业,\n" +
                "       CASE WHEN score >= 90 THEN 'A' WHEN score >= 75 THEN 'B' WHEN score >= 60 THEN 'C' ELSE 'D' END AS 成绩等级\n" +
                "FROM javascore";
        this.add(scrollPane = new JScrollPane(tmp = DataBaseOperation.query(sql)));
    }
}
