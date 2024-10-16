package mainHomework.lv4.utils.algorithm.searching;

import java.util.ArrayList;
import java.util.Collections; // Import for sorting
import java.util.List;
import java.util.Objects;

public class BinarySearch {

    public static int search(List<Double> arr, Double target) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
//            int mid = (left + right) / 2;
            int mid = left + (right - left) / 2;
            if (Objects.equals(arr.get(mid), target)) {
                return mid;
            } else if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Double> arr = new ArrayList<>();
        arr.add(1.0);
        arr.add(23.0);
        arr.add(5.0);
        arr.add(33.0);
        arr.add(93.0);
        arr.add(42.0);
        arr.add(12.0);

        // Sort the array before performing binary search
        Collections.sort(arr);

        // Print the sorted array for reference
        System.out.println("Sorted array: " + arr);

        int result = search(arr, 5.0);

        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}