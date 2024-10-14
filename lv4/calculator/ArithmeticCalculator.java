package mainHomework.lv4.calculator;

import mainHomework.lv4.enums.DataStructureType;

public class ArithmeticCalculator extends Calculator {

    public ArithmeticCalculator(DataStructureType dataStructureType) {
        super(dataStructureType);
    }

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
