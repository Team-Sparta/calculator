package mainHomework.lv4.calculator.enums;

import mainHomework.lv4.calculator.operator.PowerOperator;
import mainHomework.lv4.calculator.operator.*;
import mainHomework.lv4.calculator.exception.BadInputException;

import java.util.Arrays;

public enum OperatorType {
    ADDITION('+', new AddOperator()),
    SUBTRACT('-', new SubtractOperator()),
    MULTIPLY('*', new MultiplyOperator()),
    DIVIDE('/', new DivideOperator()),
    MODULUS('%', new ModuleOperator()),
    POWER('^', new PowerOperator());

    private final char symbol;
    private final Operator operator;

    OperatorType(char symbol, Operator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public Operator getOperator() {
        return this.operator;
    }

    public Character getSymbol() {
        return this.symbol;
    }

    public static OperatorType fromChar(char operator) throws BadInputException {
        return Arrays.stream(values())
                .filter(op -> op.symbol == operator)
                .findFirst()
                .orElseThrow(() -> new BadInputException("유효하지 않은 연산자입니다."));
    }

    public static boolean isOperator(char symbol) {
        return Arrays.stream(values()).anyMatch(op -> op.symbol == symbol);
    }
}