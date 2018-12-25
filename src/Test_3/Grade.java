package Test_3;

import java.io.Serializable;

public class Grade implements Serializable {

    private int chinese;
    private int math;
    private int english;
    private int physics;
    private int chemistry;
    private int biology;

    public Grade(int chinese,int math,int english,int physics,int chemistry,int biology){
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.physics = physics;
        this.chemistry = chemistry;
        this.biology = biology;
    }

    public Grade(){
        this(0,0,0,0,0,0);
    }

    public Grade(Grade p){
        this(p.chinese,p.math,p.english,p.physics,p.chemistry,p.biology);
    }

    public void setChinese(int chinese){
        this.chinese = chinese;
    }

    public void setMath(int math){
        this.math = math;
    }

    public void setEnglish(int english){
        this.english = english;
    }

    public void setPhysics(int physics){
        this.physics = physics;
    }

    public void setChemistry(int chemistry){
        this.chemistry = chemistry;
    }

    public void  setBiology(int biology){
        this.biology = biology;
    }

    public int getChinese(){
        return this.chinese;
    }

    public int getMath() {
        return this.math;
    }

    public int getEnglish() {
        return this.english;
    }

    public int getPhysics() {
        return this.physics;
    }

    public int getChemistry() {
        return this.chemistry;
    }

    public int getBiology() {
        return this.biology;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("语文成绩:" + chinese + "\n");
        str.append("数学成绩:" + math + "\n");
        str.append("英语成绩：" + english + "\n");
        str.append("物理成绩:" + physics + "\n");
        str.append("化学成绩:" + chemistry + "\n");
        str.append("生物成绩：" + biology);
        return str.toString();
    }

    public static void main(String args[]){
        System.out.println(new Grade());
    }
}
