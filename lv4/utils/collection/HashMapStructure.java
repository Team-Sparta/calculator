package mainHomework.lv4.utils.collection;

import mainHomework.lv4.utils.algorithm.sorting.MergeSort;
import mainHomework.lv4.utils.algorithm.sorting.QuickSort;
import mainHomework.lv4.utils.enums.SortedType;
import mainHomework.lv4.utils.enums.SortingAlgorithmType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapStructure extends DataStructure {
    Map<Integer, Double> hashMap = new HashMap<>();
    private int keyCounter = 0;

    @Override
    public int size() {
        return this.hashMap.size();
    }

    @Override
    public boolean isEmpty() {
        return this.hashMap.isEmpty();
    }

    @Override
    public boolean contains(Double value) {
        return this.hashMap.containsValue(value);
    }

    @Override
    public void add(Double value) {
        this.hashMap.put(keyCounter++, value);
    }

    @Override
    public void removeLastElement() {
        if (!this.hashMap.isEmpty()) {
            Integer lastKey = keyCounter - 1;
            this.hashMap.remove(lastKey);
            keyCounter--;
        }
    }

    @Override
    public void clear() {
        this.hashMap.clear();
        keyCounter = 0;
    }

    @Override
    public void sort(SortedType sortedType, SortingAlgorithmType sortingAlgorithmType) {
        List<Map.Entry<Integer, Double>> entries = this.hashMap.entrySet().stream().toList();
        List<Double> values = entries.stream().map(Map.Entry::getValue).toList();

        switch (sortingAlgorithmType) {
            case MERGE -> MergeSort.sort(values, 0, values.size() - 1);
            case QUICK -> QuickSort.sort(values, 0, values.size() - 1, sortedType);
        }

        this.hashMap.clear();

        for (int i = 0; i < values.size(); i++) {
            this.hashMap.put(i, values.get(i));
        }
        keyCounter = values.size();
    }

    @Override
    public void print() {
        System.out.println("HashMapStructure: " + this.hashMap);
    }

    @Override
    public List<Double> getResultsGreaterThan(double threshold) {
        return this.hashMap.values().stream()
                .filter(value -> value > threshold)
                .collect(Collectors.toList());
    }
}