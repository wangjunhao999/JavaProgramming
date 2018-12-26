package Test_10;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    private static DefaultListModel studentInfoJListModel;

    public DisplayPanel(){
        super();
        this.setLayout(new BorderLayout());
        JList studentInfoJList;
        JScrollPane scrollPane = new JScrollPane(studentInfoJList = new JList(studentInfoJListModel = new DefaultListModel()));
        String[] str = FileIO.readAllLines("./src/Test_10/stuInfo.txt");
        for(int i = 0;i < str.length;i++){
            if(str[i] != null)
                studentInfoJListModel.addElement(new Student(str[i]));
        }
        this.add(scrollPane);
    }

    public static void addStudent(Student stu){
        studentInfoJListModel.addElement(stu);
    }

    public static void addStudent(String str){
        addStudent(new Student(str));
    }

    public static void clearStudent(){
        studentInfoJListModel.clear();
    }

    public static void removeFirstStudent(){
        studentInfoJListModel.removeElementAt(0);
    }

    public static Student getFirstStudent(){
        return (Student) studentInfoJListModel.getElementAt(0);
    }

}
