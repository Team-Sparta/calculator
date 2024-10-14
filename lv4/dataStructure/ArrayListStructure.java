package mainHomework.lv4.dataStructure;

import mainHomework.lv4.algorithm.BinarySearch;
import mainHomework.lv4.algorithm.QuickSort;
import mainHomework.lv4.enums.SortedType;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStructure extends DataStructure {

    List<Double> arrayList = new ArrayList<>();

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public boolean contains(Double target) {
        return BinarySearch.search(arrayList, target) != -1;
    }

    @Override
    public void add(Double value) {
        arrayList.add(value);
    }

    @Override
    public void removeLastElement() {
        arrayList.remove(arrayList.size() - 1);
    }

    @Override
    public void clear() {
        arrayList.clear();
    }

    @Override
    public void sort(SortedType sortedType) {
        QuickSort.sort(arrayList, 0, arrayList.size() - 1, sortedType);
    }

    @Override
    public void print() {
        System.out.println(arrayList);
    }

    @Override
    public List<Double> getResultsGreaterThan(double threshold) {
        return arrayList.stream()
                .filter(result -> result > threshold)
                .toList();
    }
}
