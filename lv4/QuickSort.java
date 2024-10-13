package mainHomework.lv4;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class QuickSort {

    // Overloaded method that provides default value for 'desc' as false
    public static void sort(List<Double> list, int low, int high) {
        sort(list, low, high, false);  // Default value for 'desc' is false (ascending order)
    }

    // Main sort method with 'desc' parameter
    public static void sort(List<Double> list, int low, int high, boolean desc) {
        while (low < high) {
            int pivotIndex = medianOfThree(list, low, high);
            Collections.swap(list, pivotIndex, high); // Move pivot to the end

            int pi = partition(list, low, high, desc); // Partition based on 'desc'

            // Recursively sort the smaller partition and loop on the larger one to reduce recursion depth
            if (pi - low < high - pi) {
                sort(list, low, pi - 1, desc);  // Sort left part (smaller one)
                low = pi + 1;                  // Continue sorting right part (larger one) in the loop
            } else {
                sort(list, pi + 1, high, desc); // Sort right part (smaller one)
                high = pi - 1;                 // Continue sorting left part (larger one) in the loop
            }
        }
    }

    private static int partition(List<Double> list, int low, int high, boolean desc) {
        Double pivot = list.get(high);  // Choose the rightmost element as pivot
        int i = low;

        for (int j = low; j < high; j++) {
            if ((desc && list.get(j) >= pivot) || (!desc && list.get(j) <= pivot)) {
                Collections.swap(list, i, j);
                i++;
            }
        }

        Collections.swap(list, i, high); // Move pivot to the correct location
        return i;
    }

    // Method to find median of three and reduce worst-case scenario probability
    private static int medianOfThree(List<Double> list, int low, int high) {
        int mid = low + (high - low) / 2;
        if (list.get(low) > list.get(mid)) Collections.swap(list, low, mid);
        if (list.get(low) > list.get(high)) Collections.swap(list, low, high);
        if (list.get(mid) > list.get(high)) Collections.swap(list, mid, high);
        return mid;
    }

    // Utility method to print a list
    public static void printList(List<Double> list) {
        list.forEach(value -> System.out.print(value + " "));
        System.out.println();
    }

    // Main method to test the QuickSort implementation
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(List.of(64.0, 34.5, 25.0, 12.2, 22.7, 11.1, 90.3));
        System.out.println("Original list:");
        printList(list);

        // Sort in ascending order (default)
        sort(list, 0, list.size() - 1);
        System.out.println("Sorted list (ascending order):");
        printList(list);

        // Sort in descending order
        sort(list, 0, list.size() - 1, true);
        System.out.println("Sorted list (descending order):");
        printList(list);
    }
}