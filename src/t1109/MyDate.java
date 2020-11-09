package t1109;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: zlatanlong
 * @Date: 2020/11/9 7:51
 */
public class MyDate {
    private int year;
    private int month;
    private int day;
    private int h;
    private int m;
    private int s;

    public MyDate() {
        Date date = new Date();
        String[] strNow1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date).toString().split("-");
        year = Integer.parseInt(strNow1[0]);
        month = Integer.parseInt(strNow1[1]) - 1;
        day = Integer.parseInt(strNow1[2]);
        h = Integer.parseInt(strNow1[3]);
        m = Integer.parseInt(strNow1[4]);
        s = Integer.parseInt(strNow1[5]);
    }

    public MyDate(long elapsedTime) {
        Date date = new Date(elapsedTime);
        String[] strNow1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date).toString().split("-");
        year = Integer.parseInt(strNow1[0]);
        month = Integer.parseInt(strNow1[1]) - 1;
        day = Integer.parseInt(strNow1[2]);
        h = Integer.parseInt(strNow1[3]);
        m = Integer.parseInt(strNow1[4]);
        s = Integer.parseInt(strNow1[5]);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public boolean setDate(long elapsedTime) {
        return false;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + h +
                ", minute=" + m +
                ", second=" + s +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new MyDate());
        System.out.println(new MyDate(2147483648000L));
        System.out.println(new MyDate(561555550000L));
    }
}
