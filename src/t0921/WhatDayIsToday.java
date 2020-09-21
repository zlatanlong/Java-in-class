package t0921;

import java.util.Arrays;
import java.util.Scanner;

public class WhatDayIsToday {
    public int getTodayNum(int q, int m, int y) {
        if (m == 1) {
            y--;
            m = 13;
        } else if (m == 2) {
            y--;
            m = 14;
        }
        int j = y / 100;
        int k = y % 100;
        return (q + 26 * (m + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;
    }

    public String getTodayString(int num) {
        switch (num) {
            case 0:
                return "星期六";
            case 1:
                return "星期天";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
        }
        return "错误";
    }

    public boolean validM(int m) {
        return m >= 1 && m <= 12;
    }

    public boolean validD(int y, int m, int q) {
        Integer[] day31 = {1, 3, 5, 7, 8, 10, 12};
        Integer[] day30 = {4, 6, 9, 11};
        Integer[] m2 = {2};
        if (Arrays.asList(m2).contains(m)) {
            return this.isRun2Yue(y) ? q >= 1 && q <= 29 : q >= 1 && q <= 28;
        } else if (Arrays.asList(day30).contains(m)) {
            return q >= 1 && q <= 30;
        } else if (Arrays.asList(day31).contains(m)) {
            return q >= 1 && q <= 31;
        }
        return false;
    }

    public boolean isRun2Yue(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public int getM(Scanner scanner) {
        System.out.print("输入月份：(1-12)");
        return scanner.nextInt();
    }

    public int getD(Scanner scanner) {
        System.out.print("输入当月的第几天：");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WhatDayIsToday whatDayIsToday = new WhatDayIsToday();
        System.out.print("输入年份：(例：2012)");

        try {
            int y = scanner.nextInt();
            int m, q;

            m = whatDayIsToday.getM(scanner);
            while (!whatDayIsToday.validM(m)) {
                System.out.println("警告：请输入正确的月份！");
                m = whatDayIsToday.getM(scanner);
            }
            q = whatDayIsToday.getD(scanner);
            while (!whatDayIsToday.validD(y, m, q)) {
                System.out.println("警告：请输入正确的日期！");
                q = whatDayIsToday.getD(scanner);
            }
            System.out.println("您输入的日期是：" + whatDayIsToday.getTodayString(whatDayIsToday.getTodayNum(q, m, y)));
        } catch (Exception e) {
            System.out.println("请输入正确的日期格式！");
        }


    }
}
