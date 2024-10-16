package mainHomework.lv4.calculator.operator;

import mainHomework.lv4.calculator.exception.ZeroDivisionException;

public class ModuleOperator implements Operator {
    final SubtractOperator subtractOperator = new SubtractOperator();
    final MultiplyOperator multiplyOperator = new MultiplyOperator();
    final DivideOperator divideOperator = new DivideOperator();


    @Override
    public <T extends Number> double arithmeticOperate(T firstNumber, T secondNumber) throws ZeroDivisionException {
        if (secondNumber.doubleValue() == 0) {
            throw new ZeroDivisionException();
        }
        return firstNumber.doubleValue() % secondNumber.doubleValue();
    }

    @Override
    public <T extends Number> double bitwiseOperate(T firstNumber, T secondNumber) {
        return subtractOperator.bitwiseOperate(firstNumber, multiplyOperator.bitwiseOperate(divideOperator.bitwiseOperate(firstNumber, secondNumber), secondNumber)); // a % b is a - (a / b) * b
    }
}
