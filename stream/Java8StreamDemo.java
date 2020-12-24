package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StreamDemo {
    public static void main(String[] args) {
        // Streams can be used to easily create a list of filtered words

        List<String> words = Arrays.asList("these", "are", "some", "words");

        List<String> filteredWords = words.stream()
                .filter(word -> word.endsWith("e")) // Filters for only words ending in "e"
                .collect(Collectors.toList()); // Puts the filtered elements into a list

        // Streams are made up of "intermediate" and "terminal" operations
        // The actions of the stream do not execute until a terminal operation occurs
        // By looking at the docs for filter, we can see it's an intermediate operation
        //   https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#filter-java.util.function.Predicate-
        // collect is a terminal operation
        // Once a terminal operation occurs, each element is sent through the stream 1 by 1.

        filteredWords.stream()
                .map(word -> word.toUpperCase()) // intermediate
                .forEach(word -> System.out.println(word)); // terminal

        // The map function transforms one value into another
        // There also exists mapToInt for mapping to a primitive

        filteredWords.stream()
                .mapToInt(word -> word.length())
                .forEach(length -> System.out.println(length));

        // We can chain together intermediate operations, making operating on collections easy
        // Below shows all the operations above handled by a single stream pipeline, plus more

        words.stream()
                .filter(word -> word.endsWith("e"))
                .map(word -> word.toUpperCase())
                .mapToInt(word -> word.length())
                .forEach(length -> System.out.println(length));

        // You can stream over an array using Arrays.stream

        String[] array = { "these", "are", "values", "bud" };

        Arrays.stream(array)
                .filter(word -> word.length() < 4)
                .forEach(word -> System.out.println(word));

        // It's common to use method references to improve readability when possible

        words.stream()
                .filter(word -> word.endsWith("e"))
                .map(String::toUpperCase) // make uppercase
                .mapToInt(String::length) // start focusing on length instead of the words
                .forEach(System.out::println); // print each length
    }
}
