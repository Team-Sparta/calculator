package mainHomework.lv4;

public abstract class Calculator {
    public abstract <T extends Number> Double calculate(T firstNumber, T secondNumber, OperatorType operator) throws ZeroDivisionException;
}
