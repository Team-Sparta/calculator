package mainHomework.lv4.utils.enums;

import java.util.Arrays;
import java.util.InputMismatchException;

public enum SortedType {
    SKIP('S'), ASCENDING('A'), DESCENDING('D');

    private final char symbol;

    SortedType(char symbol) {
        this.symbol = symbol;
    }

    public static SortedType fromChar(char symbol) throws InputMismatchException {
        return Arrays.stream(values())
                .filter(op -> op.symbol == symbol)
                .findFirst()
                .orElseThrow(() -> new InputMismatchException("유효하지 않은 문자입니다."));
    }
}
