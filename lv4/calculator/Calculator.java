package mainHomework.lv4.calculator;

import mainHomework.lv4.calculator.operator.Operator;
import mainHomework.lv4.utils.collection.*;
import mainHomework.lv4.calculator.enums.CalculatorType;
import mainHomework.lv4.utils.enums.DataStructureType;
import mainHomework.lv4.calculator.enums.OperatorType;
import mainHomework.lv4.calculator.exception.ZeroDivisionException;
import mainHomework.lv4.calculator.exception.BadInputException;
import mainHomework.lv4.calculator.expression.ExpressionEvaluator;

public class Calculator {
    final static ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
    private final DataStructure dataStructure;

    public Calculator(DataStructureType dataStructureType) {
        this.dataStructure = dataStructureType.getDataStructure();
    }

    public <T extends Number> double calculate(T firstNumber, T secondNumber, OperatorType operatorType) throws ZeroDivisionException {
        Operator operator = operatorType.getOperator();

        double result = switch (CalculatorType.ARITHMETICS) {
            case ARITHMETICS -> operator.arithmeticOperate(firstNumber, secondNumber);
            case BITWISE -> operator.bitwiseOperate(firstNumber, secondNumber);
        };

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
            throw new BadInputException(e.getMessage());
//            throw new BadInputException("수식");
        }
        return result;
    }

    public DataStructure getDataStructure() {
        return this.dataStructure;
    }
}

