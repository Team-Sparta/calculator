package mainHomework.lv4.dataStructure;


import mainHomework.lv4.enums.SortedType;
import mainHomework.lv4.enums.SortingAlgorithmType;

import java.util.List;

public abstract class DataStructure {

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract boolean contains(Double value);

    public abstract void add(Double value);

    public abstract void removeLastElement();

    public abstract void clear();

    public abstract void sort(SortedType sortedType, SortingAlgorithmType sortingAlgorithmType);

    public abstract void print();

    public abstract List<Double> getResultsGreaterThan(double threshold);
}
