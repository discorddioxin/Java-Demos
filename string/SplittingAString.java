package string;

import java.util.Arrays;

public class SplittingAString {
    public static void main(String[] args) {
        String basicText = "This is basic text";

        // Grab each word (split by space)
        String[] words = basicText.split(" ");

        // Printing the results
        printResults(basicText, words, " ");

        // The "delimiter" (space) will not be in the results
        // We can change the delimiter
        String[] words2 = basicText.split(" basic ");
        printResults(basicText, words2, " basic ");


        // Regular Expressions (regex) are used to specify complex delimiters
        String sentence = "This is a sentence, I hope you like it.";

        // To grab only words from a sentence, we must split by space. But punctuation will still exist
        // We can take advantage of how split removes delimiters from the result
        // Regex allows us to easily specify all 3: space or comma or period
        String[] words3 = sentence.split("[ ,.]");
        printResults(sentence, words3, "[ ,.]");

        // The punctuation is gone, but there is an empty Strings in the results (after "sentence", before "I")
        // It's safer to "clean" data as much as possible before processing it
        // In this case, we can use the replaceAll method to remove punctuation before splitting
        // replaceAll supports regex too
        String cleanSentence = sentence.replaceAll("[,.]", "");
        String[] words4 = cleanSentence.split(" ");
        printResults(cleanSentence, words4, " ");
    }

    static void printResults(String original, String[] results, String delimiter) {
        System.out.printf("Original:\t%s\nDelimiter:\t%s\nResult:\t\t%s\n\n", original, delimiter, Arrays.toString(results).replaceAll(", ", ","));
    }
}
