package mainHomework.lv4.calculator.handler;

import mainHomework.lv4.utils.enums.DataStructureType;
import mainHomework.lv4.calculator.enums.OperatorType;
import mainHomework.lv4.utils.enums.SortedType;
import mainHomework.lv4.utils.enums.SortingAlgorithmType;
import mainHomework.lv4.calculator.exception.BadInputException;
import mainHomework.lv4.calculator.parser.Parser;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    @FunctionalInterface
    public interface InputParser<T> {
        T parse(String input) throws BadInputException, InputMismatchException;
    }

    public <T> T getInput(String prompt, InputParser<T> parser) throws BadInputException, InputMismatchException {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        return parser.parse(input);
    }

    public double getDoubleInput(String prompt) throws BadInputException, InputMismatchException {
        return getInput(prompt, Parser::parseNum);
    }

    public OperatorType getOperatorInput(String prompt) throws BadInputException, InputMismatchException {
        return getInput(prompt, p -> Parser.parseOperator(p.charAt(0)));
    }

    public DataStructureType getDataStructureInput(String prompt) throws BadInputException, InputMismatchException {
        return getInput(prompt, p -> Parser.parseDataStructureType(p.charAt(0)));
    }

    public SortedType getSortedTypeInput(String prompt) throws BadInputException, InputMismatchException {
        return getInput(prompt, p -> Parser.parseSortedType(p.charAt(0)));
    }

    public SortingAlgorithmType getSortingAlgorithmInput(String prompt) throws BadInputException, InputMismatchException {
        return getInput(prompt, p -> Parser.parseSortingAlgorithmType(p.charAt(0)));
    }

    public Double getChoice(String prompt) throws BadInputException, InputMismatchException {
        return getInput(prompt, Parser::parseNum);
    }

    public double getFirstNumber() throws BadInputException, InputMismatchException {
        return getDoubleInput("첫 번째 숫자를 입력하세요: ");
    }

    public double getSecondNumber() throws BadInputException, InputMismatchException {
        return getDoubleInput("두 번째 숫자를 입력하세요: ");
    }

    public OperatorType getOperator() throws BadInputException, InputMismatchException {
        return getOperatorInput("사칙연산 기호를 입력하세요: ");
    }

    public String getExpression() {
        System.out.print("수식을 한줄에 입력해주세요: ");
        return scanner.nextLine();
    }

    public boolean shouldExit() {
        System.out.print("더 계산하시겠습니까? [Y/n] ");
        return "n".equalsIgnoreCase(scanner.nextLine());
    }
}