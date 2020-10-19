package t1012;

import java.util.Scanner;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/12 7:47
 */
public class ISBN {


    public boolean getISBN(String str) {
        if (str.length() != 9) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
            count += (i + 1) * ((int) str.charAt(i) - '0');
        }
        String jyh = count % 11 == 10 ? "X" : String.valueOf(count % 11);
        System.out.println("The ISBN number is " + str + jyh);
        return true;
    }

    public static void main(String[] args) {
        ISBN isbn = new ISBN();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the first 9 digits of an ISBN as Integer:");
            if (isbn.getISBN(scanner.next())) {
                break;
            } else {
                System.out.println("Incorrect input format!");
            }
        }
    }
}
