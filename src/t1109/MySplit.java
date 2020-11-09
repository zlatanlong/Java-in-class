package t1109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: zlatanlong
 * @Date: 2020/11/9 8:12
 */
public class MySplit {

    public static String[] split(String s,String regex) {
        List<String> res = new ArrayList<>();
        char[] tarArr;
        if (regex.length() == 1) {
            tarArr = new char[1];
            tarArr[0] = regex.charAt(0);
        } else {
            tarArr = new char[regex.length()-2];
            for (int i = 0; i < tarArr.length; i++) {
                tarArr[i] = regex.charAt(i+1);
            }
        }
        int start = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            if (ifCharInAnotherCharArr(s.charAt(i),tarArr)) {
                if(i==0)
                    res.add("");
                res.add(s.substring(start,i));
                res.add(s.substring(i,i+1));
                start = i+1;
            }
        }
        if (start<=s.length()-1)
            res.add(s.substring(start,i));
        else
            res.add("");
        return res.toArray(new String[0]);
    }

    public static boolean ifCharInAnotherCharArr(char c, char[] cs) {
        for (char c1 : cs) {
            if (c1==c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] split = MySplit.split("ab##453#", "#");
        Arrays.stream(split).forEach((str)->{System.out.print(str+"|");});

        System.out.println();
        String[] split2 = MySplit.split("###", "#");
        Arrays.stream(split2).forEach((str)->{System.out.print(str+"|");});

        System.out.println();
        String[] split3 = MySplit.split("ab?#12?453#?", "[?#]");
        Arrays.stream(split3).forEach((str)->{System.out.print(str+"|");});
    }
}
