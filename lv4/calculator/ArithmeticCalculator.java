package mainHomework.lv4.calculator;

public class ArithmeticCalculator extends Calculator {

    @Override
    public <T extends Number> double add(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() + secondNumber.doubleValue();
    }

    @Override
    public <T extends Number> double subtract(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() - secondNumber.doubleValue();
    }

    @Override
    public <T extends Number> double multiply(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() * secondNumber.doubleValue();
    }

    @Override
    public <T extends Number> double divide(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() / secondNumber.doubleValue();
    }

    @Override
    public <T extends Number> double modulo(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() % secondNumber.doubleValue();
    }
}
