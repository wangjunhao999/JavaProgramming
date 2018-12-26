package Test_10;

public class Student {

    private String studentID;
    private String studentName;
    private String studentSex;
    private String studentCollege;

    public Student(String studentID,String studentName,String studentSex,String studentCollege){
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.studentCollege = studentCollege;
    }

    public Student(String str){
        if(str == null){
            this.studentID = null;
            this.studentName = null;
            this.studentSex = null;
            this.studentCollege = null;
            return;
        }

        String s[] = str.split(",");
        if(s.length != 4)
            throw new IllegalArgumentException("输入的文本串格式不正确!");
        this.studentID = s[0];
        this.studentName = s[1];
        this.studentSex = s[2];
        this.studentCollege = s[3];
    }

    public String getStudentCollege() {
        return studentCollege;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentCollege(String studentCollege) {
        this.studentCollege = studentCollege;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(studentID + ",");
        str.append(studentName + ",");
        str.append(studentSex + ",");
        str.append(studentCollege);
        return str.toString();
    }

    public static boolean equals(Student a,Student b){
        return a.studentID.equals(b.studentID) && a.studentName.equals(b.studentName)
                && a.studentSex.equals(b.studentSex) && a.studentCollege.equals(b.studentCollege);
    }
}
