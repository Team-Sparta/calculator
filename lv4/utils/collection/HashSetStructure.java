package mainHomework.lv4.utils.collection;

import mainHomework.lv4.utils.algorithm.sorting.MergeSort;
import mainHomework.lv4.utils.algorithm.sorting.QuickSort;
import mainHomework.lv4.utils.enums.SortedType;
import mainHomework.lv4.utils.enums.SortingAlgorithmType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetStructure implements DataStructure {
    Set<Double> hashSet = new HashSet<>();

    @Override
    public int size() {
        return this.hashSet.size();
    }

    @Override
    public boolean isEmpty() {
        return this.hashSet.isEmpty();
    }

    @Override
    public boolean contains(Double value) {
        return this.hashSet.contains(value);
    }

    @Override
    public void add(Double value) {
        this.hashSet.add(value);
    }

    @Override
    public void removeLastElement() {
        Double lastElement = null;
        for (Double aDouble : this.hashSet) {
            lastElement = aDouble;
        }
        if (lastElement != null) {
            this.hashSet.remove(lastElement);
        }
    }

    @Override
    public void clear() {
        this.hashSet.clear();
    }

    @Override
    public void sort(SortedType sortedType, SortingAlgorithmType sortingAlgorithmType) {
        List<Double> tempList = this.hashSet.stream().toList();
        switch (sortingAlgorithmType) {
            case MERGE -> MergeSort.sort(tempList, 0, this.hashSet.size() - 1);
            case QUICK -> QuickSort.sort(tempList, 0, this.hashSet.size() - 1, sortedType);
        }
        this.hashSet = new HashSet<>(tempList);
    }

    @Override
    public void print() {
        System.out.println("HashSetStructure: " + this.hashSet);
    }

    @Override
    public List<Double> getResultsGreaterThan(double threshold) {
        return this.hashSet.stream().filter(result -> result > threshold)
                .toList();
    }
}
