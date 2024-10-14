package mainHomework.lv4.dataStructure;

import mainHomework.lv4.algorithm.QuickSort;
import mainHomework.lv4.enums.DataStructureType;
import mainHomework.lv4.enums.SortedType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetStructure extends DataStructure {
    Set<Double> hashSet = new HashSet<>();

    @Override
    public int size() {
        return hashSet.size();
    }

    @Override
    public boolean isEmpty() {
        return hashSet.isEmpty();
    }

    @Override
    public boolean contains(Double value) {
        return hashSet.contains(value);
    }

    @Override
    public void add(Double value) {
        hashSet.add(value);
    }

    @Override
    public void removeLastElement() {
        Double lastElement = null;
        for (Double aDouble : hashSet) {
            lastElement = aDouble;
        }
        if (lastElement != null) {
            hashSet.remove(lastElement);
        }
    }

    @Override
    public void clear() {
        hashSet.clear();
    }

    @Override
    public void sort(SortedType sortedType) {
        List<Double> sortedArray = QuickSort.sort(hashSet.stream().toList(), 0, hashSet.size(), sortedType);
        hashSet = new HashSet<>(sortedArray);
    }

    @Override
    public void print() {
        System.out.println("HashSetStructure: " + hashSet);
    }

    @Override
    public List<Double> getResultsGreaterThan(double threshold) {
        return hashSet.stream().filter(result -> result > threshold)
                .toList();
    }
}
