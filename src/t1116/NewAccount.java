package t1116;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author: zlatanlong
 * @Date: 2020/11/16 8:23
 */
public class NewAccount extends Account {

    private String name;
    private ArrayList<Transaction> transactions;

    public NewAccount(int id, double balance, String name) {
        super(id, balance);
        this.name = name;
        transactions = new ArrayList<>();
    }

    @Override
    public boolean withDraw(double d) {
        if (super.withDraw(d)) {
            transactions.add(new Transaction('W', d, balance, ""));
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean deposit(double d) {
        if (super.deposit(d)) {
            transactions.add(new Transaction('D', d, balance, ""));
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public static void main(String[] args) {
        NewAccount account = new NewAccount(1122, 1000, "George");
        account.setAnnualInterestRate(1.5);
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        account.withDraw(5);
        account.withDraw(4);
        account.withDraw(2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String f1 = sdf.format(account.getDateCreated());
        System.out.println("开户日期: " + f1);
        System.out.println("开户人: " + account.getName());
        System.out.println("余额： " + account.getBalance());
        System.out.println("月利息： " + account.getMonthlyInterest());

        account.getTransactions().forEach(
                transaction -> {
                    String type = transaction.getType() == 'W' ? "取款" : "存款";
                    System.out.println("交易日期: " + sdf.format(transaction.getDate())
                            + " | 交易类型： " + type
                            + " | 交易量： " + transaction.getAmount()
                            + " | 当前余额： " + transaction.getBalance()
                            + " | 描述 " + transaction.getDescription()
                    );
                }
        );
    }

}

class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    public Transaction(char type, double amount, double balance, String description) {
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}