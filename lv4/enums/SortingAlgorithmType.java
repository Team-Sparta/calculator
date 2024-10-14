package mainHomework.lv4.enums;

import java.util.Arrays;
import java.util.InputMismatchException;

public enum SortingAlgorithmType {
    MERGE('M'), QUICK('Q');

    private final char symbol;

    SortingAlgorithmType(char symbol) {
        this.symbol = symbol;
    }

    public static SortingAlgorithmType fromChar(char symbol) throws InputMismatchException {
        return Arrays.stream(values())
                .filter(op -> op.symbol == symbol)
                .findFirst()
                .orElseThrow(() -> new InputMismatchException("유효하지 않은 문자입니다."));
    }
}
