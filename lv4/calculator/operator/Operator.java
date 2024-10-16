package mainHomework.lv4.calculator.operator;

import mainHomework.lv4.calculator.exception.ZeroDivisionException;

public interface Operator {

    <T extends Number> double arithmeticOperate(T firstNumber, T secondNumber) throws ZeroDivisionException;

    <T extends Number> double bitwiseOperate(T firstNumber, T secondNumber);
}
