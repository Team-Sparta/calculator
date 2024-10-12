package mainHomework.lv3;

import java.util.List;
import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*%/]";
    private static final String NUMBER_REG = "^[+-]?([0-9]+(\\.[0-9]+)?|\\.[0-9]+)$";


    public static double parseFirstNum(String firstInput) throws BadInputException {
        if (!Pattern.matches(NUMBER_REG, firstInput)) {
            throw new BadInputException("숫자");
        }
        return Double.parseDouble(firstInput);
    }

    public static double parseSecondNum(String secondInput) throws BadInputException, ZeroDivisionError {
        if (!Pattern.matches(NUMBER_REG, secondInput)) {
            throw new BadInputException("숫자");
        }

        double secondNumber = Double.parseDouble(secondInput);
        if (secondNumber == 0) {
            throw new ZeroDivisionError();
        }
        return secondNumber;
    }

    public static OperatorType parseOperator(char operationInput) throws BadInputException {
        if (!Pattern.matches(OPERATION_REG, String.valueOf(operationInput))) {
            throw new BadInputException("연산자");
        }
        return OperatorType.fromChar(operationInput);
    }
}