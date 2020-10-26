package t1026;

import java.util.Scanner;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/26 7:49
 */
public class Game {

    private String[] strs;
    private String curStr;
    private char[] guessStore;
    private int arrIndex;
    private final int maxArrLength = 100;
    private int missTime;

    public Game() {
        this.strs = new String[]{"banana", "telecommunication", "programming", "bupt"};
        resetGame();
    }

    public void resetGame() {
        this.curStr = strs[(int) (Math.random() * (strs.length - 1))];
        System.out.println("----作弊：生成字符串：" + curStr + "-----");
        this.missTime = 0;
        this.arrIndex = 0;
        this.guessStore = new char[maxArrLength];
    }

    public boolean validIsOverAndShowTips() {
        char[] show = curStr.toCharArray();
        int isHasXingFlag = 0;
        for (int i = 0; i < curStr.length(); i++) {
            int flag = 0;
            for (char c1 : guessStore) {
                if (c1 == curStr.charAt(i)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                show[i] = '*';
                isHasXingFlag = 1;
            }
        }

        if (isHasXingFlag!=1) {
            System.out.println("The word is " + curStr + ". You missed " + missTime + " time");
            return true;
        }
        System.out.print("(Guess) Enter a letter in word " + String.valueOf(show) + " > ");
        return false;
    }

    public void guess(char c) {
        // 1. 验证是否猜过
        int flag = 0;
        for (char value : guessStore) {
            if (value == c) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println(c + " is already in the word");
            missTime++;
        }

        flag = 0;
        for (int i = 0; i < curStr.length(); i++) {
            if (curStr.charAt(i) == c) {
                flag = 1;
                break;
            }
        }
        // 2. 验证是否在字符串中存在
        if (flag == 0) {
            System.out.println(c + " is not in the word");
            missTime++;
        } else {
            if (arrIndex < maxArrLength - 1) {
                guessStore[arrIndex++] = c;
            }
        }

    }


    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            while (!game.validIsOverAndShowTips()) {
                String s = scanner.next();
                if (s.length() != 1) {
                    System.out.println("---输入格式不对---");
                    continue;
                }
                game.guess(s.charAt(0));
            }
            System.out.print("Do you want to guess another word? Enter y or n");
            String s = scanner.next();
            if (s.length() != 1) {
                System.out.println("---输入格式不对---");
                continue;
            }
            if (s.charAt(0) == 'n') {
                break;
            } else if (s.charAt(0) != 'y') {
                System.out.println("---输入格式不对---");
            }
            game.resetGame();
        }
    }
}
