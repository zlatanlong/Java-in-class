package t0928;

import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入金字塔层数(0~15)：");
        int count = scanner.nextInt();
        while (count > 15 || count < 1) {
            System.out.println("您输入的有误，请重新输入！");
            count = scanner.nextInt();
        }

        for (int i = 1; i <= count; i++) {
            for (int j = 0; j < count -i; j++) {
                System.out.print("\t");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j+10);
            }
            for (int j = 2; j <= i-1; j++) {
                System.out.print(j+"\t");
            }
            if (i>1) {
            System.out.print(i);
            }
            System.out.println();
        }

    }
}
