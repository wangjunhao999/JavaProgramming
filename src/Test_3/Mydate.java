package Test_3;

public class Mydate {

    private int year;
    private int month;
    private int day;
    private static int thisYear;

    static {
        thisYear = 2012;
    }

    public Mydate(int year,int mouth,int day){
        this.day = day;
        this.month = mouth;
        this.year = year;
    }

    public Mydate(){
        this(1970,1,1);
    }

    public Mydate(Mydate d){
        this(d.year,d.month,d.day);
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public static int getThisYear() {
        return thisYear;
    }

    public static void setThisYear(int thisYear) {
        Mydate.thisYear = thisYear;
    }

    @Override
    public String toString() {
        return year + "年" + String.format("%02d",month) + "月" + String.format("%02d",day) + "日";
    }

    public static boolean isLearYear(int year){
        return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
    }

    public static boolean isLearYear(){
        return isLearYear(thisYear);
    }

    public boolean equals(Mydate d) {
        if(this == d)
            return true;
        if(d != null && this.year == d.year && this.month == d.month && this.day == d.day)
            return true;
        return false;
    }

    public static int dayOfMouth(int year,int mouth){
        switch (mouth){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return Mydate.isLearYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }

    public int dayOfMouth(){
        return dayOfMouth(this.year,this.month);
    }

    public void tomorrow(){
        this.day++;
        if(this.day > dayOfMouth()){
            this.day = 1;
            this.month++;
            if(this.month > 12){
                this.year++;
                this.month = 1;
            }
        }
    }

    public Mydate yesterday(){
        Mydate date = new Mydate(this);
        date.day--;
        if(date.day == 0){
            date.month--;
            if(date.month == 0)
                date.year--;
            date.day = dayOfMouth(date.year,date.month);
        }
        return date;
    }

}
