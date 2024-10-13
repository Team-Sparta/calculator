package mainHomework.lv4;

import jdk.jshell.JShell;
import week04.homework.BadInputException;

import java.util.ArrayList;
import java.util.List;

public abstract class Calculator {
    List<Double> resultList = new ArrayList<>();
    SortedType sortedType = SortedType.UNSORTED;

    public <T extends Number> Double calculate(T firstNumber, T secondNumber, OperatorType operator) throws ZeroDivisionException {
        Double result = switch (operator) {
            case ADDITION -> add(firstNumber, secondNumber);
            case SUBTRACT -> subtract(firstNumber, secondNumber);
            case MULTIPLY -> multiply(firstNumber, secondNumber);
            case DIVIDE -> {
                if (secondNumber.doubleValue() == 0) {
                    throw new ZeroDivisionException();
                }
                yield divide(firstNumber, secondNumber);
            }
            case MODULUS -> {
                if (secondNumber.doubleValue() == 0) {
                    throw new ZeroDivisionException();
                }
                yield modulo(firstNumber, secondNumber);
            }
        };
        resultList.add(result);
        return result;
    }

    public abstract <T extends Number> double add(T firstNumber, T secondNumber);

    public abstract <T extends Number> double subtract(T firstNumber, T secondNumber);

    public abstract <T extends Number> double multiply(T firstNumber, T secondNumber);

    public abstract <T extends Number> double divide(T firstNumber, T secondNumber);

    public abstract <T extends Number> double modulo(T firstNumber, T secondNumber);


    public Double calculateWithOneCommand(String command) throws week04.homework.BadInputException {
        Double result;
        try {
            JShell js = JShell.builder().build();
            result = Double.parseDouble(js.eval(command).get(0).value());
            resultList.add(result);
        } catch (Exception e) {
            throw new BadInputException("수식");
        }
        return result;
    }

    public List<Double> getResultsGreaterThan(double threshold) {
        return resultList.stream()
                .filter(result -> result > threshold)
                .toList();
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

    // search the resultList
    public boolean searchResultList(Double target) {
        if (sortedType == SortedType.UNSORTED) {
            return resultList.contains(target);
        } else {
            return BinarySearch.search(resultList, target) != -1;
        }
    }

    // sort the resultList
    public void sortResultList(boolean isDescending) {
        sortedType = isDescending ? SortedType.DESCENDING : SortedType.ASCENDING;
        QuickSort.sort(this.resultList, 0, this.resultList.size() - 1, isDescending);
    }
}
