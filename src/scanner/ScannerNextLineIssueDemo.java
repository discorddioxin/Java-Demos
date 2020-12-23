package scanner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class ScannerNextLineIssueDemo {
    public static void main(String[] args) {
        Scanner textScanner = new Scanner("1 2.6 5 3.5 true 10.7 8");

        int intNumber = textScanner.nextInt();
        double doubleNumber = textScanner.nextDouble();
        byte byteNumber = textScanner.nextByte();
        float floatNumber = textScanner.nextFloat();
        boolean bool = textScanner.nextBoolean();
        BigDecimal bigDecimalNumber = textScanner.nextBigDecimal();
        BigInteger bigIntegerNumber = textScanner.nextBigInteger();

        printValues(intNumber, doubleNumber, byteNumber, floatNumber, bool, bigDecimalNumber, bigIntegerNumber);

        // All methods of Scanner work as intended
        // Scanner was designed to scan data. This includes files & strings (as shown above)
        // Even nextLine() works properly
        // But there is a "beginners trap" involved with it when using System.in with a console

//        Scanner consoleScanner = new Scanner(System.in); // very common for beginners
//
//
//        System.out.print("Type a short sentence: ");
//        String sentence1 = consoleScanner.nextLine();
//        System.out.println("You typed in: " + sentence1);
//
//        System.out.print("Type in a number: ");
//        int number = consoleScanner.nextInt();
//        System.out.println("You typed in: " + number);
//
//        System.out.print("Type a short sentence: ");
//        String sentence2 = consoleScanner.nextLine();
//        System.out.println("You typed in: " + sentence2);
//
//        System.out.println("Program finished!");

        /** RESULTS */

        // Type a short sentence: hi my name is
        // You typed in: hi my name is
        // Type in a number: 5
        // You typed in: 5
        // Type a short sentence: You typed in:
        // Program finished!

        // This program doesn't allow you to type the 2nd sentence. What happened?

        /** EXPLANATION */

        // To enter values into the console, you must press Enter
        // This adds a "line separator" character at the end of what you type in:

        // hi my name is
        // becomes
        // hi my name is\n

        // 5
        // becomes
        // 5\n

        /** This is how Scanner's "buffer" looks during that program's execution */

        //   [] <-- buffer, starts empty

        // Program prints "Enter sentence"
        // nextLine() waits for buffer to contain "line separator"; user enters sentence
        //   [hi my name is\n]
        // nextLine() finishes waiting, consumes everything up til \n
        //   []

        // Program prints "Enter number"
        // nextInt() waits for buffer to contain an integer; user enters integer:
        //   [5\n]
        // nextInt() finishes waiting, consumes everything up until the next non-number character
        //   [\n]

        // Program prints "Enter sentence"
        // nextLine() does NOT wait, buffer already contains line separator
        // nextLine() consumes everything up til \n

        // There are no other "next" calls - the 2nd sentence gets left in the buffer, and the program ends

        /** SOLUTIONS */

        // Understanding the problem, solutions become easier
        // Pressing Enter into the console adds a "new line"
        // We can either
        //   - Call nextLine() after every non-nextLine() call
        //   - Only use nextLine(), parsing the data as needed using Integer.parseInt and what not
        //   - Update the delimiter to always account for \n

        /** Remove the comment to run the solution */
        /** View the code of the method to see the solution's implementation */

        // callNextLineAfterAllCalls();
        // onlyUseNextLine();
        // changeDelimiter();
    }

    static void callNextLineAfterAllCalls() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a short sentence: ");

        String sentence1 = scanner.nextLine();

        System.out.println("You typed in: " + sentence1);
        System.out.print("Type in a number: ");

        int number = scanner.nextInt();
        scanner.nextLine(); // consumes extra \n

        System.out.println("You typed in: " + number);
        System.out.print("Type a short sentence: ");

        String sentence2 = scanner.nextLine();

        System.out.println("You typed in: " + sentence2);
        System.out.println("Program finished!");
    }

    static void onlyUseNextLine() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a short sentence: ");

        String sentence1 = scanner.nextLine();

        System.out.println("You typed in: " + sentence1);
        System.out.print("Type in a number: ");

        String asText = scanner.nextLine();
        int number = Integer.parseInt(asText); // can also do: int number = Integer.parseInt(scanner.nextLine());

        System.out.println("You typed in: " + number);
        System.out.print("Type a short sentence: ");

        String sentence2 = scanner.nextLine();

        System.out.println("You typed in: " + sentence2);
        System.out.println("Program finished!");
    }

    static void changeDelimiter() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        System.out.print("Type a short sentence: ");

        String sentence1 = scanner.nextLine();

        System.out.println("You typed in: " + sentence1);
        System.out.print("Type in a number: ");

        String asText = scanner.nextLine();
        int number = Integer.parseInt(asText); // can also do: int number = Integer.parseInt(scanner.nextLine());

        System.out.println("You typed in: " + number);
        System.out.print("Type a short sentence: ");

        String sentence2 = scanner.nextLine();

        System.out.println("You typed in: " + sentence2);
        System.out.println("Program finished!");
    }

    static void printValues(Object...values) {
        Arrays.stream(values).forEach(System.out::println);
    }
}
