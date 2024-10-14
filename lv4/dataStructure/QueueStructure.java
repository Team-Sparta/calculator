package mainHomework.lv4.dataStructure;

import mainHomework.lv4.algorithm.QuickSort;
import mainHomework.lv4.enums.SortedType;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class QueueStructure extends DataStructure {
    Deque<Double> queue = new ArrayDeque<>();

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(Double value) {
        return queue.contains(value);
    }

    @Override
    public void add(Double value) {
        queue.add(value);
    }

    @Override
    public void removeLastElement() {
        queue.removeLast();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public void sort(SortedType sortedType) {
        List<Double> sortedArray = QuickSort.sort(queue.stream().toList(), 0, queue.size(), sortedType);
        clear();
        queue.addAll(sortedArray);
    }

    @Override
    public void print() {
        System.out.println(queue);
    }

    @Override
    public List<Double> getResultsGreaterThan(double threshold) {
        return queue.stream().filter(result -> result > threshold).toList();
    }
}
