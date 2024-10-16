package mainHomework.lv4.calculator.expression;

import java.util.HashMap;
import java.util.Map;

public class ExpressionUtils {

    public static final Map<String, Integer> PRECEDENCE = new HashMap<>();

    static {
        PRECEDENCE.put("+", 1);
        PRECEDENCE.put("-", 1);
        PRECEDENCE.put("*", 2);
        PRECEDENCE.put("/", 2);
        PRECEDENCE.put("^", 3);
        PRECEDENCE.put("sin", 4);
        PRECEDENCE.put("cos", 4);
        PRECEDENCE.put("tan", 4);
        PRECEDENCE.put("sqrt", 4);
        PRECEDENCE.put("log", 4);
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
        return PRECEDENCE.containsKey(token) && !isFunction(token);
    }

    public static boolean isFunction(String token) {
        return "sin".equals(token) || "cos".equals(token) || "tan".equals(token) || "sqrt".equals(token) || "log".equals(token);
    }

    public static double applyOperator(String operator, double a, double b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            case "^" -> Math.pow(a, b);
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }

    public static double applyFunction(String function, double a) {
        return switch (function) {
            case "sin" -> Math.sin(Math.toRadians(a));
            case "cos" -> Math.cos(Math.toRadians(a));
            case "tan" -> Math.tan(Math.toRadians(a));
            case "sqrt" -> Math.sqrt(a);
            case "log" -> Math.log10(a);
            default -> throw new IllegalArgumentException("Unknown function: " + function);
        };
    }
}