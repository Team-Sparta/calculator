package mainHomework.lv4.calculator.expression;

import mainHomework.lv4.calculator.enums.FunctionType;
import mainHomework.lv4.calculator.enums.OperatorType;
import mainHomework.lv4.calculator.exception.BadInputException;
import mainHomework.lv4.calculator.exception.ZeroDivisionException;

import java.util.HashMap;
import java.util.Map;

public class ExpressionUtils {

    //    public static final Map<String, Integer> PRECEDENCE = new HashMap<>();
    public static final Map<OperatorType, Integer> OPERATOR_PRECEDENCE = new HashMap<>();
    public static final Map<FunctionType, Integer> FUNCTION_PRECEDENCE = new HashMap<>();

    static {
        OPERATOR_PRECEDENCE.put(OperatorType.ADDITION, 1);
        OPERATOR_PRECEDENCE.put(OperatorType.SUBTRACT, 1);
        OPERATOR_PRECEDENCE.put(OperatorType.MULTIPLY, 2);
        OPERATOR_PRECEDENCE.put(OperatorType.DIVIDE, 2);
        OPERATOR_PRECEDENCE.put(OperatorType.MODULUS, 2);
        OPERATOR_PRECEDENCE.put(OperatorType.POWER, 3);
        FUNCTION_PRECEDENCE.put(FunctionType.SIN, 4);
        FUNCTION_PRECEDENCE.put(FunctionType.COS, 4);
        FUNCTION_PRECEDENCE.put(FunctionType.TAN, 4);
        FUNCTION_PRECEDENCE.put(FunctionType.SQRT, 4);
        FUNCTION_PRECEDENCE.put(FunctionType.LOG, 4);
    }

    public static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOperator(String token) {
        return OperatorType.isOperator(token.charAt(0));
    }

    public static int getPriority(String token) {
        try {
            // Check if token is an operator
            if (isOperator(token)) {
                return OPERATOR_PRECEDENCE.get(OperatorType.fromChar(token.charAt(0)));
            }
            // Check if token is a function
            if (isFunction(token)) {
                return FUNCTION_PRECEDENCE.get(FunctionType.fromString(token.toLowerCase()));
            }
            throw new IllegalArgumentException("Unknown token: " + token);
        } catch (BadInputException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isFunction(String token) {
        return "sin".equals(token) || "cos".equals(token) || "tan".equals(token) || "sqrt".equals(token) || "log".equals(token);
    }

    public static double applyOperator(String operator, double a, double b) {
        try {
            OperatorType operatorType = OperatorType.fromChar(operator.charAt(0));
            return operatorType.getOperator().arithmeticOperate(a, b);
        } catch (BadInputException | ZeroDivisionException e) {
            throw new RuntimeException(e);
        }
    }

    public static double applyFunction(String function, double a) {
        try {
            FunctionType functionType = FunctionType.fromString(function.toLowerCase());
            return functionType.getFunction().operate(a);
        } catch (BadInputException e) {
            throw new RuntimeException(e);
        }
    }
}