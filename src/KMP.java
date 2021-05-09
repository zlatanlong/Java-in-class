/**
 * @Author: zlatanlong
 * @Date: 2021/4/20 9:25
 */
public class KMP {
    public static int kmp(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        int n = ss.length(), m = pp.length();
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        int[] next = new int[m + 1];

        /**
         * 下面两个过程很像，求next其实就是自己和自己匹配，
         * 无论如何 匹配失败 j=next[j];
         * 失败条件是(j > 0 && 数组[i] != p[j + 1])
         * 成功时将j向前移
         * 每次都要进行的是：
         *  求next： 对next数组进行赋值
         *  匹配： 判断是否匹配
         *  i++： 这一步在for循环中进行
         *
         * 求next自己与自己匹配，只有1位时不考虑，所以i从2开始
         * 匹配时 i 从 1开始
         *
         */


        // 求next过程
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }

        // 匹配过程
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == m) return i - m;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(KMP.kmp("abeababeabf", "abeabf"));
    }
}
