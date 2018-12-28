package Test_11;

import javax.swing.*;

public class SouthJpanel extends JPanel {

    public JTable tmp;
    public JScrollPane scrollPane;

    public SouthJpanel(){
        String sql = "SELECT * FROM javascore";
        this.add(scrollPane = new JScrollPane(tmp = DataBaseOperation.query(sql)));
    }
}
