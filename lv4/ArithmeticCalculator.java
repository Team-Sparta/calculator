package mainHomework.lv4;

import jdk.jshell.JShell;
import week04.homework.BadInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
