package t1019;

import java.util.Scanner;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/19 7:43
 * 开头4,5,37,6
 */
public class Card {


    public static boolean isValid(long number) {
        if (Card.prefixMatched(number, 4)
                || Card.prefixMatched(number, 5)
                || Card.prefixMatched(number, 37)
                || Card.prefixMatched(number, 6)) {
            System.out.println(Card.sumOfOddPlace(number));
            System.out.println(Card.sumOfDoubleEvenPlace(number));
            return (Card.sumOfOddPlace(number) + Card.sumOfDoubleEvenPlace(number)) % 10 == 0;
        }
        return false;
    }

    public static int sumOfDoubleEvenPlace(long number) {
        int[] tmp = new int[100];
        int i = 0;
        while (number / 10 != 0) {
            tmp[i++] = (int) (number % 10);
            number = number / 10;
        }
        tmp[i] = (int) (number % 10);
        int count = 0;
        for (int j = 1; j <= i; j += 2) {
            count += Card.getDigit(tmp[j] * 2);
        }
        return count;
    }

    public static int getDigit(int number) {
        return number < 10 ? number : number % 10 + number / 10;
    }

    public static int sumOfOddPlace(long number) {
        int[] tmp = new int[100];
        int i = 0;
        while (number / 10 != 0) {
            tmp[i++] = (int) (number % 10);
            number = number / 10;
        }
        tmp[i] = (int) (number % 10);
        int count = 0;
        for (int j = 0; j <= i; j += 2) {
            count += tmp[j];
        }
        return count;
    }

    public static boolean prefixMatched(long number, int d) {
        int dSize = Card.getSize(d);
        return Card.getPrefix(number, dSize) == d;
    }

    public static int getSize(long d) {
        int i = 1;
        while ((d = d / 10) != 0) {
            i++;
        }
        return i;
    }


    public static long getPrefix(long number, int k) {
        long res = 0;
        int[] tmp = new int[100];
        int i = 0;
        long newNum = number;
        while (number / 10 != 0) {
            tmp[i++] = (int) (number % 10);
            number = number / 10;
        }
        tmp[i] = (int) (number % 10);
        if (i + 1 < k) {
            return newNum;
        }
        for (int j = i; j > i - k; j--) {
            res = res * 10 + tmp[j];
        }
        return res;
    }

    public static void main(String[] args) {
        long a = 4388576018402626L;
        System.out.println(Card.isValid(a));

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的id卡号:");
        System.out.println("判断结果" + Card.isValid(scanner.nextLong()));
        scanner.close();

    }
}
