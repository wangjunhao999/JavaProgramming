package Test_3;

import java.util.Date;

public class Account {

    private String account;
    private String name;
    private Date openDate;
    private String identityCard;
    private double balance;

    public Account(String account,String name,String identityCard,double balance){
        this.account = account;
        this.name = name;
        this.openDate = new Date();
        this.identityCard = identityCard;
        this.balance = balance;
    }

    public Account(){
        this(null,null,null,0.0);
    }

    public Account(Account account){
        this(account.account,account.name,account.identityCard,account.balance);
    }

    public static Account openAccount(String account,String name,String identityCard,double balance){
        return new Account(account,name,identityCard,balance);
    }

    public boolean deposit(double money){
        if(money > 0){
            this.balance += money;
            return true;
        }
        return false;
    }

    public boolean withdraw(double money){
        if(this.balance - money > 0){
            this.balance -= money;
            return true;
        }
        return false;
    }

    public double queryBalance(){
        return this.balance;
    }

    public String queryDetail(){
        return this.toString();
    }


    public String getAccount() {
        return account;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public double getBalance() {
        return balance;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("你的账号是:" + account + '\n');
        str.append("你的储户姓名是:" + name + '\n');
        str.append("你的开户时间是:" + openDate + '\n');
        str.append("你的身份证号码是:" + identityCard + '\n');
        str.append("你的存款余额是:" + balance + '\n');
        return str.toString();
    }

    public void print(){
        System.out.println(this.toString());
    }

    public static void main(String args[]){
        Account test = new Account("100001","张三","000000000000000000",5000);
        System.out.println("新建一个账户,信息为:");
        test.print();
        System.out.println("存取2000元在该账户里");
        test.deposit(2000);
        test.print();
        System.out.println("再取出3000元");
        test.withdraw(3000);
        test.print();
    }

}
