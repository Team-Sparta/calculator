package mainHomework.lv4;

import java.util.List;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class QuickSort {

    public static void sort(List<Double> list, int low, int high) {
        if (low < high) {
            int pivotIndex = medianOfThree(list, low, high);
            // Move pivot to the end
            Collections.swap(list, pivotIndex, high);

            // Find the partition index
            int pi = partition(list, low, high);

            // Recursively sort the left and right sublists
            sort(list, low, pi - 1);
            sort(list, pi + 1, high);
        }
    }

    private static int partition(List<Double> list, int low, int high) {
        // Choose the rightmost element as pivot
        Double pivot = list.get(high);

        // Index of smaller element
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (list.get(j) <= pivot) {
                i++;
                // Swap list.get(i) and list.get(j)
                Collections.swap(list, i, j);
            }
        }

        // Swap list.get(i+1) and list.get(high) (or pivot)
        Collections.swap(list, i + 1, high);

        return i + 1;
    }

    private static int medianOfThree(List<Double> list, int low, int high) {
        int mid = low + (high - low) / 2;
        if (list.get(low) > list.get(mid)) Collections.swap(list, low, mid);
        if (list.get(low) > list.get(high)) Collections.swap(list, low, high);
        if (list.get(mid) > list.get(high)) Collections.swap(list, mid, high);
        return mid;
    }


    // Utility method to print a list
    public static void printList(List<Double> list) {
        for (Double value : list) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method to test the QuickSort implementation
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(List.of(64.0, 34.5, 25.0, 12.2, 22.7, 11.1, 90.3));
        System.out.println("Original list:");
        printList(list);

        sort(list, 0, list.size() - 1);

        System.out.println("Sorted list:");
        printList(list);
    }
}