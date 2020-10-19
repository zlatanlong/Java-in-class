package t1019;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/19 8:35
 */
public class PhoneKeyBoard {


    public static final char[][] keyBoard = new char[][]{
            {'0', ' '},
            {'1'},
            {'2', 'a', 'b', 'c'},
            {'3', 'd', 'e', 'f'},
            {'4', 'g', 'h', 'i'},
            {'5', 'j', 'k', 'l'},
            {'6', 'm', 'n', 'o'},
            {'7', 'p', 'q', 'r', 's'},
            {'8', 't', 'u', 'v'},
            {'9', 'w', 'x', 'y', 'z'},
    };

    public String getNumStr(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < chars.length; m++) {
            for (int i = 0; i < keyBoard.length; i++) {
                for (int j = 0; j < keyBoard[i].length; j++) {
                    if (keyBoard[i][j] == chars[m]) {
                        for (int k = 1; k <= j + 1; k++) {
                            sb.append(keyBoard[i][0]);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        PhoneKeyBoard phoneKeyBoard = new PhoneKeyBoard();
        System.out.println(phoneKeyBoard.getNumStr("covid 2019 is american virus"));
        System.out.println(phoneKeyBoard.getNumStr("hello 123"));
    }

}
