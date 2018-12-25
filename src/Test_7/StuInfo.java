package Test_7;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class StuInfo extends JFrame implements ListSelectionListener {

    private JTable stuTable;
    private DefaultTableModel stuModel;
    private JList provinceList;
    private DefaultListModel provinceModel;

    public StuInfo(){
        super("分类浏览学生信息表");
        this.setLocationRelativeTo(null);
        this.setSize(750,300);

        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new BorderLayout());
        this.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPanel,rightPanel));

        //provinceList数据生成
        String[] provice = {"全部","北京市","天津市","上海市","重庆市","河北省","河南省","云南省","辽宁省","黑龙江省","湖南省","安徽省","山东省","新疆维吾尔","江苏省","浙江省","江西省","湖北省","广西壮族","甘肃省","山西省","内蒙古","陕西省","吉林省","福建省","贵州省","广东省","青海省","西藏","四川省","宁夏回族","海南省","台湾省","香港特别行政区","澳门特别行政区"};
        this.provinceModel = new DefaultListModel();
        for(int i = 0;i < provice.length;i++)
            this.provinceModel.addElement(provice[i]);
        this.provinceList = new JList(provinceModel);
        this.provinceList.addListSelectionListener(this);


        //stuTable数据生成
        this.stuModel = new DefaultTableModel();
        this.stuTable = new JTable(stuModel);

        //可视化
        leftPanel.add(new JScrollPane(provinceList));
        rightPanel.add(new JScrollPane(stuTable));

        //事件触发
        query("全部",true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //数据库查询
    public void query(String province,boolean first){
        stuModel.setRowCount(0);
        String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://120.78.209.49;database=stuinfo";
        String username = "SA";
        String password = "Wang13587";
        String sql = "";
        try {
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            if(province.equals("全部")){
                sql = "SELECT * FROM student";
            }
            else{
                sql = "SELECT * FROM student" + " WHERE 省份 = " + "N";
                sql = sql.concat("\'" + province + "\'");
            }
            ResultSet rset = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rset.getMetaData();
            int count = rsmd.getColumnCount();
            if(first){
                for(int i = 1;i <= count;i++){
                    stuModel.addColumn(rsmd.getColumnName(i));
                }
            }
            String[] oneRow = new String[count];
            while (rset.next()){
                for(int i = 0;i < count;i++){
                    oneRow[i] = rset.getString(i + 1);
                }
                stuModel.addRow(oneRow);
            }
            rset.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void query(String province){
        query(province,false);
    }


    public static void main(String[] args) {
        new StuInfo();
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        String pro = (String) provinceList.getSelectedValue();
        query(pro);
    }
}
