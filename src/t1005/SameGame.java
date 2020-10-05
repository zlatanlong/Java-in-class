package t1005;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/5 7:48
 */
public class SameGame {

    public int[] getNumsByInput(Scanner scanner, String str) {
        String inputStr;
        int[] res = new int[4];
        while (true) {
            System.out.println("*****请输入" + str + "*****");
            inputStr = scanner.next();
            if (inputStr.length() != 4) {
                System.out.println("----请输入四位数字!----");
                continue;
            }
            char[] chars = inputStr.toCharArray();
            int i;
            for (i = 0; i < chars.length; i++) {
                if (chars[i] < '0' || chars[i] > '9') {
                    System.out.println("----您的输入含有其他字符!----");
                    break;
                }
                res[i] = chars[i] - '0';
            }
            if (i == 4) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SameGame game = new SameGame();
        Scanner scanner = new Scanner(System.in);
        int[] oriNums = game.getNumsByInput(scanner, "原始数字");
        System.out.print("作弊：");
        Arrays.stream(oriNums).forEach(System.out::print);
        System.out.println();

        int count = 0;
        while (true) {
            count++;
            int[] guessArray = game.getNumsByInput(scanner, "您猜的");

            int a = 0, b = 0;
            int[] tmpArr = Arrays.copyOf(oriNums, oriNums.length);
            for (int i = 0; i < guessArray.length; i++) {
                if (guessArray[i] == oriNums[i]) {
                    a++;
                    guessArray[i] = -1;
                    tmpArr[i] = -1;
                }
            }
            for (int i = 0; i < guessArray.length; i++) {
                if (guessArray[i] != -1) {
                    for (int j = 0; j < tmpArr.length; j++) {
                        if (tmpArr[j] != -1 && tmpArr[j] == guessArray[i]) {
                            b++;
                            guessArray[i] = -1;
                            tmpArr[j] = -1;
                        }
                    }
                }
            }
            System.out.println(a + "A" + b + "B");
            if (a == 4) {
                System.out.println("success!您一共输入了" + count + "次");
                break;
            }
        }
    }
}
