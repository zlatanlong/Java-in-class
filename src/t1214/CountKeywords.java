package t1214;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountKeywords {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Java source file: ");
//        String filename = input.nextLine();

        String filename = "D:\\code\\java\\test-in-class\\src\\t1214\\Ch21Q03_TestFile.java";

        File file = new File(filename);
        if (file.exists()) {
            // D:\code\java\test-in-class\src\t1214\Ch21Q03_TestFile.java
            System.out.println("The number of keywords in " + filename
                    + " is " + countKeywords(file));
        } else {
            System.out.println("File " + filename + " does not exist");
        }
    }

    public static int countKeywords(File file) throws Exception {
        String[] keywordString = {
                "abstract", "assert", "boolean", "break",
                "byte", "case", "catch", "char", "class",
                "const", "extends", "for", "final", "finally",
                "float", "goto", "if", "implements", "import",
                "instanceof", "int", "interface", "long",
                "native", "new", "package", "private", "protected",
                "public", "return", "short", "static", "strictfp",
                "super", "switch", "synchronized", "this", "throw",
                "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"
        };
        Set<String> keywordSet =
                new HashSet<>(Arrays.asList(keywordString));

        int count = 0;
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = null;
        while ((line = reader.readLine()) != null) {
            int flag = 0;
            int flag1 = 0;
            if ((line.length() > 2 && "/**".equals(line.substring(0, 3))) ||
                    (line.length() > 1 && "//".equals(line.substring(0, 2)))
                    || line.length() < 2) {
                continue;
            }
            String s = line.split("\\\\")[0];
            String[] tokens = s.split("[\\s(){}]");

            for (String token : tokens) {
                if (token.length() > 1) {
                    if ("/*".equals(token.substring(0, 2))) {
                        flag = 1;
                        continue;
                    } else if (token.contains("*/")) {
                        flag = 0;
                    }
                }
                if (token.length() > 1) {
                    if ("\"".equals(token.substring(0, 1))) {
                        flag1 = 1;
                        continue;
                    } else if (token.contains("\"")) {
                        flag1 = 0;
                    }
                }
                if (flag == 0 && flag1 == 0 && keywordSet.contains(token)) {
                    count++;
                    System.out.print(token + " ");
                }
            }

        }
//        Scanner input = new Scanner(file);
//        while(input.hasNext()){
//            String word = input.next();
//            if(keywordSet.contains(word)) {
//                count++;
//                System.out.print(word + " ");
//            }
//        }
        System.out.println();
        return count;
    }
}
