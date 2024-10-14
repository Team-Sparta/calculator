package mainHomework.lv4;

import mainHomework.lv4.calculator.ArithmeticCalculator;
import mainHomework.lv4.calculator.BitWiseCalculator;
import mainHomework.lv4.enums.DataStructureType;
import mainHomework.lv4.enums.OperatorType;
import mainHomework.lv4.enums.SortedType;
import mainHomework.lv4.exception.BadInputException;
import mainHomework.lv4.parser.Parser;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static ArithmeticCalculator calculator;
//    private static final BitWiseCalculator calculator = new BitWiseCalculator();

    public static void main(String[] args) {
        try {
            start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void start() throws BadInputException, InputMismatchException {

        handleDataStructureType();

        while (true) {
            try {
//                double num1 = getInput("첫 번째 숫자를 입력하세요: ", Parser::parseNum);
//                double num2 = getInput("두 번째 숫자를 입력하세요: ", Parser::parseNum);
//                OperatorType operator = getInput("사칙연산 기호를 입력하세요: ",
//                        prompt -> Parser.parseOperator(prompt.charAt(0)));
//                double result = calculator.calculate(num1, num2, operator);

                System.out.print("수식을 한줄에 입력해주세요: ");
                String expression = scanner.nextLine();
                Double result = calculator.calculateWithOneCommand(expression);

                System.out.println("결과: " + result);

                handlePostCalculation();

                if (shouldExit()) {
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void handlePostCalculation() throws BadInputException {
        handleSearchResults();
        handleThreshold();
        displayAllResults();

        if (calculator.dataStructure.size() > 1) {
            handleSortResults();
        }
    }

    private static boolean shouldExit() {
        System.out.print("더 계산하시겠습니까? [Y/n] ");
        return "n".equalsIgnoreCase(scanner.nextLine());
    }

    private static void handleDataStructureType() throws InputMismatchException, BadInputException {
        System.out.println("걀과값등을 저장할 자료구조를 선택하세요.");
        DataStructureType dataStructureType = getInput("l: List, S: Set, L: LinkedList, Q: Queue: ",
                prompt -> Parser.parseDataStructureType(prompt.charAt(0)));
        calculator = new ArithmeticCalculator(dataStructureType);

    }

    private static void handleSortResults() throws InputMismatchException, BadInputException {
        if (calculator.dataStructure.size() > 1) {
            System.out.println("결과값들을 정렬하시겠습니까?");
            SortedType sortedType = getInput("S: 스킵, A: 작은 숫자부터 정렬, D: 큰 숫자 부터 정렬: ",
                    prompt -> Parser.parseSortingCommand(prompt.charAt(0)));
            calculator.dataStructure.sort(sortedType);
        }
        displayAllResults();
    }

    private static void handleSearchResults() throws BadInputException {
        double target = getInput("결과값안에서 어떤값을 찾나요? ", Parser::parseNum);
        String response = calculator.dataStructure.contains(target) ? target + " 이 결과값안에 있습니다." : target + " 을 찾을수 없습니다.";
        System.out.println(response);
    }

    private static void handleThreshold() throws BadInputException {
        double threshold = getInput("최종 결과값들의 최소 threshold를 설정하세요: ", Parser::parseNum);
        System.out.println(threshold + "보다 큰 결과값들: " + calculator.dataStructure.getResultsGreaterThan(threshold));
    }

    private static void displayAllResults() {
        System.out.print("최종값들: ");
        calculator.dataStructure.print();
    }

    private static void deleteLastElementInList() {
        System.out.print("가장 먼저 저장된 데이터를 삭제하시겠습니까? [Y/n]");
        if ("Y".equalsIgnoreCase(scanner.nextLine())) calculator.dataStructure.removeLastElement();
    }

    @FunctionalInterface
    public interface InputParser<T> {
        T parse(String input) throws BadInputException, InputMismatchException;
    }

    private static <T> T getInput(String prompt, InputParser<T> parser) throws BadInputException, InputMismatchException {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        return parser.parse(input);
    }
}
