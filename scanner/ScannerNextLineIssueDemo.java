package scanner;

import java.util.Scanner;

/**
 * Enter into console (one value at a time):
 *
 * 1
 * 2
 * Hello World
 *
 */
public class ScannerNextLineIssueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextLine());

        // Will exit after entering 2nd number
        // "Hello World" will not print
    }
}