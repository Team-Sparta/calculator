package mainHomework.lv4.utils.collection;

import mainHomework.lv4.utils.algorithm.searching.BinarySearch;
import mainHomework.lv4.utils.algorithm.sorting.MergeSort;
import mainHomework.lv4.utils.algorithm.sorting.QuickSort;
import mainHomework.lv4.utils.enums.SortedType;
import mainHomework.lv4.utils.enums.SortingAlgorithmType;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStructure implements DataStructure {

    List<Double> arrayList = new ArrayList<>();

    @Override
    public int size() {
        return this.arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    @Override
    public boolean contains(Double target) {
        return BinarySearch.search(this.arrayList, target) != -1;
    }

    @Override
    public void add(Double value) {
        this.arrayList.add(value);
    }

    @Override
    public void removeLastElement() {
        this.arrayList.remove(this.arrayList.size() - 1);
    }

    @Override
    public void clear() {
        this.arrayList.clear();
    }

    @Override
    public void sort(SortedType sortedType, SortingAlgorithmType sortingAlgorithmType) {
        if (sortingAlgorithmType == SortingAlgorithmType.QUICK) {
            QuickSort.sort(this.arrayList, 0, this.arrayList.size() - 1, sortedType);
        } else {
            MergeSort.sort(this.arrayList, 0, this.arrayList.size() - 1);
        }
    }

    @Override
    public void print() {
        System.out.println(this.arrayList);
    }

    @Override
    public List<Double> getResultsGreaterThan(double threshold) {
        return this.arrayList.stream()
                .filter(result -> result > threshold)
                .toList();
    }
}
