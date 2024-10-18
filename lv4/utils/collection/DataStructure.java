package mainHomework.lv4.utils.collection;


import mainHomework.lv4.utils.enums.SortedType;
import mainHomework.lv4.utils.enums.SortingAlgorithmType;

import java.util.List;

public interface DataStructure {

    int size();

    boolean isEmpty();

    boolean contains(Double value);

    void add(Double value);

    void removeLastElement();

    void clear();

    void sort(SortedType sortedType, SortingAlgorithmType sortingAlgorithmType);

    void print();

    List<Double> getResultsGreaterThan(double threshold);
}
