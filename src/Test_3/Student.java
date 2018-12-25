package Test_3;

public class Student extends Person{
    public String id;
    public String department;
    public String speciality;
    public String number;
    public boolean member;
    public Grade grade;

    public static int count = 0;

    public Student(String name,Mydate birthday,String sex,String province,String city,String department,String speciality,String number,boolean member){
        super(name,birthday,sex,province,city);
        this.id = speciality + speciality.hashCode();
        this.department = department;
        this.member = member;
        this.number = number;
        this.speciality = speciality;
        Student.count++;
    }

    public Student(){
        this(null,new Mydate(),null,null,null,null,null,null,false);
    }

    public Student(Student p){
        this(p.name,new Mydate(p.birthday),p.sex,p.province,p.city,p.department,p.speciality,p.number,p.member);
    }


    public static void howMany(){
        Person.howMany();
        System.out.println(Student.count + "个Student对象");
    }

    public static void setCount(int count) {
        Student.count = count;
    }

    @Override
    public void setBirthday(Mydate birthday) {
        super.setBirthday(birthday);
    }

    @Override
    public void setCity(String city) {
        super.setCity(city);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setProvince(String province) {
        super.setProvince(province);
    }

    @Override
    public void setSex(String sex) {
        super.setSex(sex);
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public Mydate getBirthday() {
        return super.getBirthday();
    }

    @Override
    public String getCity() {
        return super.getCity();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getProvince() {
        return super.getProvince();
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String getSex() {
        return super.getSex();
    }

    public String getNumber() {
        return number;
    }

    public String getSpeciality() {
        return speciality;
    }
}
