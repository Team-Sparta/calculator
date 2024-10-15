package mainHomework.lv4.calculator;

import mainHomework.lv4.collection.*;
import mainHomework.lv4.enums.CalculatorType;
import mainHomework.lv4.enums.DataStructureType;
import mainHomework.lv4.enums.OperatorType;
import mainHomework.lv4.exception.ZeroDivisionException;
import mainHomework.lv4.exception.BadInputException;

public class Calculator {
    final static ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
    private final DataStructure dataStructure;

    public Calculator(DataStructureType dataStructureType) {
        this.dataStructure = dataStructureType.getDataStructure();
    }

    public <T extends Number> double calculate(T firstNumber, T secondNumber, OperatorType operatorType) throws ZeroDivisionException {
        double result = operatorType.getOperator().operate(firstNumber, secondNumber, CalculatorType.ARITHMETICS);
        this.dataStructure.add(result);
        return result;
    }

    public Double calculateWithOneCommand(String command) throws BadInputException {
        Double result;
        try {
            // Using Build-in Library
//            JShell js = JShell.builder().build();
//            result = Double.parseDouble(js.eval(command).get(0).value());
            result = expressionEvaluator.evaluate(command);
            this.dataStructure.add(result);
        } catch (Exception e) {
            throw new BadInputException("수식");
        }
        return result;
    }

    public DataStructure getDataStructure() {
        return this.dataStructure;
    }
}
