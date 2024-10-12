package mainHomework.lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {

    List<Double> resultList = new ArrayList<>();

    public <T extends Number> Double calculate(T firstNumber, T secondNumber, OperatorType operator) {
        Double result = switch (operator) {
            case ADDITION -> firstNumber.doubleValue() + secondNumber.doubleValue();
            case SUBTRACT -> firstNumber.doubleValue() - secondNumber.doubleValue();
            case MULTIPLY -> firstNumber.doubleValue() * secondNumber.doubleValue();
            case DIVIDE -> firstNumber.doubleValue() / secondNumber.doubleValue();
            case MODULUS -> firstNumber.doubleValue() % secondNumber.doubleValue();
        };
        resultList.add(result);
        resultList.sort(Double::compareTo);
        return result;
    }

    public List<Double> getResultsGreaterThan(double threshold) {
        return resultList.stream()
                .filter(result -> result > threshold)
                .collect(Collectors.toList());
    }

    // getter for result
    public List<Double> getResult() {
        return resultList;
    }

    // setter for result
    public void setResult(List<Double> result) {
        this.resultList = result;
    }

    // remove last element in the resultList
    public void removeResult() {
        this.resultList.remove(resultList.size() - 1);
    }

    // sort the resultList
    public void sortResultList() {
        QuickSort.sort(this.resultList, 0, this.resultList.size());
    }
}
