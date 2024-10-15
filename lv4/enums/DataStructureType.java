package mainHomework.lv4.enums;

import mainHomework.lv4.collection.*;

import java.util.Arrays;
import java.util.InputMismatchException;

public enum DataStructureType {
    LIST('l', new ArrayListStructure()), SET('S', new HashSetStructure()), LINKEDLIST('L', new LinkedListStructure()), QUEUE('Q', new QueueStructure());

    private final char symbol;
    private final DataStructure dataStructure;

    DataStructureType(char symbol, DataStructure dataStructure) {
        this.symbol = symbol;
        this.dataStructure = dataStructure;
    }

    public DataStructure getDataStructure() {
        return this.dataStructure;
    }

    public static DataStructureType fromChar(char symbol) throws InputMismatchException {
        return Arrays.stream(values())
                .filter(op -> op.symbol == symbol)
                .findFirst()
                .orElseThrow(() -> new InputMismatchException("유효하지 않은 문자입니다."));
    }
}
