package t1026;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/26 8:30
 */
public class Palindromic {
    public boolean valid(long num) {
        //素数
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        //回文数
        char[] c = String.valueOf(num).toCharArray();
        int start = 0;
        int end = c.length - 1;

        while (start <= end) {
            if (c[start++] != c[end--]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Palindromic palindromic = new Palindromic();
        int count = 0;
        long[] res = new long[100];
        long num = 1;
        while (count != 100) {
            num++;
            while (!palindromic.valid(num)) {
                num++;
            }
            res[count++] = num;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%" + 6 + "s", res[i * 10 + j] + "\t");
            }
            System.out.println();
        }

    }


}
