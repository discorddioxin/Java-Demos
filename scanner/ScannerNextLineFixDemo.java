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
public class ScannerNextLineFixDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(scanner.nextInt());
        scanner.nextLine();
        System.out.println(scanner.nextInt());
        scanner.nextLine();
        System.out.println(scanner.nextLine());

        // Calling `nextLine()` after non-`nextLine()` calls fixes the issue
        // "Hello World" will print
    }
}
