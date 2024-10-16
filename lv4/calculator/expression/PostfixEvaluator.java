package mainHomework.lv4.calculator.expression;

import java.util.*;

public class PostfixEvaluator {
    public double evaluatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (ExpressionUtils.isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (ExpressionUtils.isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(ExpressionUtils.applyOperator(token, a, b));
            } else if (ExpressionUtils.isFunction(token)) {
                double a = stack.pop();
                stack.push(ExpressionUtils.applyFunction(token, a));
            }
        }

        return stack.pop();
    }
}