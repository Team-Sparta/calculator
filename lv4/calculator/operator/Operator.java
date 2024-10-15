package mainHomework.lv4.calculator.operator;

import mainHomework.lv4.enums.CalculatorType;
import mainHomework.lv4.exception.ZeroDivisionException;

public abstract class Operator {
    public <T extends Number> double operate(T firstNumber, T secondNumber, CalculatorType calculatorType) throws ZeroDivisionException {
        return switch (calculatorType) {
            case ARITHMETICS -> arithmeticOperate(firstNumber, secondNumber);
            case BITWISE -> bitwiseOperate(firstNumber, secondNumber);
        };
    }

    public abstract <T extends Number> double arithmeticOperate(T firstNumber, T secondNumber) throws ZeroDivisionException;

    public abstract <T extends Number> double bitwiseOperate(T firstNumber, T secondNumber);
}
