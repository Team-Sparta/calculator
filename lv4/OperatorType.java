package mainHomework.lv4;

import java.util.Arrays;

public enum OperatorType {
    ADDITION('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MODULUS('%');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorType fromChar(char operator) throws BadInputException {
        return Arrays.stream(values())
                .filter(op -> op.symbol == operator)
                .findFirst()
                .orElseThrow(() -> new BadInputException("유효하지 않은 연산자입니다."));
    }
}