package mainHomework.lv4.utils.algorithm.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    // Main function that sorts the list using merge sort
    public static void sort(List<Double> list, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = left + (right - left) / 2;

            // Sort first half
            sort(list, left, middle);

            // Sort second half
            sort(list, middle + 1, right);

            // Merge the sorted halves
            merge(list, left, middle, right);
        }
    }

    // Merges two sublists of list.
    // First sublist is list[left..middle]
    // Second sublist is list[middle+1..right]
    private static void merge(List<Double> list, int left, int middle, int right) {
        // Sizes of the two sublists
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Temporary sublists
        List<Double> leftList = new ArrayList<>(n1);
        List<Double> rightList = new ArrayList<>(n2);

        // Copy data to temp sublists
        for (int i = 0; i < n1; ++i) {
            leftList.add(list.get(left + i));
        }
        for (int j = 0; j < n2; ++j) {
            rightList.add(list.get(middle + 1 + j));
        }

        // Initial indexes of first and second sublists
        int i = 0, j = 0;

        // Initial index of the merged sublist
        int k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i) <= rightList.get(j)) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftList
        while (i < n1) {
            list.set(k, leftList.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of rightList
        while (j < n2) {
            list.set(k, rightList.get(j));
            j++;
            k++;
        }
    }

    // Utility function to print list
    public void printList(List<Double> list) {
        System.out.println(list);
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        List<Double> list = new ArrayList<>();
        list.add(12.3);
        list.add(11.1);
        list.add(13.7);
        list.add(5.9);
        list.add(6.4);
        list.add(7.2);

        System.out.println("Given List");
        mergeSort.printList(list);

        mergeSort.sort(list, 0, list.size() - 1);

        System.out.println("\nSorted List");
        mergeSort.printList(list);
    }
}