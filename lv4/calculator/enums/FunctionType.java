package mainHomework.lv4.calculator.enums;

import mainHomework.lv4.calculator.function.*;
import mainHomework.lv4.calculator.operator.*;
import mainHomework.lv4.calculator.exception.BadInputException;

import java.util.Arrays;

public enum FunctionType {
    SIN("sin", new SinFunction()),
    COS("cos", new CosFunction()),
    TAN("tan", new TanFunction()),
    SQRT("sqrt", new SqrtFunction()),
    LOG("log", new LogFunction());


    private final String symbol;
    private final Function function;

    FunctionType(String symbol, Function function) {
        this.symbol = symbol;
        this.function = function;
    }

    public Function getFunction() {
        return this.function;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public static FunctionType fromString(String function) throws BadInputException {
        return Arrays.stream(values())
                .filter(op -> op.symbol.equals(function))
                .findFirst()
                .orElseThrow(() -> new BadInputException("유효하지 않은 function 입니다."));
    }
}