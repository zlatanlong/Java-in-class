import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Integer a = 1000;
        Integer b = 1000;
        String hello = "";
        Scanner scanner = new Scanner(System.in);
//        hello = scanner.nextLine();
        // System.out.println(a == b);
        // System.out.println(hello);
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("java.library.path"));
        scanner.close();
    }
}
