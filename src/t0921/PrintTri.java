package t0921;

import java.util.Scanner;

public class PrintTri {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;
        count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        scanner.close();
    }
}
