package mainHomework.lv4.calculator.expression;

import java.util.*;

public class Tokenizer {
    public List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                sb.append(c);
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '(' || c == ')' || ExpressionUtils.isOperator(String.valueOf(c))) {
                if (!sb.isEmpty()) {
                    tokens.add(sb.toString());
                    sb.setLength(0);
                }
                tokens.add(String.valueOf(c));
            } else if (c != ' ') {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }

        if (!sb.isEmpty()) {
            tokens.add(sb.toString());
        }

        return tokens;
    }
}