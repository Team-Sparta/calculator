package mainHomework.lv4.calculator.parser;

import mainHomework.lv4.utils.enums.DataStructureType;
import mainHomework.lv4.calculator.enums.OperatorType;
import mainHomework.lv4.utils.enums.SortedType;
import mainHomework.lv4.utils.enums.SortingAlgorithmType;
import mainHomework.lv4.calculator.exception.BadInputException;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*%/]";
    private static final String NUMBER_REG = "^[+-]?([0-9]+(\\.[0-9]+)?|\\.[0-9]+)$";
    private static final String SAD_REG = "^[SAsAdD]$";
    private static final String DS_REG = "^[lsLQ]$";
    private static final String SA_REG = "^[qQmM]$";
    private static final String YES_NO_REG = "^[YyNn]$";


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

    public static DataStructureType parseDataStructureType(char input) throws InputMismatchException {
        if (!Pattern.matches(DS_REG, String.valueOf(input))) {
            throw new InputMismatchException(input + "은 유효하지 않은 문자입니다.");
        }
        return DataStructureType.fromChar(input);
    }

    public static SortedType parseSortedType(char input) throws InputMismatchException {
        if (!Pattern.matches(SAD_REG, String.valueOf(input))) {
            throw new InputMismatchException(input + "은 유효하지 않은 문자입니다.");
        }
        return SortedType.fromChar(input);
    }

    public static SortingAlgorithmType parseSortingAlgorithmType(char input) throws InputMismatchException {
        if (!Pattern.matches(SA_REG, String.valueOf(input))) {
            throw new InputMismatchException(input + "은 유효하지 않은 문자입니다.");
        }
        return SortingAlgorithmType.fromChar(input);
    }

}