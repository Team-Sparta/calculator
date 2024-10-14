package mainHomework.lv4.calculator;

import mainHomework.lv4.dataStructure.*;
import mainHomework.lv4.enums.DataStructureType;
import mainHomework.lv4.enums.OperatorType;
import mainHomework.lv4.exception.ZeroDivisionException;
import week04.homework.BadInputException;

public abstract class Calculator {
    final static ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
    public DataStructure dataStructure;

    public Calculator(DataStructureType dataStructureType) {
        this.dataStructure = switch (dataStructureType) {
            case LIST -> new ArrayListStructure();
            case SET -> new HashSetStructure();
            case LINKEDLIST -> new LinkedListStructure();
            case QUEUE -> new QueueStructure();
        };
    }


    public <T extends Number> double calculate(T firstNumber, T secondNumber, OperatorType operator) throws ZeroDivisionException {
        double result = switch (operator) {
            case ADDITION -> add(firstNumber, secondNumber);
            case SUBTRACT -> subtract(firstNumber, secondNumber);
            case MULTIPLY -> multiply(firstNumber, secondNumber);
            case DIVIDE -> {
                if (secondNumber.doubleValue() == 0) {
                    throw new ZeroDivisionException();
                }
                yield divide(firstNumber, secondNumber);
            }
            case MODULUS -> {
                if (secondNumber.doubleValue() == 0) {
                    throw new ZeroDivisionException();
                }
                yield modulo(firstNumber, secondNumber);
            }
        };
        dataStructure.add(result);
        return result;
    }

    public abstract <T extends Number> double add(T firstNumber, T secondNumber);

    public abstract <T extends Number> double subtract(T firstNumber, T secondNumber);

    public abstract <T extends Number> double multiply(T firstNumber, T secondNumber);

    public abstract <T extends Number> double divide(T firstNumber, T secondNumber);

    public abstract <T extends Number> double modulo(T firstNumber, T secondNumber);


    public Double calculateWithOneCommand(String command) throws week04.homework.BadInputException {
        Double result;
        try {
//            JShell js = JShell.builder().build();
//            result = Double.parseDouble(js.eval(command).get(0).value());

            result = expressionEvaluator.evaluate(command);
            this.dataStructure.add(result);
        } catch (Exception e) {
            throw new BadInputException("수식");
        }
        return result;
    }
}
