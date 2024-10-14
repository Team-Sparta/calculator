package mainHomework.lv4.dataStructure;

import mainHomework.lv4.algorithm.MergeSort;
import mainHomework.lv4.algorithm.QuickSort;
import mainHomework.lv4.enums.SortedType;
import mainHomework.lv4.enums.SortingAlgorithmType;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class QueueStructure extends DataStructure {
    Deque<Double> queue = new ArrayDeque<>();

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public boolean contains(Double value) {
        return this.queue.contains(value);
    }

    @Override
    public void add(Double value) {
        this.queue.add(value);
    }

    @Override
    public void removeLastElement() {
        this.queue.removeLast();
    }

    @Override
    public void clear() {
        this.queue.clear();
    }

    @Override
    public void sort(SortedType sortedType, SortingAlgorithmType sortingAlgorithmType) {
        List<Double> tempList = this.queue.stream().toList();
        switch (sortingAlgorithmType) {
            case MERGE -> MergeSort.sort(tempList, 0, this.queue.size() - 1);
            case QUICK -> QuickSort.sort(tempList, 0, this.queue.size() - 1, sortedType);
        }
        clear();
        this.queue.addAll(tempList);
    }

    @Override
    public void print() {
        System.out.println(this.queue);
    }

    @Override
    public List<Double> getResultsGreaterThan(double threshold) {
        return this.queue.stream().filter(result -> result > threshold).toList();
    }
}
