package mainHomework.lv4.parser;

import mainHomework.lv4.enums.OperatorType;
import mainHomework.lv4.exception.BadInputException;

import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*%/]";
    private static final String NUMBER_REG = "^[+-]?([0-9]+(\\.[0-9]+)?|\\.[0-9]+)$";


    public static double parseNum(String numInput) throws BadInputException {
        if (!Pattern.matches(NUMBER_REG, numInput)) {
            throw new BadInputException("숫자");
        }
        return Double.parseDouble(numInput);
    }

    public static OperatorType parseOperator(char operationInput) throws BadInputException {
        if (!Pattern.matches(OPERATION_REG, String.valueOf(operationInput))) {
            throw new BadInputException("연산자");
        }
        return OperatorType.fromChar(operationInput);
    }
}