package mainHomework.lv4.calculator.operator;

import mainHomework.lv4.calculator.exception.ZeroDivisionException;

public class PowerOperator implements Operator {
    @Override
    public <T extends Number> double arithmeticOperate(T firstNumber, T secondNumber) throws ZeroDivisionException {
        return Math.pow((Double) firstNumber, (Double) secondNumber);
    }

    @Override
    public <T extends Number> double bitwiseOperate(T firstNumber, T secondNumber) {
        return Math.pow((Double) firstNumber, (Double) secondNumber);
    }
}
