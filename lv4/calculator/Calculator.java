package mainHomework.lv4.calculator;

import jdk.jshell.JShell;
import mainHomework.lv4.enums.OperatorType;
import mainHomework.lv4.enums.SortedType;
import mainHomework.lv4.algorithm.BinarySearch;
import mainHomework.lv4.algorithm.QuickSort;
import mainHomework.lv4.exception.ZeroDivisionException;
import week04.homework.BadInputException;

import java.util.ArrayList;
import java.util.List;

public abstract class Calculator {
    List<Double> resultList = new ArrayList<>();
    SortedType sortedType = SortedType.UNSORTED;
    final static ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

    public <T extends Number> double calculate(T firstNumber, T secondNumber, OperatorType operator) throws ZeroDivisionException {
        double result = switch (operator) {
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
//            JShell js = JShell.builder().build();
//            result = Double.parseDouble(js.eval(command).get(0).value());

            result = expressionEvaluator.evaluate(command);
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
    public void sortResultList(String response) {
        switch (response) {
            case "N":
                sortedType = SortedType.UNSORTED;
                break;
            case "A":
                sortedType = SortedType.ASCENDING;
                break;
            case "D":
                sortedType = SortedType.DESCENDING;
                break;
            default:
                System.out.println("잘못된 값을 입력했습니다");
                break;
        }
        QuickSort.sort(this.resultList, 0, this.resultList.size() - 1, sortedType);
    }
}
