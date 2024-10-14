package mainHomework.lv4.enums;

import java.util.Arrays;
import java.util.InputMismatchException;

public enum DataStructureType {
    LIST('l'), SET('S'), LINKEDLIST('L'), QUEUE('Q');

    private final char symbol;

    DataStructureType(char symbol) {
        this.symbol = symbol;
    }

    public static DataStructureType fromChar(char symbol) throws InputMismatchException {
        return Arrays.stream(values())
                .filter(op -> op.symbol == symbol)
                .findFirst()
                .orElseThrow(() -> new InputMismatchException("유효하지 않은 문자입니다."));
    }
}
