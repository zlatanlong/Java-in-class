package t0928;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {
    public int[] getRandom() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < 4) {
            set.add((int) (Math.random() * 10));
        }
        return set.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Game game = new Game();
        int[] random = game.getRandom();
        Scanner scanner = new Scanner(System.in);
        System.out.print("作弊：");
        Arrays.stream(random).forEach(System.out::print);
        System.out.println();
        while (true) {
            System.out.println("请输入您猜的数字：");
            String guess = scanner.next();

            if (guess.length()!=4) {
                System.out.println("输入的有误！");
                continue;
            }
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < guess.length(); i++) {
                set.add(guess.charAt(i));
            }
            if (set.size()!=4) {
                System.out.println("输入的有重复！");
                continue;
            }

            int[] guessArray = new int[4];
            System.out.println(guess);
            for (int i = 0; i < guessArray.length; i++) {
                guessArray[i] = (int) guess.charAt(i) - '0';
            }

            int a = 0, b = 0;
            for (int i = 0; i < guessArray.length; i++) {
                if (guessArray[i] == random[i]) {
                    a++;
                    continue;
                }
                if (Arrays.stream(random).boxed().collect(Collectors.toList()).contains(guessArray[i])) {
                    b++;
                }
            }
            System.out.println(a + "A" + b + "B");
            if (a == 4) {
                System.out.println("nb!");
                break;
            }
        }

    }

}
