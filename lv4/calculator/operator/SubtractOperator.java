package mainHomework.lv4.calculator.operator;

public class SubtractOperator implements Operator {
    final AddOperator addOperator = new AddOperator();

    @Override
    public <T extends Number> double arithmeticOperate(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() - secondNumber.doubleValue();
    }

    @Override
    public <T extends Number> double bitwiseOperate(T firstNumber, T secondNumber) {
        return addOperator.bitwiseOperate(firstNumber, addOperator.bitwiseOperate(~secondNumber.intValue() + 1, 0)); // a - b is the same as a + (~b + 1)
    }
}
