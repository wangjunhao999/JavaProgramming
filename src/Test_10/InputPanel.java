package Test_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputPanel extends JPanel implements ActionListener {

    private JTextField studentIDTextField;
    private JTextField studentNameTextField;
    private JTextField moneyTextField;
    private JRadioButton[] studentSexRadioButtons;
    private DefaultComboBoxModel studentCollegeComboBoxModel;
    private DefaultComboBoxModel operationTypeComboBoxModel;
    private JButton saveButton;
    private JButton addButton;
    private JButton runButton;

    public InputPanel(){
        super();
        this.setLayout(new GridLayout(8,1));
        JPanel tmpJpanel;

        tmpJpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tmpJpanel.add(new JLabel("学号:"));
        tmpJpanel.add(studentIDTextField = new JTextField(10));
        studentIDTextField.addActionListener(this);
        this.add(tmpJpanel);

        tmpJpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tmpJpanel.add(new JLabel("姓名:"));
        tmpJpanel.add(studentNameTextField = new JTextField(10));
        this.add(tmpJpanel);

        tmpJpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tmpJpanel.add(new JLabel("性别:"));
        ButtonGroup sexGroup = new ButtonGroup();
        this.studentSexRadioButtons = new JRadioButton[2];
        tmpJpanel.add(studentSexRadioButtons[0] = new JRadioButton("男"));
        tmpJpanel.add(studentSexRadioButtons[1] = new JRadioButton("女"));
        sexGroup.add(studentSexRadioButtons[0]);
        sexGroup.add(studentSexRadioButtons[1]);
        studentSexRadioButtons[0].setSelected(true);
        this.add(tmpJpanel);

        tmpJpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tmpJpanel.add(new JLabel("学院:"));
        JComboBox studentCollegeComboBox;
        tmpJpanel.add(studentCollegeComboBox = new JComboBox<>(studentCollegeComboBoxModel = new DefaultComboBoxModel()));
        studentCollegeComboBoxModel.addElement("机信学院");
        studentCollegeComboBoxModel.addElement("商学院");
        studentCollegeComboBoxModel.addElement("物理学院");
        studentCollegeComboBox.setEditable(true);
        this.add(tmpJpanel);

        tmpJpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tmpJpanel.add(new JLabel("操作类型"));
        JComboBox operationTypeComboBox;
        tmpJpanel.add(operationTypeComboBox = new JComboBox(operationTypeComboBoxModel = new DefaultComboBoxModel()));
        operationTypeComboBoxModel.addElement("消费");
        operationTypeComboBoxModel.addElement("充值");
        operationTypeComboBoxModel.addElement("销卡");
        operationTypeComboBox.setEditable(true);
        this.add(tmpJpanel);

        tmpJpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tmpJpanel.add(new JLabel("金额"));
        tmpJpanel.add(moneyTextField = new JTextField(10));
        this.add(tmpJpanel);

        tmpJpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tmpJpanel.add(saveButton = new JButton("保存"));
        tmpJpanel.add(addButton = new JButton("添加"));
        addButton.addActionListener(this);
        saveButton.addActionListener(this);
        saveButton.setEnabled(false);
        this.add(tmpJpanel);

        tmpJpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tmpJpanel.add(runButton = new JButton("启动线程"));
        runButton.addActionListener(this);
        this.add(tmpJpanel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(studentIDTextField)){
            String str[] = FileIO.readAllLines("./src/Test_10/stuInfo.txt");
            DisplayPanel.clearStudent();
            for(int i = 0;i < str.length;i++){
                if(str[i] != null && str[i].startsWith(studentIDTextField.getText())){
                    DisplayPanel.addStudent(str[i]);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null,"该学生不存在!");
            saveButton.setEnabled(true);
        }
        else if(actionEvent.getSource().equals(saveButton)){
            String stuID = studentIDTextField.getText();
            String stuName = studentNameTextField.getText();
            String stuSex = studentSexRadioButtons[0].isSelected() ? "男" : "女";
            String stucollege = studentCollegeComboBoxModel.getSelectedItem().toString();
            Student tmp = new Student(stuID,stuName,stuSex,stucollege);
            FileIO.writeLine("./src/Test_10/stuInfo.txt",tmp.toString());
            saveButton.setEnabled(false);
        }
        else if(actionEvent.getSource().equals(addButton)){
            String stuID = studentIDTextField.getText();
            String stuName = studentNameTextField.getText();
            String stuSex = studentSexRadioButtons[0].isSelected() ? "男" : "女";
            String stucollege = studentCollegeComboBoxModel.getSelectedItem().toString();
            Student tmp = new Student(stuID,stuName,stuSex,stucollege);
            DisplayPanel.addStudent(tmp);
        }
        else if(actionEvent.getSource().equals(runButton)){
            new ScrollThread().start();
            runButton.setEnabled(false);
        }
    }
}
