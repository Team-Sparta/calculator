package mainHomework.lv4;

import jdk.jshell.JShell;
import week04.homework.BadInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArithmeticCalculator extends Calculator {

    List<Double> resultList = new ArrayList<>();
    boolean isSorted = false;

    public <T extends Number> Double calculate(T firstNumber, T secondNumber, OperatorType operator) throws ZeroDivisionException {
        Double result = switch (operator) {
            case ADDITION -> firstNumber.doubleValue() + secondNumber.doubleValue();
            case SUBTRACT -> firstNumber.doubleValue() - secondNumber.doubleValue();
            case MULTIPLY -> firstNumber.doubleValue() * secondNumber.doubleValue();
            case DIVIDE -> {
                if (secondNumber.doubleValue() == 0) {
                    throw new ZeroDivisionException();
                }
                yield firstNumber.doubleValue() / secondNumber.doubleValue();
            }
            case MODULUS -> {
                if (secondNumber.doubleValue() == 0) {
                    throw new ZeroDivisionException();
                }
                yield firstNumber.doubleValue() % secondNumber.doubleValue();
            }
        };
        resultList.add(result);
        return result;
    }

    public Double calculateWithOneCommand(String command) throws BadInputException {
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

    // sort the resultList
    public void sortResultList(boolean isDescending) {
        QuickSort.sort(this.resultList, 0, this.resultList.size() - 1, isDescending);
    }
}
