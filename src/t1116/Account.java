package t1116;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zlatanlong
 * @Date: 2020/11/16 8:03
 */
public class Account {

    private int id;
    protected double balance;
    private double annualInterestRate;
    private final Date dateCreated= new Date();

    public Account() {
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public boolean withDraw(double d) {
        if (d > balance) {
            return false;
        }
        balance -= d;
        return true;
    }

    public boolean deposit(double d) {
        if ((d + balance) > Double.MAX_VALUE) {
            return false;
        }
        balance += d;
        return true;
    }

    public double getMonthlyInterest() {
        double mIR = annualInterestRate / 12;
        return balance * mIR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate / 100;
    }

    public Date getDateCreated() {
        return dateCreated;
    }


    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        if (!account.withDraw(2500)) {
            System.out.println("取款失败！");
        }
        if (!account.deposit(3000)) {
            System.out.println("存款失败！");
        }

        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(account.getDateCreated());

        System.out.println("开户日期: "+format);

        System.out.println("余额： "+ account.getBalance());
        System.out.println("月利息： "+ 100*account.getAnnualInterestRate() /12 + "%");

    }
}
