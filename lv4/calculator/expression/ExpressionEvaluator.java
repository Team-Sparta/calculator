package mainHomework.lv4.calculator.expression;

import mainHomework.lv4.calculator.exception.BadInputException;

import java.util.List;

public class ExpressionEvaluator {

    private final Tokenizer tokenizer = new Tokenizer();
    private final PostfixConverter postfixConverter = new PostfixConverter();
    private final PostfixEvaluator postfixEvaluator = new PostfixEvaluator();

    public double evaluate(String expression) {
        List<String> tokens = tokenizer.tokenize(expression);
        List<String> postfix = null;
        postfix = postfixConverter.infixToPostfix(tokens);
        return postfixEvaluator.evaluatePostfix(postfix);
    }
}