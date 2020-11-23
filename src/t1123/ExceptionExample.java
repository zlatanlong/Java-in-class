package t1123;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: zlatanlong
 * @Date: 2020/11/23 7:54
 */
public class ExceptionExample {


    public static void main(String[] args) {
        try {
            int[] array = new int[5];
            int boom = array[10];
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException | " + e.getMessage());
        }

        try {
            System.out.println(1 / 0);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException | " + e.getMessage());
        }

        try {
            Map map = null;
            System.out.println(map.get(0));
        } catch (NullPointerException e) {
            System.out.println("NullPointerException | " + e.getMessage());
        }

        try {
            Integer pid=Integer.parseInt("hhh");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException | " + e.getMessage());
        }

        try {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException | " + e.getMessage());
        }


    }
}
