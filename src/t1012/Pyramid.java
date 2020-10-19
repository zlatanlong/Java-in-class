package t1012;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/12 7:57
 */
public class Pyramid {


    public void printPyramid(long count) {
        long max = (long) Math.pow(2, count - 1);
        int size = 1;
        System.out.println(max);
        while ((max = max / 10) != 0) {
            size++;
        }
        System.out.println(size);
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i; j++) {
                System.out.printf("%" + size + "s", "");
                System.out.print("\t");
            }
            for (int j = 0; j < i; j++) {
                System.out.printf("%" + size + "s", (long) Math.pow(2, j));
                System.out.print("\t");
            }
            for (int j = i; j >= 0; j--) {
                System.out.printf("%" + size + "s", (long) Math.pow(2, j));
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入层数：");
//        long count = 0;
//        while (true) {
//            String str = scanner.next();
//            for (int i = 0; i < str.length(); i++) {
//                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
//                    System.out.println("格式有误！");
//                    continue;
//                }
//            }
//            count = Integer.parseInt(str);
//            break;
//        }
//        new Pyramid().printPyramid(count);
        double a = Math.pow(2, 63);
        double c = Math.pow(2, 1);
        Double b = new Double(a);
        System.out.println(Long.toBinaryString(Double.doubleToRawLongBits(b)));
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(c)));
        System.out.println(Double.toHexString(a-1));
//        System.out.println(a == a - 1);
    }
}
