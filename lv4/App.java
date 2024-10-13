package mainHomework.lv4;

import java.util.List;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BitWiseCalculator calculator = new BitWiseCalculator();

    public static void main(String[] args) {
        start();
    }

    public static void start() {

        while (true) {
            try {
                double num1 = getInput("첫 번째 숫자를 입력하세요: ", Parser::parseNum);
                double num2 = getInput("두 번째 숫자를 입력하세요: ", Parser::parseNum);
                OperatorType operator = getInput("사칙연산 기호를 입력하세요: ",
                        prompt -> Parser.parseOperator(prompt.charAt(0)));
                Double result = calculator.calculate(num1, num2, operator);

//                System.out.print("수식을 한줄에 입력해주세요: ");
//                String expression = scanner.nextLine();
//                Double result = calculator.calculateWithOneCommand(expression);

                System.out.println("결과: " + result);

                if (continueCalculation()) {
                    break;
                }

                sortResults();

                double threshold = getInput("최종 결과값들의 최소 threshold 설정하세요: ", Parser::parseNum);
                System.out.println(threshold + " 보다 큰 결과값들 : " + calculator.getResultsGreaterThan(threshold));

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FunctionalInterface
    public interface InputParser<T> {
        T parse(String input) throws BadInputException, ZeroDivisionException;
    }

    private static <T> T getInput(String prompt, InputParser<T> parser) throws BadInputException, ZeroDivisionException {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return parser.parse(input);
    }

    private static boolean continueCalculation() {
        System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
        return "exit".equalsIgnoreCase(scanner.nextLine());
    }

    private static void sortResults() {
        if (calculator.getResult().size() > 1) {
            System.out.print("결과값들을 정렬하시겠습니까? (N 입력시 스킵, A 입력시 작은 숫자부터 정렬, D 입력시 큰 숫자 부터 정렬) ");
            switch (scanner.nextLine().toUpperCase()) {
                case "N":
                    break;
                case "A":
                    calculator.sortResultList(false);
                    break;
                case "D":
                    calculator.sortResultList(true);
                    break;
                default:
                    System.out.println("잘못된 값을 입력했습니다");
                    break;
            }
        }
        displayAllResult();
    }

    private static void displayAllResult() {
        List<Double> resultList = calculator.getResult();
        System.out.println("결과값들: " + resultList);
    }

    private static void deleteLastElementInList() {
        System.out.print("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제)");
        if ("remove".equals(scanner.nextLine())) calculator.removeResult();
    }

}
