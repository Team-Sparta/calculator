package mainHomework.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    List<Double> resultList = new ArrayList<>();

    public Double calculate(int firstNumber, int secondNumber, char operator) {
        Double result = switch (operator) {
            case '+' -> (double) firstNumber + secondNumber;
            case '-' -> (double) firstNumber - secondNumber;
            case '*' -> (double) firstNumber * secondNumber;
            case '/' -> (double) firstNumber / secondNumber;
            case '%' -> (double) firstNumber % secondNumber;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
        resultList.add(result);
        return result;
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
}