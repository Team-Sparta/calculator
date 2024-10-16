package mainHomework.lv4.calculator.expression;

import java.util.*;

public class PostfixConverter {
    private static final Map<String, Integer> PRECEDENCE = ExpressionUtils.PRECEDENCE;

    public List<String> infixToPostfix(List<String> infix) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String token : infix) {
            if (ExpressionUtils.isNumber(token)) {
                postfix.add(token);
            } else if (ExpressionUtils.isFunction(token)) {
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.add(stack.pop());
                }
                if (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (ExpressionUtils.isFunction(pop)) {
                        postfix.add(pop);
                    }
                }
            } else if (ExpressionUtils.isOperator(token)) {
                while (!stack.isEmpty() && ExpressionUtils.isOperator(stack.peek()) &&
                        PRECEDENCE.get(stack.peek()) >= PRECEDENCE.get(token)) {
                    postfix.add(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }
}
