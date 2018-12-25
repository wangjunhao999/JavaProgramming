package Test_3;

import java.util.Calendar;

public class Person {

    public String name;
    public Mydate birthday;
    public String sex;
    public String province;
    public String city;

    public static int count = 0;

    public Person(String name,Mydate birthday,String sex,String province,String city){
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.province = province;
        this.city = city;
        Person.count++;
    }

    public Person(String name,Mydate birthday){
        this(name,birthday,null,null,null);
    }

    public Person(){
        this(null,new Mydate(),null,null,null);
    }


    public static void howMany(){
        System.out.println(Person.count + "个Persion对象");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Mydate birthday) {
        this.birthday = birthday;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public static int getCount() {
        return count;
    }

    public Mydate getBirthday() {
        return birthday;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public int getAge(int year){
        return year - birthday.getYear();
    }

    public int getAge(){
        Calendar c1 = Calendar.getInstance();
        int year = c1.get(Calendar.YEAR);
        return getAge(year);
    }

    @Override
    public String toString() {
        return name + "," + (birthday == null ? "" : birthday.toString() + "," + sex + "," + province + "," + city);
    }

    public boolean equals(Person p){
        return this == p || this.name.equals(p.name) && this.birthday.equals(p.birthday) && this.city.equals(p.city) && this.province.equals(p.province) && this.sex.equals(p.sex);
    }
}
