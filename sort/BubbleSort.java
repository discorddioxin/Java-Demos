package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);

        for(int i = 0; i < 10; i++) {
            List<Integer> copy = new ArrayList<>(numbers);
            Collections.shuffle(copy);

            Integer[] selectionSet = copy.toArray(new Integer[0]);
            Integer[] bubbleSet = copy.toArray(new Integer[0]);

            System.out.println("Data Set:\n" + copy.toString());
            bubbleSort(bubbleSet);
            selectionSort(selectionSet);
            System.out.println();
        }

        Integer[] num = new Integer[] { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
        System.out.println("Data Set:\n" + Arrays.toString(num));
        bubbleSort(num);
        num = new Integer[] { 8, 2, 3, 4, 5, 6, 7, 1 };
        selectionSort(num);
    }

    static void bubbleSort(Integer[] numbers) {
        int swaps = 0;

        for(int i = 1; i < numbers.length; i++) {
            int left = numbers[i - 1];
            int right = numbers[i];

            if(left > right) {
                swap(numbers, i - 1, i);
                swaps++;
            }
        }
        System.out.println("Bubble Swaps: " + swaps);
    }

    static void selectionSort(Integer[] numbers) {
        int swaps = 0;

        for(int i = 0; i < numbers.length; i++) {
            int indexOfLowest = i;

            for(int j = i + 1; j < numbers.length; j++) {
                int currentLowest = numbers[indexOfLowest];
                int nextNumber = numbers[j];

                if(nextNumber < currentLowest)
                    indexOfLowest = j;
            }

            swap(numbers, i, indexOfLowest);
            swaps++;
        }
        System.out.println("Selection Swaps: " + swaps);
    }

    static void badSelectionSort(Integer[] numbers) {
        int swaps = 0;

        for(int i = 0; i < numbers.length; i++) {
            int indexOfLowest = i;

            for(int j = i + 1; j < numbers.length; j++) {
                int currentLowest = numbers[indexOfLowest];
                int nextNumber = numbers[j];

                if(nextNumber < currentLowest) {
                    swap(numbers, i, j);
                    swaps++;
                }
            }

        }
        System.out.println("Jesus Swaps: " + swaps);
    }

    static void swap(Integer[] numbers, int index, int otherIndex) {
        int temp = numbers[index];
        numbers[index] = numbers[otherIndex];
        numbers[otherIndex] = temp;
    }
}
